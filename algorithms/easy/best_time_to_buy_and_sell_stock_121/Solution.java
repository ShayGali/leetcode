package algorithms.easy.best_time_to_buy_and_sell_stock_121;

public class Solution {

    public int maxProfit(int[] prices) {
        int currMin = prices[0];
        int bestProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < currMin)
                currMin = prices[i];
            else if (bestProfit < (prices[i] - currMin)) {
                bestProfit = prices[i] - currMin;
            }
        }
        return bestProfit;
    }

    // with dynamic programming
    public int maxProfit2(int[] prices) {
        int[] mem = new int[prices.length];
        int currMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            mem[i] = prices[i] - currMin;
            if (prices[i] < currMin)
                currMin = prices[i];
        }
        int res = 0;
        for (int i = 1; i < mem.length; i++) {
            if (mem[i] > res)
                res = mem[i];
        }
        return res;
    }
}
