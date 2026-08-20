package com.myproject.introduction.arrays;

import java.util.Arrays;

//Input:
//arr1 = [1, 4, 7, 8, 10]
//arr2 = [2, 3, 9]
//Output: [1,2,3,4,7,8,9,10]
public class Lab2 {

    void main() {
        int[] stockPrices = {7, 2, 5, 3, 6, 1};
//        stockPrices = new int[]{7, -2, 1, -9, 17, -19};
//        stockPrices = new int[]{7, 6, 4, 3, 1};

        System.out.println("Profit: " + maxProfit(stockPrices));

        int[] A = {1, 4, 7, 8, 10};
        int[] B = {2, 3, 9};

        merge(A, B);
    }

    void merge(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;

        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        while (i < A.length) {
            C[k++] = A[i++];
        }

        while (j < B.length) {
            C[k++] = B[j++];
        }

        System.out.println(Arrays.toString(C));
    }


    public int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = 0;
        int buy = 0, sell = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
                buy = minPrice;
                sell = price;
            }
        }

        System.out.println("Buy at: " + buy);
        System.out.println("Sell at: " + sell);
        return maxProfit;
    }

}
