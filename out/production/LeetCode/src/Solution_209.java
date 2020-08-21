/**
 * ClassName:   Solution_209
 * Data:        2020/8/20
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
209. 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
示例：
输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class Solution_209 {
    // 暴力法
//    public int minSubArrayLen(int s, int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += nums[j];
//                if (sum >= s) {
//                    ans = Math.min(ans, j - i + 1);
//                    break;
//                }
//            }
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution_209().minSubArrayLen(20, new int[]{1,2,3,4,5}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (left <= right) {
            if (sum >= s){
                ans = Math.min(ans, right - left);
                sum -= nums[left];
                left++;
                continue;
            }
            if (right == n) break;
            sum += nums[right];
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
