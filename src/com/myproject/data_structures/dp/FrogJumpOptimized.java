package com.myproject.data_structures.dp;

public class FrogJumpOptimized implements FrogJumpSolver {
    static void main() {
        FrogJumpSolver solver = new FrogJumpOptimized();
        System.out.println("Frog Jump Optimized result ht1 = " + solver.minCost(FrogJumpSolver.ht1)); // 30
        System.out.println("Frog Jump Optimized result ht2 = " + solver.minCost(FrogJumpSolver.ht2)); // 20
    }

    @Override
    public int minCost(int[] ht) {
        int n = ht.length;
        if (n == 1) return 0;

        int cost2 = 0;
        int cost1 = Math.abs(ht[1] - ht[0]);
        int curr = cost1;

        for (int i = 2; i < n; i++) {
            int fromPrev = cost1 + Math.abs(ht[i] - ht[i - 1]);
            int fromPrevPrev = cost2 + Math.abs(ht[i] - ht[i - 2]);
            curr = Math.min(fromPrev, fromPrevPrev);

            cost2 = cost1;
            cost1 = curr;
        }
        return curr;
    }
}
