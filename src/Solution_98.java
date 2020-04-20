/**
 * ClassName: Solution_98
 * Date:      2020/4/20 21:55
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

    输入:
        2
       / \
      1   3
    输出: true
示例 2:

    输入:
        5
       / \
      1   4
         / \
        3   6
    输出: false
    解释: 输入为: [5,1,4,null,null,3,6]。
         根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Solution_98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode r1 = new TreeNode(4);
        TreeNode r2 = new TreeNode(10);
        TreeNode r3 = new TreeNode(1);
        TreeNode r4 = new TreeNode(5);
        TreeNode r5 = new TreeNode(9);
        TreeNode r6 = new TreeNode(11);
        TreeNode r7 = new TreeNode(0);
        TreeNode r8 = new TreeNode(2);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.left = r5;
        r2.right = r6;
        r3.left = r7;
        r3.right = r8;
        Solution_98 s = new Solution_98();
        System.out.println(s.isValidBST(root));
    }
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
