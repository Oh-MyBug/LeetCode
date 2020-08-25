/**
 * ClassName:   Solution_242
 * Data:        2020/8/26
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
示例 1:
输入: s = "anagram", t = "nagaram"
输出: true
示例 2:
输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。
 */
public class Solution_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] s_map = new int[26];
        int[] t_map = new int[26];
        for (char c : s.toCharArray())
            s_map[c - 'a']++;
        for (char c :t.toCharArray())
            t_map[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (s_map[i] != t_map[i])
                return false;
        }
        return true;
    }
}
