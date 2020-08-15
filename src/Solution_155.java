/**
 * ClassName:   Solution_155
 * Data:        2020/8/16
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
155. 最小栈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
示例:
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
输出：
[null,null,null,null,-3,null,0,-2]
解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 */
public class Solution_155 {

    /*
    复杂
    private Node head;  // 用于排序 从小到大
    private List<Integer> stack;

    private Map<Integer, List<Node>> map; // stack 到 head 的映射

    public Solution_155() {
        head = new Node(0);
        stack = new ArrayList<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        Node node = new Node(x);
        stack.add(0, x);
        map.computeIfAbsent(x, k -> new ArrayList<>()); // 没有就创建key
        map.get(x).add(node);
        addToSortLinkList(node);
    }

    private void addToSortLinkList(Node node) {
        if (head.next == null) {
            head.next = node;
            return;
        }
        Node p = head;
        while (p.next != null) {
            if (p.next.val >= node.val)
                break;
            p = p.next;
        }
        node.next = p.next;
        p.next = node;
    }

    public void pop() {
        List<Node> nodeList = map.get(stack.get(0));

        // 从排序链表中删除
        Node node = nodeList.get(0);
        Node p = head;
        while (p.next != null) {
            if (p.next == node)
                break;
            p = p.next;
        }
        p.next = p.next.next;

        // 从 map 中删除
        if (nodeList.size() > 1)
            nodeList.remove(0);
        else
            map.remove(stack.get(0));

        // 从 stack 中删除
        stack.remove(0);
    }

    public int top() {
        return stack.get(0);
    }

    public int getMin() {
        return head.next.val;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }*/

    /*
    private List<Integer> stack;
    private List<Integer> min_stack;

    public Solution_155() {
        stack = new ArrayList<>();
        min_stack = new ArrayList<>();
    }
    public void push(int x) {
        stack.add(0, x);
        if (min_stack.size() != 0)
            min_stack.add(0, Math.min(min_stack.get(0), x));
        else
            min_stack.add(x);
    }

    public void pop() {
        stack.remove(0);
        min_stack.remove(0);
    }

    public int top() {
        return stack.get(0);
    }

    public int getMin() {
        return min_stack.get(0);
    }
*/

    public static void main(String[] args) {
        Solution_155 minStack = new Solution_155();
        minStack.push(395);
        minStack.getMin();
        minStack.top();
        minStack.getMin();
        minStack.push(276);
        minStack.push(29);
        minStack.getMin();
        minStack.push(-482);
        minStack.getMin();
        minStack.pop();
        minStack.push(-108);
        minStack.push(-251);
        minStack.getMin();
        minStack.push(-439);
        minStack.top();
        minStack.push(370);
        minStack.pop();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }

    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

