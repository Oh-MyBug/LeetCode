/**
 * ClassName:   Solution_28
 * Data:        2020/7/16
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
28. 实现 strStr()
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1
 */
public class Solution_28 {
    public static int strStr(String haystack, String needle) {
        int haystack_len = haystack.length(),
                needle_len = needle.length();
        if (needle_len == 0) return 0;
        if (haystack_len ==0) return -1;
        int res, haystack_cur = 0;
        while (haystack_cur < haystack_len){
            if (haystack.charAt(haystack_cur) == needle.charAt(0)){
                res = haystack_cur;
                for (int i = 0; i < needle_len; i++) {
                    if (haystack_cur + i >= haystack_len) return -1;
                    if (haystack.charAt(haystack_cur + i) != needle.charAt(i))  break;
                    if (i == needle_len - 1 && haystack.charAt(haystack_cur + i) == needle.charAt(i))
                        return res;
                }
            }
            ++ haystack_cur;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("", ""));
    }
}
