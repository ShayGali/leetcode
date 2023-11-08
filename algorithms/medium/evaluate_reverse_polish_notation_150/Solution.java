package algorithms.medium.evaluate_reverse_polish_notation_150;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution {


    public int evalRPN(String[] tokens) {
        Set<String> validOperators = new HashSet<>(List.of("+", "-", "*", "/"));
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (validOperators.contains(token)) {
                int t2 = Integer.parseInt(stack.pop());
                int t1 = Integer.parseInt(stack.pop());
                int res = doOperation(t1, t2, token);
                stack.push(String.valueOf(res));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private int doOperation(int t1, int t2, String operator) {
        return switch (operator) {
            case "+" -> t1 + t2;
            case "-" -> t1 - t2;
            case "*" -> t1 * t2;
            case "/" -> t1 / t2;
            default -> throw new UnsupportedOperationException("the operator: " + operator + " is not supported");
        };
    }

    @Test
    void test() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        assertEquals(9, evalRPN(tokens));
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        assertEquals(6, evalRPN(tokens2));
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        assertEquals(22, evalRPN(tokens3));
    }
}
