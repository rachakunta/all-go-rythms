package com.rana.dfs;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllDFSProblems {
    public static void main(String[] args) {
        System.out.println(removeInvalidParenthesis("())())"));
    }

    //LC 301
    public static List<String> removeInvalidParenthesis(String s){
        List<String> ans = new ArrayList<>();
        helper(ans, s, 0,0,new char[]{'(', ')'});
        return ans;
    }

    private static void helper(List<String> ans, String s, int iStart, int jStart, char[] chars) {
        int count = 0;
        for(int i= iStart; i<s.length(); i++){
            if(s.charAt(i) == chars[0]) count++;
            if(s.charAt(i) == chars[1]) count--;
            if(count >=0){
                continue;
            }
            for(int j = jStart; j <= i; j++){ // iStart and jStart is to remember where was the last i or j.
                if(s.charAt(j) == chars[1] && (j == jStart || s.charAt(j - 1) != chars[1])){
                    helper(ans, s.substring(0, j) + s.substring(j+1, s.length()), i, j, chars);
                }
            }
            return;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if(chars[0] == '('){ // to remove invalid ')' char
            helper(ans, reverse, 0,0, new char[]{')', '('});
        }
        else{
            ans.add(reverse);
        }
    }

    //LC 490
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // to traverse all directions
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] polled = q.poll();

            if(polled[0] == destination[0] && polled[1] == destination[1]){
                return true; // found dest
            }

            for(int[] dir : dirs){
                int x = polled[0] + dir[0];
                int y = polled[1] + dir[1];
                while(isValid(x, y, maze.length, maze[0].length) && maze[x][y] == 0) {// to find the end of the wall
                    x += dir[0];
                    y += dir[1];
                }

                if(!visited[x - dir[0]][y - dir[1]]){
                    visited[x - dir[0]][y - dir[1]] = true;
                    q.add(new int[]{x - dir[0], y - dir[1]});
                }
            }
        }
        return false;
    }

    private static boolean isValid(int x, int y, int length, int width){
        return x>=0 && y>=0 && x< length && y< width;
    }
}
