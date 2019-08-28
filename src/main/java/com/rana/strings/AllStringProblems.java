package com.rana.strings;

import java.util.*;

public class AllStringProblems {
    public static void main(String[] args) {
        String[] s = {"hot","dot","dog","lot","log","cog"};
        String begin = "hit", end = "cog";
        System.out.println(ladderLength(begin, end, Arrays.asList(s)));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int result = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k< size; k++) {
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
}
