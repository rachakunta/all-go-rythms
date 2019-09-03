package com.rana.strings;

import java.util.*;

public class AllStringProblems {
    public static void main(String[] args) {
        String[] s = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit", end = "cog";
        //System.out.println(ladderLength(begin, end, Arrays.asList(s)));
        //System.out.println(longestNonRepeatSubstring("a"));
        //System.out.println(regularExpressionMatch("abcsdfsdfxxxx", "abc.*x"));
        //System.out.println(regularExpressionMatch("abcsdfsdfxxxx", "abcd*x"));
        System.out.println(canConstruct("aaa", "ababaab"));
    }

    //LP 127
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int result = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String polled = q.poll();
                char[] chars = polled.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char temp = chars[i];
                    for (char t = 'a'; t < 'z'; t++) {
                        chars[i] = t;
                        String s = new String(chars);
                        if (set.contains(s)) {
                            if (s.equals(endWord)) return result + 1;
                            q.add(s);
                            set.remove(s);
                        }
                    }
                    chars[i] = temp;
                }
            }
            result++;
        }
        return 0;
    }

    //LP 3
    public static int longestNonRepeatSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, length = 0, fS = 0, fE = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            j = Math.max(j, map.getOrDefault(c, 0));
            map.put(c, i + 1);
            if (length < i - j + 1) {
                start = j;
                end = i + 1;
            }
            length = Math.max(length, i - j + 1);
        }
        System.out.println(s.substring(start, end));
        return length;
    }

    //LP 10
    public static boolean regularExpressionMatch(String text, String pattern){
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i< dp[0].length; i++){
            if(pattern.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 2];
            }
        }

        for(int i=1; i< dp.length; i++){
            for(int j =1; j< dp[0].length;j++){
                if(text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pattern.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if(pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }

    //LP 383
    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] r = new int[26];
        for(char c : ransomNote.toCharArray()){
            r[c -'a']++;
        }
        for(char c : magazine.toCharArray()){
            if(r[c - 'a'] != 0){
                r[c - 'a']--;
            }
        }
        for(int i=0; i< 26; i++){
            if(r[i] > 0){
                return false;
            }
        }
        return true;
    }
}
