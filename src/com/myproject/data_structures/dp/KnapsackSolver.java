package com.myproject.data_structures.dp;

public interface KnapsackSolver {
    // Shared test arrays
    int[][] items1 = {{60, 10}, {100, 20}, {120, 30}, {80, 40}, {150, 15}}; // {value, weight}
    int K1 = 60;
    int[][] items2 = {{20, 2}, {30, 3}, {50, 4}, {60, 5}, {100, 9}};
    int K2 = 10;

    double fractionalKnapsack(int[][] items, int K);

    int knapsack01_Rec(int[][] items, int W);

    int knapsack01_MemoDP(int[][] items, int W);

    int knapsack01_TabDP(int[][] items, int W);
}
