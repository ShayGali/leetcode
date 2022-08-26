package algorithms.medium.reverse_integer_7;

public class Solution {
    public int reverse(int x) {
        int temp = Math.abs(x);
        int returnVal = 0;
        while (temp > 0) {
            try {
                returnVal = Math.multiplyExact(returnVal, 10);
                returnVal = Math.addExact(returnVal, temp % 10);
            } catch (ArithmeticException e) {
                return 0;
            }
            temp /= 10;
        }
        if (x < 0) returnVal *= -1;

        return returnVal;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));
        System.out.println(new Solution().reverse(2147483647));
    }
}
