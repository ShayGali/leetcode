package algorithms.easy.sort_the_people_2418;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {


    class Solution1 {
        public String[] sortPeople(String[] names, int[] heights) {
            String[] res = new String[names.length];
            int maxIndex = 0;
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < heights.length; j++) {
                    if (heights[j] > heights[maxIndex])
                        maxIndex = j;
                }
                res[i] = names[maxIndex];
                heights[maxIndex] = -1;
            }
            return res;
        }
    }


    class Solution2 {
        public String[] sortPeople(String[] names, int[] heights) {
            NameToHeight[] arr = new NameToHeight[names.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new NameToHeight(names[i], heights[i]);
            }
            Arrays.sort(arr, Comparator.comparingInt(o -> -o.height));
            return Arrays.stream(arr).map(o -> o.name).toArray(String[]::new);
        }

        static class NameToHeight {
            String name;
            int height;

            public NameToHeight(String name, int height) {
                this.name = name;
                this.height = height;
            }
        }

    }
}
