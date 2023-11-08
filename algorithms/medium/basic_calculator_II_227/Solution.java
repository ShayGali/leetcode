package algorithms.medium.basic_calculator_II_227;

public class Solution {
    /**
     * 227. Basic Calculator II
     * the basic idea of this solution is to use a variable to store the previous number, and a variable to store the current number
     * and a variable to store the result.
     * <p>
     * then we will go through the string, if the current character is a number, we will calculate the current number
     * if the current character is an operator, we will update the operator variable
     * if the current character is a space, we will ignore it
     * <p>
     * then if the operator is + or -, we will add the current number to the result, and update the previous number.
     * if the operator is * or /, we will update the result by subtracting the previous number, and add the previous number multiply or divide the current number
     * <p>
     * we do it because the multiply and divide have higher priority than plus and minus, and by doing this, we can avoid using a stack.
     * <p>
     * and at the end, we will return the result.
     *
     * @param s the input string
     * @return the result
     */
    public int calculate(String s) {

        int cur = 0, prev = 0, res = 0;
        char cur_operator = '+'; // initialize the operator to be + (the first number will be added to zero)

        for (int i = 0; i < s.length(); i++) {

            char cur_char = s.charAt(i);

            if ('0' <= cur_char && cur_char <= '9') { // if the current character is a number
                while (i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9') { // calculate the current number
                    cur = cur * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // move the index back to the last digit of the current number (the for loop will move the index forward)

                // update the result
                // if the operator is + or -, we will add the current number to the result, and update the previous number.
                if (cur_operator == '+') {
                    res += cur;
                    prev = cur;
                } else if (cur_operator == '-') {
                    res -= cur;
                    prev = -cur;
                } else // if the operator is * or /, we will update the result by subtracting the previous number, and add the previous number multiply or divide the current number
                    if (cur_operator == '*') {
                        res -= prev;
                        res += prev * cur;

                        prev = prev * cur;
                    } else if (cur_operator == '/') {
                        res -= prev;
                        res += prev / cur;

                        prev = prev / cur;
                    }

                cur = 0; // reset the current number to zero (for the next number)
            } else if (cur_char != ' ') { // if the current character is an operator, we will update the operator variable
                cur_operator = cur_char;
            }
        }

        return res;
    }
}
