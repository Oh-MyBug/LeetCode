import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_199
 * Data:        2020/8/19
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
public class Solution_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> queue1 = new ArrayList<>();
        List<TreeNode> queue2 = new ArrayList<>();
        if (root == null) return res;
        queue1.add(root);
        while (queue1.size() != 0 || queue2.size() != 0) {
            helper(queue1, queue2, res);
            helper(queue2, queue1, res);
        }
        return res;
    }

    public void helper(List<TreeNode> cur, List<TreeNode> next, List<Integer> res){
        while (cur.size() != 0) {
            TreeNode node = cur.remove(0);
            System.out.println(node.val);
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
            if (cur.size() == 0)
                res.add(node.val);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
