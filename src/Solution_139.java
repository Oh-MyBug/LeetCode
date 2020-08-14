import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName:   Solution_139
 * Data:        2020/8/14
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
139. 单词拆分
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */
public class Solution_139 {
    public static void main(String[] args) {
        System.out.println(new Solution_139().wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    /*
    // 时间超限
    private boolean res = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        helper(s, wordDict, 0);
        return res;
    }

    public void helper(String s, List<String> wordDict, int cur){
        if (cur == s.length()){
            res = true;
            return;
        }
        if (cur > s.length()) return;
        for (String word: wordDict){
            if (!s.startsWith(word, cur))
                continue;
            helper(s, wordDict, cur + word.length());
        }
    }

// stringBuilder 时间超限
    public void helper(String s, List<String> wordDict, StringBuilder stringBuilder){
        if (s.equals(stringBuilder.toString())) {
            res = true;
            return;
        }
        if (s.length() <= stringBuilder.length()) return;
        if (!s.substring(0, stringBuilder.length()).equals(stringBuilder.toString()))
            return;
        for (String word: wordDict){
            stringBuilder.append(word);
            helper(s, wordDict, stringBuilder);
            stringBuilder.delete(stringBuilder.length() - word.length(), stringBuilder.length());
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
*/
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length(), maxw = 0;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        Set<String> set = new HashSet();
        for(String str : wordDict){
            set.add(str);
            maxw = Math.max(maxw, str.length());
        }
        for(int i = 1; i < len + 1; i++){
            for(int j = i; j >= 0 && j >= i - maxw; j--){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
