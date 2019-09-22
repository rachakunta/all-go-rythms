package com.rana.arrays;

import java.util.*;

public class AllArrayProblems {
    public static void main(String[] args) {
        //System.out.println(trappingRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        //System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        //System.out.println(Arrays.toString(twoSumSorted(new int[]{2, 7, 11, 15}, 9)));
        //System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        //System.out.println(fizzBuzz(15));
        //System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6, 9}));
        //System.out.println("len :"+ Arrays.toString(":::::.::::::::".split(":")));

        //System.out.println(Arrays.toString("\"12..33.4\"".split("wwwwwwwwxxd\\.")));
        //System.out.println(validIPAddress("12..33.4"));
        int[][] intervals = {{2, 11}, {9, 10}, {5, 9}};
        //System.out.println(minMeetingRooms(intervals));
        int[][] twoDMatrix = {
                {1, 1}
                /*{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}*/
        };
        System.out.println(searchMatrix(twoDMatrix, 1));
    }

    public static int singleNumber(int[] nums) {
        int x = 0;
        for (int n : nums) {
            x = x ^ n;
        }
        return x;
    }

    public static int maxProfit3(int[] prices) {
        int minPrice1 = Integer.MAX_VALUE;
        int minPrice2 = Integer.MAX_VALUE;
        int profit1 = 0;
        int profit2 = 0;
        for (int price : prices) {
            minPrice1 = Math.min(minPrice1, price);
            profit1 = Math.max(profit1, price - minPrice1);
            minPrice2 = Math.min(minPrice2, price - profit1);
            profit2 = Math.max(profit2, price - minPrice2);
        }
        return profit2;
    }

    public static List<Integer> countOfNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int end = nums.length;
        int count = 1;
        for (int i = 1; i < end; i++) {
            while (i < end && nums[i] != nums[i - 1]) {
                list.add(count);
                count = 1;
                i++;
            }
            count++;
        }
        if (count > 0) {
            list.add(count);
        }
        return list;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static int trappingRainWater(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxHeightSoFar = 0, l = 0, r = heights.length - 1, res = 0;
        ;
        while (l < r) {
            int smallest = heights[heights[l] < heights[r] ? l++ : r--];
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
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            Integer idx = map.get(sum);
            if (idx != null) {
                if (i - idx > 1) return true;
            } else {
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
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            sum %= K;
            if (sum < 0) sum += K;
            count += map[sum];
            map[sum] = map[sum] + 1;
        }
        return count;
    }

    //LC 53
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0, end = 0, s = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            sum = sum + n;
            if (sum > max) {
                max = sum;
                start = s;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                s = i + 1;
            }
        }
        System.out.println("starting from " + start + " and ending " + end);
        return max;
    }

    //LC 167
    public static int[] twoSumSorted(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (target == sum) return new int[]{l + 1, r + 1};

            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[2];
    }

    //LC 443
    public static int compress(char[] chars) {
        int s = 0, e = chars.length, start = 0, count = 0, idx = 0;
        while (start < e) {
            char c = chars[s];
            while (start < e && chars[start] == c) {
                start++;
                count++;
            }
            chars[idx++] = c;

            if (count > 1) {
                for (char cr : String.valueOf(count).toCharArray()) {
                    chars[idx++] = cr;
                }
            }
            s = count;
        }
        return idx;
    }

    //LC 412
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0 && i % 5 == 0) {
                    list.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    list.add("Fizz");
                } else {
                    list.add("buzz");
                }
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    //LC 1014
    public static int maxScoreSightseeingPair(int[] A) {
        int res = 0, cur = 0;
        for (int a : A) {
            res = Math.max(res, cur + a);
            cur = Math.max(cur, a) - 1;
        }
        return res;
    }

    //LC 468
    //TODO Solve all edge cases.
    public static String validIPAddress(String IP) {
        String res = null;
        if (IP.contains(".")) {
            res = isValidIp(IP);
        } else if (IP.contains(":")) {
            res = isValidIpV6(IP);
        }
        return res == null ? "neither" : res;
    }

    private static String isValidIpV6(String ip) {
        if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
            return null;
        }
        String[] strings = ip.split(":");
        if (strings.length > 8) {
            return null;
        }
        for (String s : strings) {
            if (s.length() > 4 || s.equals("") || s.equals(" ")) {
                return null;
            }
        }
        return "IPV6";
    }

    private static String isValidIp(String s) {
        if (s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.') {
            return null;
        }
        String[] strings = s.split("\\.");
        if (strings.length > 4) {
            return null;
        }
        for (String st : strings) {
            try {
                if (st.equals("") || st.equals(" ") || st.charAt(0) == '0' || Integer.parseInt(st) > 255) {
                    return null;
                }
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return "IPV4";
    }

    //LC 252
    public static boolean canAttendMeetings(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int i = 0;
        for (int[] row : intervals) {
            start[i] = row[0];
            end[i++] = row[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        i = 0;
        while (i < intervals.length - 1) {
            if (end[i++] > start[i]) {
                return false;
            }
        }
        return true;
    }

    //LC 253
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }
        int n = intervals.length;
        int max = 0;
        int[] start = new int[n];
        int[] end = new int[n];
        int s = 0;
        for (int[] a : intervals) {
            start[s] = a[0];
            end[s] = a[1];
            s++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int min = 0;
        int e = 0;
        s = 0;
        while (s < intervals.length) {
            if (start[s] >= end[e]) {
                e++;
            } else {
                while (s + 1 < intervals.length && start[s + 1] < end[e]) {
                    s++;
                }
                min++;
                s++;
            }
        }
        return min;
    }

    //LP 240
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1, col = 0;
        while (row >=0 && row < matrix.length && col >=0 && col < matrix[0].length) {
            int value = matrix[row][col];
            if (value == target) {
                return true;
            } else if (value > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
