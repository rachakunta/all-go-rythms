package com.rana.trie;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    TrieNode[] nodes;
    boolean isWord;
    String word;

    public TrieNode() {
        nodes = new TrieNode[26];
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode dummy = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (root.nodes[c] == null) {
                    root.nodes[c] = new TrieNode();
                }
                root = root.nodes[c];
            }
            root.isWord = true;
            root.word = word;
            root = dummy;
        }

        public boolean search(String word){
            TrieNode dummy = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (dummy.nodes[c] == null) {
                    return false;
                }
                dummy = dummy.nodes[c];
            }
            return dummy.isWord;
        }

        public boolean startsWith(String prefix){
            TrieNode dummy = root;
            for (int i = 0; i < prefix.length(); i++) {
                int c = prefix.charAt(i) - 'a';
                if (dummy.nodes[c] == null) {
                    return false;
                }
                dummy = dummy.nodes[c];
            }
            return true;
        }

        public boolean searchWithDot(String word){
            return helper(word.toCharArray(), 0, root);
        }

        private boolean helper(char[] toCharArray, int start, TrieNode root) {
            if(start == toCharArray.length){
                return root.isWord;
            }
            char c = toCharArray[start];
            if(c == '.') {
                for (int i = 0; i < root.nodes.length; i++) {
                    if ((root.nodes[i] != null && helper(toCharArray, start + 1, root.nodes[i]))) {
                        return true;
                    }
                }
            }
            else{
                return root.nodes[c - 'a'] != null && helper(toCharArray, start + 1 , root.nodes[c -'a']);
                }
            return false;
        }

        public List<String> findWords(char[][] board, String[] words){
            TrieNode root = buildTree(words);
            List<String> res = new ArrayList<>();
            for(int i=0; i< board.length;i++){
                for(int j = 0; j< board[0].length; j++){
                    findWords(board, root, res, i, j);
                }
            }
            return res;
        }

        private void findWords(char[][] board, TrieNode root, List<String> res, int i, int j) {
            char c = board[i][j];
            if(c == '#' || root.nodes[c - 'a'] == null){
                return;
            }
            root = root.nodes[c - 'a'];
            if(root != null && root.isWord){
                res.add(root.word);
                root.word = null;
            }
            board[i][j] = '#';
            if(i < board.length -1)findWords(board, root, res, i+1, j);
            if(i > 0)findWords(board, root, res, i-1, j);
            if(j < board[0].length - 1)findWords(board, root, res, i, j+1);
            if(j > 0)findWords(board, root, res, i, j-1);
            board[i][j] = c;
        }


        private TrieNode buildTree(String[] words) {
            for(String s : words){
                insert(s);
            }
            return root;
        }

        public String longestWord(String[] words) {
            buildTree2(words);
            for(String s : words){
                if(search(s)){
                    return s;
                }
            }
            return "";
        }

        private void buildTree2(String[] words) {
            int len = 0;
            for(String word : words){
                TrieNode dummy = root;
                len++;
                for (int i = 0; i < word.length(); i++) {
                    int c = word.charAt(i) - 'a';
                    if (root.nodes[c] == null) {
                        root.nodes[c] = new TrieNode();
                        root.isWord = false;
                    }
                    root = root.nodes[c];
                }
                root.isWord = true;
                root.word = word;
                root = dummy;
            }
        }
    }
}
