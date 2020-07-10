import java.util.HashSet;
import java.util.Set;

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
    public void recoverTree(TreeNode root) {
        Set<TreeNode> set = new HashSet<>();

    }

    public void helper(TreeNode root, TreeNode min, TreeNode max ){

    }

    public void helper(Set<TreeNode> set, TreeNode root){
        if (root.left != null)
            helper(set, root.left);
        set.add(root);
        if (root.right != null)
            helper(set, root.right);
    }
}
