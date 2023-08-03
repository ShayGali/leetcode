package algorithms.medium.letter_combinations_of_a_phone_number_17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        return letterCombinations(digits, 0);
    }

    public List<String> letterCombinations(String digits, int start) {
        List<String> res = new ArrayList<>();
        if (start == digits.length()) {
            res.add("");
            return res;
        }

        List<String> lc = letterCombinations(digits, start + 1);
        for (String s : lc) {
            switch (digits.charAt(start)) {
                case '2' -> {
                    res.add("a".concat(s));
                    res.add("b".concat(s));
                    res.add("c".concat(s));
                }
                case '3' -> {
                    res.add("d".concat(s));
                    res.add("e".concat(s));
                    res.add("f".concat(s));
                }
                case '4' -> {
                    res.add("g".concat(s));
                    res.add("i".concat(s));
                    res.add("h".concat(s));
                }
                case '5' -> {
                    res.add("j".concat(s));
                    res.add("k".concat(s));
                    res.add("l".concat(s));
                }
                case '6' -> {
                    res.add("m".concat(s));
                    res.add("n".concat(s));
                    res.add("o".concat(s));
                }
                case '7' -> {
                    res.add("p".concat(s));
                    res.add("q".concat(s));
                    res.add("r".concat(s));
                    res.add("s".concat(s));
                }
                case '8' -> {
                    res.add("t".concat(s));
                    res.add("u".concat(s));
                    res.add("v".concat(s));
                }
                case '9' -> {
                    res.add("w".concat(s));
                    res.add("x".concat(s));
                    res.add("y".concat(s));
                    res.add("z".concat(s));
                }
            }
        }
        return res;
    }
}
