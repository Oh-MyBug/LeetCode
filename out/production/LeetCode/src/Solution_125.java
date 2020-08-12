/**
 * ClassName:   Solution_125
 * Data:        2020/8/13
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。
示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:
输入: "race a car"
输出: false
 */
public class Solution_125 {
    // 调用 API 时间复杂度高
    /*public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9|a-z]", "");
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }*/

    /*
    字母大小写转换的方法：

    统一转成大写：ch & 0b11011111 简写：ch & 0xDF
    统一转成小写：ch | 0b00100000 简写：ch | 0x20
    比较的时候注意加上小括号哦，因为位运算优先级比较低。

    65～90为26个大写英文字母，97～122号为26个小写英文字母

    65（0100 0001）到 90（0101 1010），刚好第5位（从0开始）都为0
    97（0110 0001）到 122（0111 1010），刚好第5位（从0开始）都为1

    说明：
    ch & 0b11011111 ，效果就是将第5位（从0开始）清0，即如果第5位原来为0（大写字母），则保持不变，
    否则，减去32（小写转大写），小写字母转换成对应的大写字母正好就是减32

    同理，ch | 0b00100000，效果是如果第5位（从0开始）为0（大写字母），则加32，
    否（大写转小写）则，保持不变
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right){
            if ((chars[left] >= 'A' && chars[left] <= 'Z'))
                chars[left] = (char) (s.charAt(left) | 0x20);
            if ((chars[right] >= 'A' && chars[right] <= 'Z'))
                chars[right] = (char) (s.charAt(right) | 0x20);

            if (!((chars[left] >= 'a' && chars[left] <= 'z') || (chars[left] >= '0' && chars[left] <= '9'))) {
                left++;
                continue;
            }
            if (!((chars[right] >= 'a' && chars[right] <= 'z') || (chars[right] >= '0' && chars[right]<= '9'))) {
                right--;
                continue;
            }
            if (chars[left] != chars[right]) return false;
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
