import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:   Solution_166
 * Data:        2020/8/17
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
166. 分数到小数
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
如果小数部分为循环小数，则将循环的部分括在括号内。
示例 1:
输入: numerator = 1, denominator = 2
输出: "0.5"
示例 2:
输入: numerator = 2, denominator = 1
输出: "2"
示例 3:
输入: numerator = 2, denominator = 3
输出: "0.(6)"
 */
public class Solution_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(dividend / divisor);
        long remainder = dividend % divisor;
        // 余数为0 直接返回结果
        if (remainder == 0)
            return fraction.toString();

        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(").append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / divisor);
            remainder %= divisor;
        }
        return fraction.toString();
    }

    public static void main(String[] args) {
        System.out.println(false ^ false);
    }
}
