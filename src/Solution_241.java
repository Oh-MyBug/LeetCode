import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_241
 * Data:        2020/8/26
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
241. 为运算表达式设计优先级
给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
示例 1:
输入: "2-1-1"
输出: [0, 2]
解释:
((2-1)-1) = 0
(2-(1-1)) = 2
示例 2:
输入: "2*3-4*5"
输出: [-34, -14, -10, -10, 10]
解释:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
 */
public class Solution_241 {
    public static void main(String[] args) {
        System.out.println(new Solution_241().diffWaysToCompute("2*3-4*5"));
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        List<Character> symbols = new ArrayList<>();
        int tempNum = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                tempNum = tempNum * 10 + c - '0';
            } else {
                nums.add(tempNum);
                symbols.add(c);
                tempNum = 0;
            }
        }
        nums.add(tempNum);
        helper(nums, symbols, res);
        return res;
    }

    public void helper(List<Integer> nums, List<Character> symbols, List<Integer> res) {
        if (nums.size() == 1) {
            res.add(nums.get(0));
            return;
        }
        int sym_len = symbols.size();
        for (int i = 0; i < sym_len; i++) {
            List<Integer> temp_nums = new ArrayList<>(nums);
            List<Character> temp_symbols = new ArrayList<>(symbols);
            Integer num1 = temp_nums.remove(i);
            Integer num2 = temp_nums.remove(i);
            Character symbol = temp_symbols.remove(i);
            switch (symbol) {
                case '+':
                    temp_nums.add(i, num1 + num2);
                    break;
                case '-':
                    temp_nums.add(i, num1 - num2);
                    break;
                case '*':
                    temp_nums.add(i, num1 * num2);
                    break;
            }
            helper(temp_nums, temp_symbols, res);
        }
    }
}
