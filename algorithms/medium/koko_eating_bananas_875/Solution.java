package algorithms.medium.koko_eating_bananas_875;


public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        // get the max val of the piles
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) max = piles[i];
        }

        // start binary search
        int l = 1, r = max;
        int res = max; // the result
        while (l <= r) {
            int k = (l + r) / 2; // the mid - the k of this iteration
            // count the hours for this k
            int hours = 0;
            for (int pile : piles) {
                hours += pile / k;
                if (pile%k!=0)hours++;
            }

            if (hours <= h) {
                res = Math.min(res, k); // update the res if we need
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }

    /*
    // brute force
    //O(max(piles)*len(piles))
    public int minEatingSpeed(int[] piles, int h) {
        double i = 1, counter;
        while (true) {
            counter = 0;
            for (int pile : piles) {
                counter += Math.ceil(pile / i);
            }
            if (counter <= h) return (int) i;
            i++;
        }
    }
     */
}
