package com.rana.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AllHeapProblems {
    public static void main(String[] args) {
        System.out.println(frequencySort("ttreesstiooi"));
    }

    //LC 451
    public static String frequencySort(String s){
        if(s == null || s.isEmpty()) return "";
        int[] count = new int[128];
        char[] chars = s.toCharArray();
        for(char c : chars){
            count[c] += 1;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(count[o1] == count[o2]){
                    return o1 - o2;
                }
                return count[o2] - count[o1];
            }
        });
        for(char c : chars){
            pq.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}
