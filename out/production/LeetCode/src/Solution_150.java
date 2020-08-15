import java.util.ArrayList;

/**
 * ClassName:   Solution_150
 * Data:        2020/8/15
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
150. 逆波兰表达式求值
根据 逆波兰表示法，求表达式的值。
有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
说明：
整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
示例 1：

输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
示例 2：

输入: ["4", "13", "5", "/", "+"]
输出: 6
解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
示例 3：

输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
输出: 22
解释:
该算式转化为常见的中缀算术表达式为：
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class Solution_150 {

    public static void main(String[] args) {
        System.out.println(new Solution_150().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
    public int evalRPN(String[] tokens) {
        ArrayList<Integer> digital_stack = new ArrayList<>();
        int num1, num2;
        for (String token: tokens){

            switch (token){
                case "+":
                    num1 = digital_stack.remove(digital_stack.size() - 1);
                    num2 = digital_stack.remove(digital_stack.size() - 1);
                    digital_stack.add(num2 + num1);
                    break;
                case "-":
                    num1 = digital_stack.remove(digital_stack.size() - 1);
                    num2 = digital_stack.remove(digital_stack.size() - 1);
                    digital_stack.add(num2 - num1);
                    break;
                case "*":
                    num1 = digital_stack.remove(digital_stack.size() - 1);
                    num2 = digital_stack.remove(digital_stack.size() - 1);
                    digital_stack.add(num2 * num1);
                    break;
                case "/":
                    num1 = digital_stack.remove(digital_stack.size() - 1);
                    num2 = digital_stack.remove(digital_stack.size() - 1);
                    digital_stack.add(num2 / num1);
                    break;
                default:
                    digital_stack.add(Integer.parseInt(token));
                    break;
            }
        }
        return digital_stack.remove(0);
    }
}
