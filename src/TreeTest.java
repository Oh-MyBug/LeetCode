import org.junit.Test;

/**
 * ClassName: Test
 * Date:      2020/4/22 8:47
 * author:    Oh_MyBug
 * version:   V1.0
 */
public class TreeTest {
    TreeNode root = null;
    public TreeTest() {
        this.root = new TreeNode(6);
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
    }
    public void helper1(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + " ");
        helper1(root.left);
        helper1(root.right);
    }
    @Test
    public void test1(){
        helper1(root);
    }

}
