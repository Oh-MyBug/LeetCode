/**
 * ClassName:   Solution_171
 * Data:        2020/8/17
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
171. Excel表列序号
给定一个Excel表格中的列名称，返回其相应的列序号。
例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
示例 1:
输入: "A"
输出: 1
示例 2:
输入: "AB"
输出: 28
示例 3:
输入: "ZY"
输出: 701
 */
public class Solution_171 {
    public int titleToNumber(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (res == 0){
                res = c - 'A' + 1;
                continue;
            }
            res = res * 26 + c - 'A' + 1;
        }
        return res;
    }
}
