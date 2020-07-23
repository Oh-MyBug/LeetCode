package com.ohmybug.fifty_2;

import java.util.Arrays;

/**
 * ClassName:   Solution_62
 * Data:        2020/7/24
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
示例 1:
输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:
输入: m = 7, n = 3
输出: 28
 */
public class Solution_62 {
    /*public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++)
            res[i][n - 1] = 1;
        for (int i = 0; i < n; i++)
            res[m - 1][i] = 1;
        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--)
                res[i][j] = res[i + 1][j] + res[i][j + 1];
        return res[0][0];
    }*/
    // 动态规划、优化空间
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

    public static void main(String[] args) {
        Solution_62 solution_62 = new Solution_62();
        System.out.println(solution_62.uniquePaths(7, 3));
    }
}
