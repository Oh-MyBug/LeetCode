import java.util.Stack;

/**
 * ClassName:   Solution_227
 * Data:        2020/8/24
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
227. 基本计算器 II
实现一个基本的计算器来计算一个简单的字符串表达式的值。
字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
示例 1:
输入: "3+2*2"
输出: 7
示例 2:
输入: " 3/2 "
输出: 1
示例 3:
输入: " 3+5 / 2 "
输出: 5
 */
public class Solution_227 {
    public static void main(String[] args) {
        System.out.println(new Solution_227().calculate("0-2147483647"));
    }

    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        int tempNum = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                tempNum = tempNum * 10 + c - '0';
            } else {
                add_stack(lastOp, tempNum, numStack);
                tempNum = 0;
                lastOp = c;
            }
        }

        add_stack(lastOp, tempNum, numStack);
        int ans = 0;
        for (int num : numStack) ans += num;
        return ans;
    }

    private void add_stack(char lastOp, int tempNum, Stack<Integer> numStack) {
        if (lastOp == '+') numStack.push(tempNum);
        else if (lastOp == '-') numStack.push(-tempNum);
        else numStack.push(res(lastOp, numStack.pop(), tempNum));
    }

    private int res(char op, int a, int b) {
        if (op == '*') return a * b;
        else if (op == '/') return a / b;
        else if (op == '+') return a + b; //其实加减运算可以忽略
        else return a - b;
    }
}
