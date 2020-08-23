/**
 * ClassName:   Solution_226
 * Data:        2020/8/24
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
226. 翻转二叉树
翻转一棵二叉树。
示例：
输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode new_root = new TreeNode(root.val);
        helper(root, new_root);
        return new_root;
    }

    public void helper(TreeNode root, TreeNode new_root){
        if (root.right != null){
            new_root.left = new TreeNode(root.right.val);
            helper(root.right, new_root.left);
        }
        if (root.left != null){
            new_root.right = new TreeNode(root.left.val);
            helper(root.left, new_root.right);
        }
    }
}
