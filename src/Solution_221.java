/**
 * ClassName:   Solution_221
 * Data:        2020/8/24
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
221. 最大正方形
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
示例:
输入:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
输出: 4
 */
public class Solution_221 {
    public static void main(String[] args) {
        new Solution_221().maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
    }

    public int maximalSquare(char[][] matrix) {
        return 0;
    }
}
