import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName:   Solution_187
 * Data:        2020/8/18
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
187. 重复的DNA序列
所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
示例：
输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class Solution_187 {
    /*
    用了两次substring 时间超限
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        int len = s.length();
        for (int i = 10; i < len; i++) {
            String target = s.substring(i - 10, i);
            String s1 = s.substring(i - 9, len);
            if (s1.contains(target))
                res.add(target);
        }
        return new ArrayList<>(res);
    }
    */
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        HashSet<String> seen = new HashSet(), output = new HashSet();

        for (int start = 0; start < n - L + 1; ++start) {
            String tmp = s.substring(start, start + L);
            if (seen.contains(tmp)) output.add(tmp);
            seen.add(tmp);
        }
        return new ArrayList<String>(output);
    }
}
