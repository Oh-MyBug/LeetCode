/**
 * ClassName:   Solution_205
 * Data:        2020/8/20
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
205. 同构字符串
给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
示例 1:
输入: s = "egg", t = "add"
输出: true
示例 2:
输入: s = "foo", t = "bar"
输出: false
示例 3:
输入: s = "paper", t = "title"
输出: true
 */
public class Solution_205 {
    public static void main(String[] args) {
        System.out.println(new Solution_205().isIsomorphic("egg", "add"));
    }

//    public boolean isIsomorphic(String s, String t) {
//        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
//    }
//
//    private boolean isIsomorphicHelper(String s, String t) {
//        int n = s.length();
//        HashMap<Character, Character> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            char c1 = s.charAt(i);
//            char c2 = t.charAt(i);
//            if (map.containsKey(c1)) {
//                if (map.get(c1) != c2) {
//                    return false;
//                }
//            } else {
//                map.put(c1, c2);
//            }
//        }
//        return true;
//    }

    /*
    用两个 map 分别记录两个字符串每个字母的映射。将所有字母初始都映射到 0。记录过程中，如果发现了当前映射不一致，就可以立即返回 false
     */
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                //是否已经修改过，修改过就不需要再处理
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }

//    public boolean isIsomorphic(String s, String t) {
//        HashMap<Character, Character> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.containsKey(s.charAt(i))) {
//                if (map.containsValue(t.charAt(i)))
//                    return false;
//                map.put(s.charAt(i), t.charAt(i));
//            } else {
//                if (map.get(s.charAt(i)) != t.charAt(i))
//                    return false;
//            }
//        }
//        return true;
//    }
}
