package medium.String_to_Integer_atoi;

class Solution {
    public int myAtoi(String s) {
        boolean isPositive = true;
        long n = 0;
        int i = 0;

        while (i < s.length() && !(s.charAt(i) >= '0' && s.charAt(i) <= '9') && !(s.charAt(i) == '-' || s.charAt(i) == '+') && s.charAt(i) == ' ') {
            i++;
        }

        if (i == s.length()) {
            return 0;
        } else if (s.charAt(i) == '-') {
            isPositive = false;
            i++;
        } else if (s.charAt(i) == '+') i++;
        else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
            return 0;
        }


        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            n *= 10;
            n += (int) s.charAt(i) - 48;
            if (isPositive && Integer.MAX_VALUE < n)
                return Integer.MAX_VALUE;
            else if (!isPositive && Integer.MIN_VALUE > n * -1) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return isPositive ? (int) n : (int) n * -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("42"));
        System.out.println(s.myAtoi("   -42"));
        System.out.println(s.myAtoi("4193 with words"));
        System.out.println(s.myAtoi(Integer.MIN_VALUE + ""));
    }
}
