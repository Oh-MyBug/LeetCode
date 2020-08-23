/**
 * ClassName:   Solution_222
 * Data:        2020/8/24
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
222. 完全二叉树的节点个数
给出一个完全二叉树，求出该树的节点个数。
说明：
完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
示例:
输入:
    1
   / \
  2   3
 / \  /
4  5 6
输出: 6
 */
public class Solution_222 {
    // 未利用完全二叉树的特性
//    public int countNodes(TreeNode root) {
//        return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
//    }

    public int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            ++d;
        }
        return d;
    }

    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int)Math.pow(2, d) - 1;
        int pivot;
        for(int i = 0; i < d; ++i) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            }
            else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int d = computeDepth(root);
        if (d == 0) return 1;

        int left = 1, right = (int)Math.pow(2, d) - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (exists(pivot, d, root)) left = pivot + 1;
            else right = pivot - 1;
        }

        return (int)Math.pow(2, d) - 1 + left;
    }
}
