import javax.sound.midi.MidiDevice;

/**
 * ClassName:   Solution_12
 * Data:        2020/7/13
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*

 */
public class Solution_12 {
    // 逐一判断
    public static String intToRoman1(int num) {
        String roman = "";
        String[] specific_4 = new String[]{"IV", "XL", "CD"};
        String[] specific_9 = new String[]{"IX", "XC", "CM"};
        String[] symbol1 = new String[]{"I", "X", "C", "M"};
        String[] symbol2 = new String[]{"V", "L", "D"};
        String temp = "";
        int pop = 0;
        for (int i = 0; i < 4; i++) {
            pop = num%10;
            num /= 10;
            if (pop < 5){
                if (pop == 4) roman = specific_4[i] + roman;
                else {
                    temp = "";
                    while ((pop--) != 0)
                        temp = symbol1[i] + temp;
                    roman = temp + roman;
                }
            }else {
                if (pop == 9) roman = specific_9[i] + roman;
                else {
                    temp = "";
                    temp = symbol2[i] + temp;
                    for (int j = 0; j < pop - 5; j++)
                        temp = temp + symbol1[i];
                    roman = temp + roman;
                }
            }
        }
        return roman;
    }

    // 贪心
    public static String intToRoman(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer roman = new StringBuffer();
        int len = values.length;
        for (int i = 0; i < len; i++) {
            while (num >= values[i]){
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
