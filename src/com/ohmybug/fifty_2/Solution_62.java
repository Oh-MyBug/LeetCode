package com.ohmybug.fifty_2;

import com.ohmybug.fifty_1.Solution_6;

import java.util.Arrays;

/**
 * ClassName:   Solution_62
 * Data:        2020/7/24
 * author:      Oh_MyBug
 * version:     V1.0
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
