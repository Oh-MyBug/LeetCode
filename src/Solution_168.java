/**
 * ClassName:   Solution_168
 * Data:        2020/8/17
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
168. Excel表列名称
给定一个正整数，返回它在 Excel 表中相对应的列名称。
例如，
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
示例 1:
输入: 1
输出: "A"
示例 2:
输入: 28
输出: "AB"
示例 3:
输入: 701
输出: "ZY"
 */
public class Solution_168 {
    public static void main(String[] args) {
        System.out.println(new Solution_168().convertToTitle(52));
    }

    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            n--;
            stringBuilder.insert(0, (char) (n % 26 + 'A'));
            n = n / 26;
        }
        return stringBuilder.toString();
    }
}
