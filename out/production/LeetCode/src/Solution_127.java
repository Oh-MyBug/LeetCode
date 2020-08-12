import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName:   Solution_127
 * Data:        2020/8/13
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
127. 单词接龙
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:
如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:
输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
输出: 5
解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:
输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
输出: 0
解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Solution_127 {
    private int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(new Solution_127().ladderLength("qa", "sq", Arrays.asList("si", "go", "se", "cm", "so",
                "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba",
                "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur",
                "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co",
                "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na",
                "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr",
                "pa", "he", "lr", "sq", "ye")));
    }

    // 不能用深度优先遍历 要用广度优先遍历
    /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        min = wordList.size() + 1;
        helper(beginWord, endWord, wordList.toArray(new String[wordList.size()]), 1);
        return min == wordList.size() + 1 ? 0 : min;
    }

    public void helper(String curWord, String endWord, String[] wordList, int index) {
        if (curWord.equals(endWord)) {
            min = Math.min(index, min);
            return;
        }
        if (index > min) return;
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            String word = wordList[i];
            if (isDifferentOne(word, curWord)) {
                wordList[i] = "";
                helper(word, endWord, wordList, index + 1);
                wordList[i] = word;
            }
        }
    }*/

    // 广度优先遍历
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();//少不了队列
        queue.add(beginWord);
        boolean[] marked = new boolean[wordList.size() + 1];//少不了标记
        int layer = 1;//注意返回的是层数+1.所以这里直接放1了
        while (!queue.isEmpty()) {//固定的层数记录形式
            layer++;
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (marked[i]) continue;
                    String dic = wordList.get(i);
                    if (isDifferentOne(dic, cur)) {
                        if (dic.equals(endWord)) return layer;
                        queue.add(dic);
                        marked[i] = true;
                    }
                }
            }
        }

        return 0;
    }

    public boolean isDifferentOne(String word1, String word2) {
        int count = 0;
        if (word1.length() != word2.length()) return false;
        int len = word1.length();
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) != word2.charAt(i))
                count++;
            if (count > 1)
                return false;
        }
        return true;
    }
}
