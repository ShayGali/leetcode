package algorithms.easy.add_binary_66;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int remainder = 0;
        int temp;
        while (i >= 0 && j >= 0) {
            temp = (a.charAt(i) - '0') + (b.charAt(j) - '0') + remainder;
            remainder = temp / 2;
            if (temp % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            i--;
            j--;
        }
        while (i >= 0) {
            temp = (a.charAt(i) - '0') + remainder;
            remainder = temp / 2;
            if (temp % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            i--;
        }
        while (j >= 0) {
            temp = (b.charAt(j) - '0') + remainder;
            remainder = temp / 2;
            if (temp % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            j--;
        }

        if (remainder != 0)
            sb.append('1');

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11","1"));
    }

}
