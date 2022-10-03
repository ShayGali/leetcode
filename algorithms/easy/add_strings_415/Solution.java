package algorithms.easy.add_strings_415;

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int remainder = 0;
        int n1, n2, calc;
        while (i >= 0 || j >= 0) {
            n1 = 0;
            n2 = 0;

            if (i >= 0) n1 = num1.charAt(i--) - '0';

            if (j >= 0) n2 = num2.charAt(j--) - '0';

            calc = n1 + n2 + remainder;
            remainder = calc / 10;
            sb.append(calc % 10);
        }
        if (remainder!=0)sb.append(remainder);

        return sb.reverse().toString();
    }
}
