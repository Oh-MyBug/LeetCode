import java.util.ArrayList;
import java.util.Comparator;

/**
 * ClassName:   Solution_179
 * Data:        2020/8/18
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
179. 最大数
 */
public class Solution_179 {
    public static void main(String[] args) {
        System.out.println(new Solution_179().largestNumber(new int[]{121, 12}));
    }

    public String largestNumber(int[] nums) {
        ArrayList<String> strings = new ArrayList<>();
        for (int num : nums)
            strings.add(String.valueOf(num));
        strings.sort(new MyComparator2());
        System.out.println(strings);
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings)
            stringBuilder.append(string);
        String s = stringBuilder.toString();
//        String s = String.join("", strings);
        return s.charAt(0) == '0' ? "0" : s;
    }

    // dbq...虽然String也可以排序，但效率真不如自己写的MyComparator1
    static class MyComparator2 implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            StringBuilder stringBuilder = new StringBuilder();
            String s1 = stringBuilder.append(o1).append(o2).toString();
            stringBuilder.delete(0, stringBuilder.length());
            String s2 = stringBuilder.append(o2).append(o1).toString();
            return s2.compareTo(s1);
        }
    }

    // 傻逼排序，不知道String也可以排序吗？？？？ 请看MyComparator2
    static class MyComparator1 implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if (s1.equals(s2)) return 0;
            int len1 = s1.length();
            int len2 = s2.length();
            int min_len = Math.min(len1, len2);
            for (int i = 0; i < min_len; i++) {
                if (s1.charAt(i) > s2.charAt(i))
                    return -1;
                if (s1.charAt(i) < s2.charAt(i))
                    return 1;
            }

            StringBuilder stringBuilder1 = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            if (len1 < len2) {
                stringBuilder1.append(s2);
                stringBuilder2.append(s2, min_len, len2).append(s1);
                return compare(stringBuilder1.toString(), stringBuilder2.toString());
            }

            if (len1 > len2) {
                stringBuilder1.append(s1, min_len, len1).append(s2);
                stringBuilder2.append(s1);
                return compare(stringBuilder1.toString(), stringBuilder2.toString());
            }
            return 0;
        }
    }


}
