package com.rana.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllDFSProblems {
    public static void main(String[] args) {
        System.out.println(removeInvalidParenthesis("())())"));
    }

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
}
