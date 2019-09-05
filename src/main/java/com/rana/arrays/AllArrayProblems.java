package com.rana.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllArrayProblems {
    public static void main(String[] args) {
        System.out.println(trappingRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

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

    public static int trappingRainWater(int[] heights){
        if(heights == null || heights.length == 0){
            return 0;
        }
        int maxHeightSoFar = 0, l = 0, r = heights.length - 1, res = 0;;
        while (l < r){
            int smallest = heights[ heights[l] < heights[r] ? l++ : r--];
            maxHeightSoFar = Math.max(maxHeightSoFar, smallest);
            res += maxHeightSoFar - smallest;
        }
        return res;
    }

    //LC 523
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i=0; i< nums.length; i++){
            sum += nums[i];
            if(k != 0) {
                sum %= k;
            }
            Integer idx = map.get(sum);
            if(idx != null){
                if(i - idx > 1) return true;
            }
            else{
                map.put(sum, i);
            }
        }
        return false;
    }

    //LC 974
    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int sum = 0;
        int count = 0;
        for(int i=0; i< A.length; i++){
            sum += A[i];
            sum %= K;
            if(sum < 0) sum += K;
            count += map[sum];
            map[sum] = map[sum] + 1;
        }
        return count;
    }
}
