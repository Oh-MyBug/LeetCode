public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    /**
     * 在当前ListNode this尾部添加一个节点，数值为val
     * @Function add
     * @author   Oh_MyBug
     * @Date     2020/4/4 16:56
     * @param val
     * @return
     */
    public void add(int val){
        ListNode temp = this;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new ListNode(val);
    }

    public static void show(ListNode head){
        ListNode p = head;
        while (p!=null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
