package easy.palindrome_number;

class Solution {
    // Runtime - 27 ms
    // Memory - 45.8 MB
    public boolean isPalindrome1(int x) {
        if (x < 0)
            return false;
        String n = x + "";
        for (int i = 0; i < n.length() / 2; i++) {
            if (n.charAt(i) != n.charAt(n.length() - i - 1))
                return false;
        }
        return true;
    }

    // Runtime - 15 ms
    // Memory - 44.4 MB
    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        int temp = x;
        long n = 0;
        while (temp > 0) {
            n += temp % 10;
            n *= 10;
            temp /= 10;
        }
        n /= 10;
        return n == x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome2(1000000001));
    }
}
