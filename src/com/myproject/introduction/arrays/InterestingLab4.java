package com.myproject.introduction.arrays;

import java.util.Arrays;

// Bridge Crossing Problem (Generalized)
// -------------------------------------
// We have N persons with different crossing times.
// The bridge can hold at most 2 persons at a time.
// The crossing time is determined by the slower person.
// Example: if p3 (5 min) and p4 (10 min) go together, they take 10 minutes.
// Goal: Find the minimum total time for all to cross.
public class InterestingLab4 {

    static void main() {
        int[] times = {1, 2, 5, 10};
        int[] times2 = {1, 2, 7, 15};
        int[] times3 = {1, 3, 6, 8, 12};

//        solve(times);
//        solve(times2);
//        solve(times3);
        int minTime = findMinTime(times);
        System.out.println("Minimum time for all to cross: " + minTime + " minutes");

        minTime = findMinTime(times2);
        System.out.println("Minimum time for all to cross: " + minTime + " minutes");

        minTime = findMinTime(times3);
        System.out.println("Minimum time for all to cross: " + minTime + " minutes");

        String commonPrefix = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println("longestCommonPrefix : " + commonPrefix);
    }

    public static int findMinTime(int[] t) {

        Arrays.sort(t);

        int total = 0;
        int n = t.length;

        // While more than 3 people remain
        while (n > 3) {
           /*  Strategy A: fastest + second-fastest cross, fastest returns,
                         two slowest cross, second-fastest returns */
            int strategyA = t[0] + 2 * t[1] + t[n - 1];

          /*   Strategy B: fastest + slowest cross, fastest returns,
                         fastest + second-slowest cross, fastest returns */
            int strategyB = 2 * t[0] + t[n - 2] + t[n - 1];

            total += Math.min(strategyA, strategyB);

            // Two slowest are now across
            n -= 2;
        }

        // Handle the last 3 or fewer people
        if (n == 3) {
            total += t[0] + t[1] + t[2];
        } else if (n == 2) {
            total += t[1];
        } else if (n == 1) {
            total += t[0];
        }

        return total;
    }

    private static void solve(int[] t) {
        Arrays.sort(t);
        System.out.println("\nCrossing times: " + Arrays.toString(t));
        int minTime = findMinTimeDisplay(t);
        System.out.println("Minimum time for all to cross: " + minTime + " minutes");
    }

    private static int findMinTimeDisplay(int[] t) {
        int total = 0;
        int n = t.length;

        while (n > 3) {
            int strategyA = t[0] + 2 * t[1] + t[n - 1];
            int strategyB = 2 * t[0] + t[n - 2] + t[n - 1];

            if (strategyA <= strategyB) {
                // Strategy A chosen
                System.out.println("-> " + t[0] + " and " + t[1] + " cross (" + t[1] + " min)");
                System.out.println("<- " + t[0] + " returns (" + t[0] + " min)");
                System.out.println("-> " + t[n - 2] + " and " + t[n - 1] + " cross (" + t[n - 1] + " min)");
                System.out.println("<- " + t[1] + " returns (" + t[1] + " min)");
                total += strategyA;
            } else {
                // Strategy B chosen
                System.out.println("-> " + t[0] + " and " + t[n - 1] + " cross (" + t[n - 1] + " min)");
                System.out.println("<- " + t[0] + " returns (" + t[0] + " min)");
                System.out.println("-> " + t[0] + " and " + t[n - 2] + " cross (" + t[n - 2] + " min)");
                System.out.println("<- " + t[0] + " returns (" + t[0] + " min)");
                total += strategyB;
            }

            n -= 2;
        }

        if (n == 3) {
            System.out.println("-> " + t[0] + " and " + t[1] + " cross (" + t[1] + " min)");
            System.out.println("<- " + t[0] + " returns (" + t[0] + " min)");
            System.out.println("-> " + t[0] + " and " + t[2] + " cross (" + t[2] + " min)");
            total += t[0] + t[1] + t[2];
        } else if (n == 2) {
            System.out.println("-> " + t[0] + " and " + t[1] + " cross (" + t[1] + " min)");
            total += t[1];
        } else if (n == 1) {
            System.out.println("-> " + t[0] + " crosses alone (" + t[0] + " min)");
            total += t[0];
        }

        return total;
    }

    // Leetcode 14
    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    //Leetcode 739
    private int[] dailyTemperatures(int[] temperatures) {
        return null;
    }
}
