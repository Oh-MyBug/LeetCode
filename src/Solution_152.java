/**
 * ClassName:   Solution_152
 * Data:        2020/8/16
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
152. 乘积最大子数组
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Solution_152 {
    private int max = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < len; i++)
            helper(nums, len, 1, i, true);
        return max;
    }

    public void helper(int[] nums, int len, int temp, int index, boolean first){
        if (!first)
            max = Math.max(max, temp);
        if (index == len) return;
        helper(nums, len, temp * nums[index], index + 1, false);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_152().maxProduct(new int[]{-4,-3}));
    }
}
