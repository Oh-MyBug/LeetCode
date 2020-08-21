/**
 * ClassName:   Solution_203
 * Data:        2020/8/20
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
203. 移除链表元素
删除链表中等于给定值 val 的所有节点。
示例:
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
public class Solution_203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        ListNode p = new ListNode(0);
        p.next = head;
        while (p.next != null){
            if (p.next.val == val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        new Solution_203().removeElements(new ListNode(1), 1);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
