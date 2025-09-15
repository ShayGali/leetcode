package algorithms.easy.minimum_string_length_after_removing_substrings_2696;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution {
    public int minLength(String s) {
        Stack<Character> stk = new Stack<>();
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!stk.isEmpty() && ((stk.peek() == 'A' && s.charAt(i) == 'B') || (stk.peek() == 'C' && s.charAt(i) == 'D'))) {
                counter++;
                stk.pop();
            } else {
                stk.push(s.charAt(i));
            }
        }
        return s.length() - 2 * counter;
    }

    @Test
    void test1() {
        assertEquals(0, minLength("ABCD"));
        assertEquals(2, minLength("ABFCACDB"));
        assertEquals(5, minLength("ACBBD"));

    }
}