import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_173
 * Data:        2020/8/17
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
173. 二叉搜索树迭代器
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
调用 next() 将返回二叉搜索树中的下一个最小的数。
示例：
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false
提示：
next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 */
public class Solution_173 {

    private List<TreeNode> list = new ArrayList<>();
    private List<Boolean> visited = new ArrayList<>();

    public Solution_173(TreeNode root) {
        if (root != null) {
            list.add(root);
            visited.add(false);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(9);
        TreeNode treeNode5 = new TreeNode(20);
        root.left = treeNode2;
        root.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        new Solution_173(root);
    }


    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode remove = null;
        while (remove == null) {
            TreeNode treeNode = list.get(list.size() - 1);
            Boolean visit = visited.get(list.size() - 1);
            if (treeNode.left != null && !visit) {
                list.add(treeNode.left);
                visited.set(visited.size() - 1, true);
                visited.add(false);
                continue;
            }
            remove = list.remove(list.size() - 1);
            visited.remove(visited.size() - 1);
            System.out.println(treeNode.val);
            if (treeNode.right != null) {
                list.add(treeNode.right);
                visited.add(false);
            }
        }
        return remove.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return list.size() != 0;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

/*
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {

        // Stack for the recursion simulation
        this.stack = new Stack<TreeNode>();

        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {

        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        // Node at the top of the stack is the next smallest element
        TreeNode topmostNode = this.stack.pop();

        // Need to maintain the invariant. If the node has a right child, call the
        // helper function for the right child
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}
*/