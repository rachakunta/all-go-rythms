package com.rana.arrays;

import java.util.ArrayList;
import java.util.List;

public class AllArrayProblems {

    public static int singleNumber(int[] nums){
        int x =0;
        for(int n : nums){
            x = x ^ n;
        }
        return x;
    }

    public static int maxProfit3(int[] prices){
        int minPrice1 = Integer.MAX_VALUE;
        int minPrice2 = Integer.MAX_VALUE;
        int profit1 = 0;
        int profit2 = 0;
        for(int price : prices){
            minPrice1 = Math.min(minPrice1, price);
            profit1 = Math.max(profit1, price - minPrice1);
            minPrice2 = Math.min(minPrice2, price - profit1);
            profit2 = Math.max(profit2, price - minPrice2);
        }
        return profit2;
    }

    public static List<Integer> countOfNumbers(int[] nums){
        List<Integer> list = new ArrayList<>();
        int end = nums.length;
        int count=1;
        for (int i=1; i< end; i++){
            while(i <end && nums[i] != nums[i -1]){
                list.add(count);
                count =1;
                i++;
            }
            count++;
        }
        if(count>0){
            list.add(count);
        }
        return list;
    }

    public static void rotate(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
