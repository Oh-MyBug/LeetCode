import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_144
 * Data:        2020/8/15
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
144. 二叉树的前序遍历
给定一个二叉树，返回它的 前序 遍历。
示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,2,3]
 */
public class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        res.add(root.val);
        if (root.left != null)
            helper(root.left, res);
        if (root.right != null)
            helper(root.right, res);
    }
}
