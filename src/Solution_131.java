import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_131
 * Data:        2020/8/14
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
131. 分割回文串
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。
示例:
输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
 */
public class Solution_131 {
/*

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) return res;
        helper(s, 0, s.length(), new ArrayList<>(), res);
        return res;
    }

    public void helper(String s, int start, int len, List<String> temp, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < len; i++) {
            if (isPalindrome(s, start, i)){
                temp.add(s.substring(start, i + 1));
                helper(s, i + 1, len, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
*/


    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) return res;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        // dp[i,j] = dp[i+1, j-1]  && s[i] == s[j]
        for (int str_len = 1; str_len <= len; str_len++) {
            for (int i = 0; i <= len - str_len; i++) {
                if (str_len == 1)
                    dp[i][i + str_len - 1] = true;
                if (str_len == 2 || str_len == 3)
                    dp[i][i + str_len - 1] = s.charAt(i) == s.charAt(i + str_len - 1);
                if (str_len > 2)
                    dp[i][i + str_len - 1] = (dp[i + 1][i + str_len - 2] && s.charAt(i) == s.charAt(i + str_len - 1));
            }
        }
        helper(s, 0, s.length(), new ArrayList<>(), res, dp);
        return res;
    }

    public void helper(String s, int start, int len, List<String> temp, List<List<String>> res, boolean[][] dp) {
        if (start == len) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < len; i++) {
            if (dp[start][i]){
                temp.add(s.substring(start, i + 1));
                helper(s, i + 1, len,  temp, res, dp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
