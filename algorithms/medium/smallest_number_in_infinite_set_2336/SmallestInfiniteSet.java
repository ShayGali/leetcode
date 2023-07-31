package algorithms.medium.smallest_number_in_infinite_set_2336;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
class SmallestInfiniteSet {
    PriorityQueue<Integer> minHeap;
    int i;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        i = 1;
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            return minHeap.poll();
        }
        return i++;
    }

    public void addBack(int num) {
        if (i > num && !minHeap.contains(num)) {
            minHeap.offer(num);
        }
    }
}

