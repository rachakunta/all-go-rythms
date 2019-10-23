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
        //System.out.println(searchMatrix(twoDMatrix, 1));
        int[][] grid = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        //System.out.println(numIslands(grid));
        String[] ss = {"i", "love", "leetcode", "leetcode", "i", "love", "coding"};
        //System.out.println(topKFrequent(ss, 2));
        //setZeroes(grid);
        for (int[] n : grid) {
            //System.out.println(Arrays.toString(n));
        }
        char[] chars = "the sky is blue".toCharArray();
        //reverseWords(chars);
        //System.out.println(Arrays.toString(chars));
        //System.out.println(reverseWords(""));
        //System.out.println(calculate("1+(2+3)+(2-3)"));
        int[][] q = {
                {0, 0, 0, 0, 0,},
                {0, -1, -1, -1, 0},
                {0, -1, 0, -1, 0},
                {0, -1, -1, -1, 0}
        };
        //System.out.println(canReach(q,new int[]{1,2}));
        //System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
        //System.out.println(majorityElement(new int[]{1,1,1,2,2,2,3,3, 3}));
        //System.out.println(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
        //System.out.println(containsDuplicate(new int[] {1,2,3,1}));
        //System.out.println(Arrays.toString(wiggleSort(new int[]{1, 1, 1, 1, 2, 6, 5, 3, 3, 6, 5, 9, 8, 7, 4, 5, 9, 8, 6})));
        //System.out.println(kthLargestElement(new int[] {1,2,3,4,5,6,9,8,7}, 2));
        //System.out.println(hasPoints(new int[][] {{1,6}, {1,1}, {7,3}, {6,7}}, 8));
        //System.out.println(count(4));
        //System.out.println(makeItValidParanthesis(""));
        System.out.println(binarySort(new int[] {-5,-3,0,0,0,0,5,9,75,523}, -7));
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
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
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

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int length = grid.length;
        int width = grid[0].length;
        boolean[][] visited = new boolean[length][width];
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    numOfIslandsHelper(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void numOfIslandsHelper(char[][] grid, boolean[][] visited, int i, int j) {
        if (!(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length)) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        numOfIslandsHelper(grid, visited, i + 1, j);
        numOfIslandsHelper(grid, visited, i - 1, j);
        numOfIslandsHelper(grid, visited, i, j + 1);
        numOfIslandsHelper(grid, visited, i, j - 1);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0 || k == 0) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return map.get(o1).equals(map.get(o2)) ? o2.compareTo(o1) : map.get(o1) - map.get(o2);
            }
        });

        for (String s : map.keySet()) {
            pq.add(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList();
        while (!pq.isEmpty()) ans.add(pq.poll());
        Collections.reverse(ans);
        return ans;
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int r = matrix.length;
        int c = matrix[0].length;
        boolean isCol = false;
        boolean isRow = false;
        for (int i = 0; i < r; i++) {
            isRow = isRow || matrix[i][0] == 0;
            for (int j = 1; j < c; j++) {
                //isCol = isCol || matrix[0][j] == 0;
                int val = matrix[i][j];
                if (val == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 0; i < c; i++)
                matrix[0][i] = 0;
        }
        if (isRow) {
            for (int i = 0; i < r; i++)
                matrix[i][0] = 0;
        }
    }

    public static void reverseWords(char[] s) {
        int len = s.length;
        if (s == null || len == 0) return;
        int start = 0;
        reverse(s, 0, len - 1);
        int st = 0;
        for (int i = 0; i <= len; i++) {
            if (s[i] == ' ' || i == len - 1) {
                if (i == len - 1) {
                    i = len;
                }
                reverse(s, st, i - 1);
                st = i + 1;
            }
        }

    }

    private static int removeSpaces(char[] s) {
        int idx = 0;
        for (int i = 0; i < s.length; i++) {
            if (i > 0 && s[i] == ' ' && s[i - 1] == ' ') {
                continue;
            } else {
                s[idx++] = s[i];
            }
        }
        if (s[idx - 1] == ' ') idx--;
        return idx - 1;
    }

    private static void reverse(char[] chars, int s, int e) {
        while (s < e) {
            char t = chars[s];
            chars[s++] = chars[e];
            chars[e--] = t;
        }
    }

    //LC 151
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int trimmedEnd = removeSpaces(chars);
        int trimmedStart = 0;
        while (chars[trimmedStart] == ' ') {
            trimmedStart++;
            continue;
        }
        chars = Arrays.copyOfRange(chars, trimmedStart, trimmedEnd + 1);
        int newLen = chars.length;
        //reverse(chars, 0, newLen - 1);
        reverseWords(chars);
        String trimmed = new String(chars);
        return new String(trimmed);
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if (number != 0) result += sign * number;
        return result;
    }

    private static boolean canReach(int[][] board, int[] dest) {
        int length = board.length;
        int width = board[0].length;
        boolean arr[][] = new boolean[length][width];

        //for(int i=0; i< length; i++){
        //  for(int j = 0; j< width; j++){
        //if(board[i][j] == 0){
        helper(board, 0, 0, arr);
        //}
        //}
        //}

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (!arr[i][j] && board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void helper(int[][] board, int x, int y, boolean[][] arr) {
        if (!isValid(board, x, y)) {
            return;
        }
        if (arr[x][y]) {
            return;
        }
        if (board[x][y] == -1) {
            return;
        }

        arr[x][y] = true;
        helper(board, x + 1, y, arr);
        helper(board, x - 1, y, arr);
        helper(board, x, y + 1, arr);
        helper(board, x, y - 1, arr);
    }

    private static boolean isValid(int[][] board, int x, int y) {
        int length = board.length;
        int width = board[0].length;
        return x >= 0 && y >= 0 && x < length && y < width;
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target, dp);
    }

    private static int helper(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i], dp);
            }
        }
        dp[target] = res;
        return res;
    }

    public static List<Integer> majorityElement(int[] nums) {
        int n1 = 0, n2 = 0, c1 = 0, c2 = 0;
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            if (c1 > 0 && c2 > 0) {
                if (n1 != n && n2 != n) {
                    c1--;
                    c2--;
                } else if (n1 == n) {
                    c1++;
                } else {
                    c2++;
                }
            } else if (c2 > 0) {
                if (n2 == n) {
                    c2++;
                } else {
                    n1 = n;
                    c1++;
                }
            } else if (c1 > 0) {
                if (n1 == n) {
                    c1++;
                } else {
                    n2 = n;
                    c2++;
                }
            } else {
                n1 = n;
                c1++;
            }
        }
        c1 = c2 = 0;
        int len = nums.length;
        for (int n : nums) {
            if (n == n1) {
                c1++;
            } else if (n2 == n) {
                c2++;
            }
        }
        if (len / 3 < c1) res.add(n1);
        if (len / 3 < c2) res.add(n2);
        return res;
    }

    private static long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the neighbor buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in neighbor buckets
            d.put(m, (long) nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
        }
        return true;
    }

    public static int[] wiggleSort(int[] nums) {
        int median = kthLargestElement(nums, (nums.length - 1) / 2);
        int[] res = new int[nums.length];
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            int ind = newIndex(i, n);
            int leftidx = newIndex(left++, n);
            int rightidx = newIndex(right--, n);
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
        return nums;
    }

    private static int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }


    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private static int kthLargestElement(int nums[], int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    private static int helper(int[] nums, int s, int e, int k) {
        Random random = new Random(0);
        int n = nums.length;
        while (s <= e) {
            int pivot = random.nextInt(e - s + 1) + s;
            int pos = partition(nums, s, e, pivot);
            int pivotElement = nums[pos];
            if (pos == n - k) {
                return pivotElement;
            } else if (pos > n - k) {
                e = pos - 1;
            } else {
                s = pos + 1;
            }
        }
        return -1;
    }

    private static int partition(int[] nums, int s, int e, int pivot) {
        int pivotElement = nums[pivot];
        swap(nums, e, pivot);
        int i = s;
        for (int j = s; j < e; j++) {
            if (pivotElement > nums[j]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, e, i);
        return i;
    }

    private static boolean hasPoints(int[][] points, int target){
        HashMap<Integer, HashSet<Integer>> mapper = new HashMap<>();
        for(int [] point : points){
            int value = target - point[0];
            if(mapper.containsKey(value)){
                if(mapper.get(value).contains(target - point[1])){
                    return true;
                }
            }
            if(!mapper.containsKey(point[0])){
                mapper.put(point[0], new HashSet<>());
            }
            mapper.get(point[0]).add(point[1]);
            mapper.put(point[0], mapper.get(point[0]));
        }
        return false;
    }

    public static int count(int n) {
        return count(0, n - 1, 1) + count(1, n - 1, 1);
    }

    public static int count(int color, int n, int colorCount) {
        // check in cache
        // terminal
        if (n == 1) {
            return colorCount == 2 ? 1 : 2;
        }

        int count = 0;

        // WW
        if (colorCount == 2) {
            count = count(notColor(color), n - 1, 1);
        } else {
            count = count(color, n - 1, 2) +
                    count(notColor(color), n - 1, 1);
        }

        // add to cache
        return count;
    }

    private static int notColor(int color) {
        return color == 0 ? 1 : 0;
    }

    public static String makeItValidParanthesis(String s){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else{
                if(stack.empty()) {
                    set.add(i);
                }
                else{
                    stack.pop();
                }
            }
        }
        set.addAll(stack);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< s.length(); i++){
            if(set.contains(i)){
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private static int binarySort(int[] nums, int n){
        int l =0, r = nums.length;
        while(l < r){
            int mid = l + (r-l)/2;
            //if(nums[mid] == n) return mid;
            if(nums[mid] >= n) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    //TODO
    /*private static void paintSticks(int n){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        *//*int len = sb.length();
        paint('W', 0, sb, n, res);
        sb.delete(len, sb.length());
        paint('B', 0, sb, n, res);*//*
        paint(' ', 0, ,0,sb, n, res);
        System.out.println(res);;
    }

    private static void paint(char w, int l,int r, StringBuilder sb, int n, List<String> res) {
        if(sb.length() == n) {
            res.add(sb.toString());
            return ;
        }
        if(l == 2) {
            //w = w == 'W' ? 'B' : 'W';
            //i = 0;
            return;
        }
        sb += w;
        int len = sb.length();
        paint(w, l + 1, r, sb, n, res);
        i = 0;
        paint(w, l, r + 1, sb, n, res);
        //return sb.toString();
    }*/
}


