/**
 * ClassName:   Solution_147
 * Data:        2020/8/15
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
147. 对链表进行插入排序
对链表进行插入排序。
插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
插入排序算法：
插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
示例 1：
输入: 4->2->1->3
输出: 1->2->3->4
示例 2：
输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */
public class Solution_147 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new Solution_147().insertionSortList(node1));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode new_head = new ListNode(0);
        new_head.next = head;

        ListNode prev = head;
        while (prev.next != null) {
            ListNode cur = prev.next;

            // 下一个要排序的节点刚好比当前节点大，则不需要移动
            if (cur.val >= prev.val) {
                prev = cur;
                continue;
            }
            // 剥离
            prev.next = cur.next;

            // 寻找要插入的位置的上一个节点
            ListNode last_node = new_head;
            while (last_node.next.val < cur.val)
                last_node = last_node.next;

            // 插入
            cur.next = last_node.next;
            last_node.next = cur;
        }
        return new_head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
