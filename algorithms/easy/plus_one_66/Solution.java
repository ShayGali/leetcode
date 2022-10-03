package algorithms.easy.plus_one_66;

class Solution {
    public int[] plusOne(int[] digits) {
        int remainder = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            remainder = (digits[i] + 1) / 10;
            digits[i] = (digits[i] + 1) % 10;
            if (remainder == 0) break;
        }
        if (remainder == 0) return digits;
        int[] res = new int[digits.length + 1];
        res[0] = remainder;
        System.arraycopy(digits, 0, res, 1, res.length - 1);
        return res;
    }
}
