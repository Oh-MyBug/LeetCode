import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:   Solution_151
 * Data:        2020/8/16
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
151. 翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。
示例 1：
输入: "the sky is blue"
输出: "blue is sky the"
示例 2：
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Solution_151 {
    public static void main(String[] args) {
        System.out.println(new Solution_151().reverseWords("  hello world!  "));
        System.out.println(new Solution_151().reverseWords("the sky is blue"));
    }
    /*
    两个SB
    public String reverseWords(String s) {
        StringBuilder res_sb = new StringBuilder();
        StringBuilder tmp_sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' '){
                tmp_sb.append(c);
            }
            if (c == ' ' && tmp_sb.length() != 0){
                res_sb.insert(0, tmp_sb).insert(0,' ');
                tmp_sb.delete(0, tmp_sb.length());
            }
        }
        if (tmp_sb.length() != 0)
            res_sb.insert(0, tmp_sb).insert(0,' ');
        return res_sb.length() > 0 ? res_sb.substring(1, res_sb.length()) : null;
    }
*/

/*
    一个SB
    public String reverseWords(String s) {
        if (s.trim().length() == 0) return "";
        StringBuilder characters = new StringBuilder();
        int size = 0, insert_loc;
        boolean first = true;
        insert_loc = size;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c != ' ') {
                characters.insert(insert_loc, c);
                size ++;
                if (!first)
                    first = true;
            }

            if (c == ' ' && first) {
                characters.append(' ');
                insert_loc = ++size;
                first = false;
            }
        }

        if (chars[0] == ' ')
            characters.deleteCharAt(0);
        if (chars[chars.length - 1] == ' ')
            characters.deleteCharAt(characters.length() - 1);
        return characters.reverse().toString();
    }
    */

    // API选手
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
