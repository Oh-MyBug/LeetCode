import java.util.*;

import static java.lang.Integer.compare;

/**
 * ClassName:   Solution_99
 * Data:        2020/7/10
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
99. 恢复二叉搜索树
二叉搜索树中的两个节点被错误地交换。
请在不改变其结构的情况下，恢复这棵树。
示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2

示例 2:

输入: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

输出: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
 */
public class Solution_99 {
    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root)
                    predecessor = predecessor.right;

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) x = pred;
                    }
                    pred = root;

                    predecessor.right = null;
                    root = root.right;
                }
            }else {
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) x = pred;
                }
                pred = root;
                root = root.right;
            }
        }
        swap(x, y);
    }
}
