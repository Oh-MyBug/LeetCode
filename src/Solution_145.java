import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_145
 * Data:        2020/8/15
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
 */
public class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        if (root.left != null)
            helper(root.left, res);
        if (root.right != null)
            helper(root.right, res);
        res.add(root.val);
    }
}
