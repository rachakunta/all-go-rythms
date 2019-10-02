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
        String[] strings = {"900 mail.google.com", "10 mail.yahoo.com", "50 yahoo.com", "11 com"};
        //System.out.println(subdomainVisits(strings));
        //System.out.println(longestPalindrome("aaa"));
        //System.out.println(zigzagConvertion("PAYPALISHIRING", 3));
        //System.out.println(longestCommonPrefix(s));
        //System.out.println(letterCombinations("2345"));
        //System.out.println(validParanthesis("()())"));
        //System.out.println(generateParenthesis(2));
        //System.out.println(strStr("rachakunta", "kunta"));
        String[] anagrams = {"rana", "anra", "naar", "ant", "tan", "nat", "sri"};
        //System.out.println(groupAnagrams(anagrams));
        //System.out.println(countAndSay(5));
        //System.out.println(multiply("", "99"));
        //System.out.println(intString("5a1b3c"));
        String[] strings2 = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBa";
        //System.out.println(camelMatch(strings,pattern));
        String[] ss =  {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        //System.out.println(numMatchingSubseq("dsahjpjauf", ss));
        //calculateClicksByDomain(strings);
        //findAndReplacePattern(new String[]{"badc","abab","dddd","dede","yyxx"}, "didi");
        String[][] places = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        System.out.println(findItinerary(places));
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

    public static String countAndSay(int n) {
        if(n == 1) return "1";
        StringBuilder sb = new StringBuilder();
        String prev = countAndSay( n-1);
        int start =0, end = prev.length();
        while(start < end){
            char curr = prev.charAt(start);
            int count =0;
            while(count + start < end && prev.charAt(count + start) == curr){
                count++;
            }
            sb.append(count);
            sb.append(curr);
            start = start + count;
        }
        return sb.toString();
    }

    public static String multiply(String num1, String num2) {
        int s1 = num1.length();
        int s2 = num2.length();
        int dp[] = new int[s1 + s2];
        for(int i= s1 - 1; i>= 0; i--){
            for(int j= s2 -1; j>=0; j--){
                int c1 = num1.charAt(i) - '0';
                int c2 = num2.charAt(j) - '0';
                dp[i + j + 1] += c1 * c2;
            }
        }
        int carry =0;
        for(int i = dp.length - 1; i>=0; i--){
            int num = dp[i] + carry;
            dp[i] = num % 10;
            carry = num / 10;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i : dp){
            if(i != 0){
                flag = true;
            }
            if(flag){
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static String intString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            int times = 0;
            int chars = s.charAt(i) - '0';
            int t = i;
            while(0 <=chars && chars <=9){
                times = times * 10 + chars;
                if(i + 1 < s.length()){
                    chars = s.charAt(++i) - '0';
                }
            }
            if(t != i){
                while(times-- >0){
                    sb.append(s.charAt(i));
                }
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    //LP 1023
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
            for(int j = 0; j< queries.length; j++){
                ans.add(checkString(queries[j], pattern));
            }
            return ans;
    }

    private static Boolean checkString(String query, String pattern) {
        int j=0;
        for(int k = 0; k< query.length(); k++){
            char c = query.charAt(k);
            if((j< pattern.length() && pattern.charAt(j) == c)){
                j++;
            }
            else if(Character.isUpperCase(c)){
                return false;
            }
        }
        return j == pattern.length();
    }

    //LC 792
    public static int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        ArrayList<HashSet<StringBuilder>>[] chars = new ArrayList[26];
        for(int i=0; i< 26; i++){
            chars[i] = new ArrayList<>();
        }
        int i=0;
        for(String word : words){
            HashSet<StringBuilder> map = new HashSet<>();
            map.add(new StringBuilder(word));
            chars[word.charAt(0) - 'a'].add(map);
        }
        for(char s : S.toCharArray()){
            boolean bl = chars[s - 'a'].isEmpty();
            if(bl) continue;
            ArrayList<HashSet<StringBuilder>> backup = chars[s - 'a'];
            chars[s - 'a'] = new ArrayList<>();
            for(HashSet<StringBuilder> map : backup) {
                for (StringBuilder k : map) {
                    k.deleteCharAt(0);
                    if (k.length() == 0) {
                        ++res;
                    } else {
                        HashSet<StringBuilder> mp = new HashSet<>();
                        mp.add(new StringBuilder(k));
                        chars[k.charAt(0) - 'a'].add(mp);
                    }
                }
            }
        }
        return res;
    }

    private static HashMap<String,Integer> calculateClicksByDomain(String[] counts){
        HashMap<String, Integer> res = new HashMap<>();
        for(String s : counts){
            String[] splits = s.split(" ");
            int value = Integer.parseInt(splits[0]);
            String key = splits[1];
            while(true){
                if(res.containsKey(key)){
                    res.put(key, value + res.get(key));
                }
                else{
                    res.put(key, value);
                }
                int idx = key.indexOf(".");
                if(idx == -1) break;
                key = key.substring(idx + 1);
            }
        }
        System.out.println(res);
        return res;
    }

    //LC 890
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int[] patternCount = helperFindAndReplacePattern(pattern);
        for(String s : words){
            int[] count = helperFindAndReplacePattern(s);
            if(s.length() == pattern.length() && Arrays.equals(count, patternCount)){
                res.add(s);
            }
        }
        System.out.println(res);
        return res;
    }

    private static int[] helperFindAndReplacePattern(String pattern){
        int len = pattern.length();
        int[] n = new int[len];
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int i =0;
        for(char c : pattern.toCharArray()){
            map.putIfAbsent(c, i);
            n[i] = map.get(c);
            i++;
        }
        return n;
    }

    public static List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();

        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }
}
