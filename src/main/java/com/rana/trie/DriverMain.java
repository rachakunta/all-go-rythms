package com.rana.trie;

import java.util.Arrays;

public class DriverMain {
    public static void main(String[] args) {
        TrieNode.Trie root = new TrieNode.Trie();
        root.insert("rachakunta");
        System.out.println(root.search("rachakunta"));
        root.insert("naga");
        System.out.println(root.search("nag"));
        System.out.println(root.startsWith("rachk"));
        System.out.println(root.startsWith("racha"));
        System.out.println(root.searchWithDot("n.ga"));
        char[][] words = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'},
                {'r','a','c','h'},
                {'n','u','k','a'},
                {'t', 'a','s','n'}
        };
        System.out.println(root.findWords(words, new String[]{"oath","pea","eat","rain", "rachakunta"}));
        System.out.println(root.longestWord(new String[]{"a", "banana", "ap", "app", "appl", "apple", "apply"}));
    }
}
