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

    /*
    算法：
        我们可以通过以下步骤实现该算法：
        首先，我们将原来的 32 位分为 2 个 16 位的块。
        然后我们将 16 位块分成 2 个 8 位的块。
        然后我们继续将这些块分成更小的块，直到达到 1 位的块。
        在上述每个步骤中，我们将中间结果合并为一个整数，作为下一步的输入。
     */
    public int reverseBits(int n) {
        n = (n & 0x55555555) << 1 | (n >>> 1) & 0x55555555;
        n = (n & 0x33333333) << 2 | (n >>> 2) & 0x33333333;
        n = (n & 0x0f0f0f0f) << 4 | (n >>> 4) & 0x0f0f0f0f;
        return  (n << 24)            |
                ((n & 0xff00) << 8)  |
                ((n >>> 8) & 0xff00) |
                (n >>> 24);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}