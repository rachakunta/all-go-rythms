package com.rana.strings;

import java.util.*;

public class AllStringProblems {
    public static void main(String[] args) {
        //String[] s = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] s = {"samantha", "samanth", "saman", "sam"};
        //String begin = "hit", end = "cog";
        //System.out.println(ladderLength(begin, end, Arrays.asList(s)));
        //System.out.println(longestNonRepeatSubstring("a"));
        //System.out.println(regularExpressionMatch("abcsdfsdfxxxx", "abc.*x"));
        //System.out.println(regularExpressionMatch("abcsdfsdfxxxx", "abcd*x"));
        //System.out.println(canConstruct("aaa", "ababaab"));
        //String[] strings = {"900 mail.google.com", "10 mail.yahoo.com", "50 yahoo.com", "11 com"};
        //System.out.println(subdomainVisits(strings));
        //System.out.println(longestPalindrome("aaa"));
        //System.out.println(zigzagConvertion("PAYPALISHIRING", 3));
        //System.out.println(longestCommonPrefix(s));
        //System.out.println(letterCombinations("2345"));
        //System.out.println(validParanthesis("()())"));
        //System.out.println(generateParenthesis(2));
        //System.out.println(strStr("rachakunta", "kunta"));
        String[] anagrams = {"rana", "anra", "naar", "ant", "tan", "nat", "sri"};
        System.out.println(groupAnagrams(anagrams));
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

    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i< cpdomains.length; i++){
            String[] s = cpdomains[i].split(" ");
            while(!s[1].isEmpty()){
                if(!map.containsKey(s[1])){
                    map.put(s[1], Integer.valueOf(s[0]));
                }
                else{
                    map.put(s[1], map.get(s[1]) + Integer.parseInt(s[0]));
                }
                int idx = s[1].indexOf(".");
                if(idx == -1) break;
                s[1] = s[1].substring(idx + 1, s[1].length());
            }
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            list.add(entry.getValue() +" "+entry.getKey());
        }
        //System.out.println(map.keySet()+" "+map.values());
        return list;
    }

    //LP 5
    public static String longestPalindrome(String s) {
        int len = 0, len1 = 0, len2 = 0, end = 0, start = 0;
        for(int i = 0; i< s.length(); i++){
            len1 = expandFromCenter(i, i, s);
            len2 = expandFromCenter(i, i+1, s);
            len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(int l, int r, String s){
        while (l >=0 && r< s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
        return r - l - 1;
    }

    public static String zigzagConvertion(String s, int rows){
        if(rows == 1) return s;
        List<StringBuilder> sb = new ArrayList<>();
        for(int i=0; i< Math.min(rows, s.length()); i++){
            sb.add(new StringBuilder());
        }

        int row = 0;
        boolean down = false;

        for(char c : s.toCharArray()){
            sb.get(row).append(c);
            if(row == 0 || row == rows - 1){
                down = !down;
            }
            row += down ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for(int i =0; i< rows; i++){
            res.append(sb.get(i));
        }
        return res.toString();
    }

    /*public static String longestCommonPrefix(String[] strings){
        int[] chars = new int[26];
        for(int i=0; i< strings.length; i++){
            insertHelper(chars, i, strings[i]);
        }

        if(chars[strings[0].charAt(0) -'a'] == 1) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(int i = 0; i< strings[0].length(); i++){
            char c = strings[0].charAt(i);
            if(chars[c - 'a'] == strings.length){
                s.append(c);
            }
            else{
                break;
            }
        }
        return s.toString();
    }

    private static void insertHelper(int[] chars, int i, String s){
        for(char c : s.toCharArray()){
            int cr = c - 'a';
            if(chars[cr] == i){
                chars[cr] += 1;
            }
            else{
                break;
            }
        }
    }*/

    public static String longestCommonPrefix(String[] strings){
        StringBuilder sb = new StringBuilder(strings[0]);
        for(String s : strings){
            while(s.indexOf(sb.toString()) != 0){
                sb.deleteCharAt(sb.length() - 1);
            }

            if(sb.length() == 0){
                return "";
            }
        }
        return sb.toString();
    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> res =  new LinkedList<>();
        res.add("");
        String[] mapping = {"", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i=0; i< digits.length(); i++){
            String st = mapping[digits.charAt(i) - '0'];
            while(res.peek().length() == i){
                String s = res.remove();
                for(int j=0; j< st.length();j++){
                    res.add(s + st.charAt(j));
                }
            }
        }
        return res;
    }

    public static boolean validParanthesis(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            switch (c){
                case '(' : stack.push(')');
                        break;
                case '[' : stack.push(']');
                    break;
                case '{' : stack.push('}');
                    break;
                default: if(stack.empty() || stack.pop() != c){
                    return false;
                }
            }
        }
        return true;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        dfs(ans, n,n, new StringBuilder());
        return ans;
    }

    private static void dfs(List<String> ans, int l, int r, StringBuilder stringBuilder) {
        if(r < l){
            return;
        }
        if(l == 0 && r == 0){
            ans.add(stringBuilder.toString());
            return;
        }

        if(l >0){
            stringBuilder.append("(");
            dfs(ans, l - 1,r,stringBuilder);
        }
        int s = stringBuilder.length();
        if(r >0){
            stringBuilder.append(")");
            dfs(ans, l,r - 1,stringBuilder);
        }
        stringBuilder.delete(Math.max(0, s - 1), stringBuilder.length());
    }

    public static int strStr(String haystack, String needle) {
        for(int i=0; i<= haystack.length() - needle.length(); i++){
            for(int j=0; j< needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++){
                if(j == needle.length() -1){
                    return i;
                }
            }
        }
        return -1;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String st = Arrays.toString(chars);
            if(!map.containsKey(st)) {
                map.put(st, new ArrayList<String>());
            }
                map.get(st).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
