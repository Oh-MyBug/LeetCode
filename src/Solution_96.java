/**
 * ClassName: Solution_96
 * Date:      2020/4/17 16:25
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
96. 不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
示例:
    输入: 3
    输出: 5
解释:
    给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
 */
public class Solution_96 {
    public static void main(String[] args) {
//        System.out.println(numTrees(3));
    }
    public int numTrees(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
