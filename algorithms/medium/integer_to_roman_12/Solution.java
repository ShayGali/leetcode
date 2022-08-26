package algorithms.medium.integer_to_roman_12;

public class Solution {

    static class RomanNumeral {
        String symbol;
        int val;

        public RomanNumeral(String symbol, int val) {
            this.symbol = symbol;
            this.val = val;
        }
    }

    static RomanNumeral[] ROMAN_NUMERALS;

    static {
        ROMAN_NUMERALS = new RomanNumeral[]{
                new RomanNumeral("M", 1000),
                new RomanNumeral("CM", 900),
                new RomanNumeral("D", 500),
                new RomanNumeral("CD", 400),
                new RomanNumeral("C", 100),
                new RomanNumeral("XC", 90),
                new RomanNumeral("L", 50),
                new RomanNumeral("XL", 40),
                new RomanNumeral("X", 10),
                new RomanNumeral("IX", 9),
                new RomanNumeral("V", 5),
                new RomanNumeral("IV", 4),
                new RomanNumeral("I", 1),
        };
    }

    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num - ROMAN_NUMERALS[i].val >= 0) {
                str.append(ROMAN_NUMERALS[i].symbol);
                num -= ROMAN_NUMERALS[i].val;
            }
            i++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3));
    }

}
