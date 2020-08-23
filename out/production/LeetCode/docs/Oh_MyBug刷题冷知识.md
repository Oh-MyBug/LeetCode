#Oh_MyBug刷题冷知识

## 关于位运算

### 位运算冷知识1
可以用`异或^`来判断**两数相除**后是否为负，代码简洁很多，如果单纯用`且&&`和`或||`表示，判断语句较冗长。

解释：用真值表可以表示为：

num1 > 0 ^ num2 > 0(其中 num1 为被除数，num2 为除数)

|num1 > 0|num2 > 0|result|
|---     |---     |---   |
|   1    |   1    |  0   | 
|   1    |   0    |  1   |
|   0    |   1    |  1   |
|   0    |   0    |  0   |

result = 0 代表结果为正， result = 1 代表结果为负。
```
public String fractionToDecimal(int numerator, int denominator) {
    // ...
    // If either one is negative (not both)
       if (numerator < 0 ^ denominator < 0) {
           fraction.append("-");
       }
    // ...
}
```
来源：[166. 分数到小数(官方题解)](https://leetcode-cn.com/problems/fraction-to-recurring-decimal/solution/fen-shu-dao-xiao-shu-by-leetcode/(https://leetcode-cn.com/problems/divide-two-integers/))

### 位运算冷知识2
异或运算有以下三个性质：
  - 任何数和 0 做异或运算，结果仍然是原来的数，即 a $\bigoplus 0=a \bigoplus 0=a$
  - 任何数和其自身做异或运算，结果是 0，即 $a \bigoplus a=0$
  - 异或运算满足交换律和结合律，即  $a\bigoplus b \bigoplus a=b \bigoplus a \bigoplus a=b \bigoplus (a \bigoplus a)=b \bigoplus 0=b$
  
来源：[136. 只出现一次的数字(官方题解)](https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/)