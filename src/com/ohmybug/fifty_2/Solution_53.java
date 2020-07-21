package com.ohmybug.fifty_2;

/**
 * ClassName:   Solution_53
 * Data:        2020/7/21
 * author:      Oh_MyBug
 * version:     V1.0
 */
public class Solution_53 {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x: nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        Solution_53 solution_53 = new Solution_53();
        System.out.println(solution_53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
