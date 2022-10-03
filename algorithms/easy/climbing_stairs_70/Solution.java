
package algorithms.easy.climbing_stairs_70;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
    // using map
    // Runtime 1 ms, Memory - 40.7
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return help(n, memo);
    }

    public int help(int n, Map<Integer, Integer> memo) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo.containsKey(n)) return memo.get(n);
        int clac = help(n - 1, memo) + help(n - 2, memo);
        memo.put(n, clac);
        return clac;
    }
     */

    // with array
    // Runtime 0ms
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return 2;
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;
        return help(n, memo);
    }

    public int help(int n, int[] memo) {
        if (memo[n - 1] != 0) return memo[n - 1];
        memo[n - 1] = help(n - 1, memo) + help(n - 2, memo);
        return memo[n - 1];
    }
}
