/**
 * ClassName:   Solution_238
 * Data:        2020/8/25
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
238. 除自身以外数组的乘积
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
示例:
输入: [1,2,3,4]
输出: [24,12,8,6]
提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class Solution_238 {
    // 时间超限
//    public int[] productExceptSelf(int[] nums) {
//        int len = nums.length;
//        int[] res = new int[len];
//        Arrays.fill(res, 1);
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                if (i != j){
//                    res[j] *= nums[i];
//                }
//            }
//        }
//        return res;
//    }

    // 自制除法， 时间超限
//    public int[] productExceptSelf(int[] nums) {
//        int len = nums.length;
//        int[] res = new int[len];
//        int zero_loc = -1;
//        int multiply = 1;
//        for (int i = 0; i < len; i++) {
//            if (nums[i] == 0) {
//                if (zero_loc != -1) return res;
//                zero_loc = i;
//            }
//            if (nums[i] != 0)
//                multiply *= nums[i];
//        }
//
//        if (zero_loc != -1) {
//            res[zero_loc] = multiply;
//            return res;
//        }
//
//        for (int i = 0; i < len; i++)
//            res[i] = divide(multiply, nums[i]);
//        return res;
//    }
//
//    public int divide(int num1, int num2) {
//        if (num1 == 0) return 0;
//        int res = 0;
//        boolean neg = (num1 > 0) ^ (num2 > 0);
//        num1 = num1 > 0 ? -num1 : num1;
//        num2 = num2 > 0 ? -num2 : num2;
//        while (num1 <= num2) {
//            num1 -= num2;
//            res++;
//        }
//        return neg ? -res : res;
//    }

    // 空间复杂度 O(n)
//    public int[] productExceptSelf(int[] nums) {
//        int length = nums.length;
//
//        int[] L = new int[length];
//        int[] R = new int[length];
//
//        int[] answer = new int[length];
//
//        L[0] = 1;
//        for (int i = 1; i < length; i++)
//            L[i] = nums[i - 1] * L[i - 1];
//
//        R[length - 1] = 1;
//        for (int i = length - 2; i >= 0; i--)
//            R[i] = nums[i + 1] * R[i + 1];
//
//        for (int i = 0; i < length; i++)
//            answer[i] = L[i] * R[i];
//
//        return answer;
//    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }
}
