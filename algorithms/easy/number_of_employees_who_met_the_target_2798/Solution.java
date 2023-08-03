package algorithms.easy.number_of_employees_who_met_the_target_2798;

import java.util.Arrays;

public class Solution {


    public int numberOfEmployeesWhoMetTarget1(int[] hours, int target) {
        int c = 0;
        for (int h : hours) if (target <= h) c++;
        return c;
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).filter(e -> e >= target).count();
    }
}
