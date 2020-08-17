/**
 * ClassName:   Solution_190
 * Data:        2020/8/18
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
190. 颠倒二进制位
颠倒给定的 32 位无符号整数的二进制位。
示例 1：
输入: 00000010100101000001111010011100
输出: 00111001011110000010100101000000
解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
示例 2：
输入：11111111111111111111111111111101
输出：10111111111111111111111111111111
解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 */
public class Solution_190 {

    public int reverseBits(int n) {
        char[] nums = Integer.toBinaryString(n).toCharArray();
        int start = 0, end = nums.length - 1;
        while (start < end) {
            char temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
        return Integer.parseUnsignedInt(String.valueOf(nums) + "0".repeat(32 - nums.length));
        // 43261596
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
