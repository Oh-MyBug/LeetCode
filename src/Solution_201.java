/**
 * ClassName:   Solution_201
 * Data:        2020/8/20
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
201. 数字范围按位与
给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
示例 1: 
输入: [5,7]
输出: 4
示例 2:
输入: [0,1]
输出: 0
 */
public class Solution_201 {
    // 时间超限
//    public int rangeBitwiseAnd(int m, int n) {
//        int res = m;
//        for (int i = m + 1; i <= n; i++)
//            res &= i;
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution_201().rangeBitwiseAnd(5, 7));
    }

    /*
    5- 0101
    6- 0110
    7- 0111
    8- 1000
    9- 1001
    10-1010
    11-1011
    12-1100
    13-1101
    14-
     */
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return m << offset;
    }
}
