package algorithms.easy.roman_to_integer_13;

public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int val = getValue(s.charAt(i));
            if (i - 1 >= 0 && val > getValue(s.charAt(i - 1))) {
                sum += getLessValue(s.charAt(i));
                i--;
            } else {
                sum += val;
            }
        }
        return sum;
    }

    public int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public int getLessValue(char ch) {
        return switch (ch) {
            case 'V' -> 4;
            case 'X' -> 9;
            case 'L' -> 40;
            case 'C' -> 90;
            case 'D' -> 400;
            case 'M' -> 900;
            default -> 0;
        };
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().romanToInt("III"));
//        System.out.println(new Solution().romanToInt("LVIII"));
//        System.out.println(new Solution().romanToInt("MCMXCIV"));
//        System.out.println(new Solution().romanToInt("IV"));

        System.out.println('I');
        System.out.println('V');
        System.out.println('X');
        System.out.println('L');
        System.out.println('C');
        System.out.println('D');
        System.out.println('M');

    }
}
