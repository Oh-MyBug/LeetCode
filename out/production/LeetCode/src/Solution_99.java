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
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.generateTree(new Integer[]{68,41,null,-85,null,-73,-49,-98,null,null,null,-124});
        recoverTree(tree.getRoot());

    }
    public static void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper1(list, root);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 < o2) return -1;
                return 0;
            }
        });
        System.out.println(list.toString());
        helper2(list, root);
    }

    public static void helper2(List<Integer> list, TreeNode root){
        if (root.left != null)
            helper2(list, root.left);
        root.val = (int)list.toArray()[0];
        list.remove(list.toArray()[0]);
        if (root.right != null)
            helper2(list, root.right);
    }

    public static void helper1(List<Integer> list, TreeNode root){
        if (root.left != null)
            helper1(list, root.left);
        list.add(root.val);
        if (root.right != null)
            helper1(list, root.right);
    }
}
