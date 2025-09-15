package algorithms.easy.minimum_number_of_swaps_to_make_the_string_balanced_1963;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int minSwaps(String s) {
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') { // open bracket
                balance++;
            } else if (balance > 0) { // close bracket that can be paired with open bracket
                balance--;
            }
        }
        return (balance + 1) / 2; // balance is the number of unbalanced brackets, +1 if odd, then divide by 2
    }

    @Test
    void test() {
        assertEquals(1, minSwaps("][]["));
        assertEquals(2, minSwaps("]]][[["));

    }
}
