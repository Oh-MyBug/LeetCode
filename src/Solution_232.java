import java.util.Stack;

/**
 * ClassName:   Solution_232
 * Data:        2020/8/25
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
232. 用栈实现队列
使用栈实现队列的下列操作：

push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。
示例:
MyQueue queue = new MyQueue();
queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false
说明:
你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class Solution_232 {
    private Stack<Integer> stack1;
    private Stack<Integer> temp_stack;
    public Solution_232() {
        stack1 = new Stack<>();
        temp_stack = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
    }

    public int pop() {
        while (!stack1.isEmpty())
            temp_stack.add(stack1.pop());
        Integer pop = temp_stack.pop();
        while (!temp_stack.isEmpty())
            stack1.add(temp_stack.pop());
        return pop;
    }

    public int peek() {
        while (!stack1.isEmpty())
            temp_stack.add(stack1.pop());
        Integer peek = temp_stack.peek();
        while (!temp_stack.isEmpty())
            stack1.add(temp_stack.pop());
        return peek;
    }

    public boolean empty() {
        return stack1.size() == 0;
    }
}
