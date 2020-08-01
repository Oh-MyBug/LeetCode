/**
 * ClassName:   Solution_91
 * Data:        2020/7/31
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
91. 解码方法
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。
示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Solution_91 {
    int res = 0;

    public static void main(String[] args) {
        System.out.println(new Solution_91().numDecodings("226"));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;
            if (s.charAt(i) == '0')
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') curr = pre;
                else return 0;
            else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'))
                curr = curr + pre;
            pre = tmp;
        }
        return curr;
    }

/*    // 回溯
    public int numDecodings(String s) {
        if (s.equals("0")) return 0;
        helper(s, 0);
        return res;
    }

    // 回溯
    public void helper(String s, int index) {
        if (index == s.length()) {
            res++;
            return;
        }
        if (s.charAt(index) == '0')
            return;
        if (index + 1 < s.length() && (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') <= 26)
            helper(s, index + 2);
        helper(s, index + 1);
    }*/
}
