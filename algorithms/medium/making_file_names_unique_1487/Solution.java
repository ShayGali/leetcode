package algorithms.medium.making_file_names_unique_1487;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"})));
    }

    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (names[i].equals(res[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res[i] = names[i];
            } else {
                Set<Integer> set = new HashSet<>();
                int min = 1;
                for (int j = 0; j < i; j++) {
                    if (res[j].matches(names[i].concat("\\([0-9]\\)"))) {

                        set.add(res[j].charAt(res[j].length() - 2) - '0');
                    }
                }
                res[i] = names[i].concat("(").concat(String.valueOf(set.stream().min(Integer::compareTo).get() + 1)).concat(")");
            }
        }
        return res;
    }
}
