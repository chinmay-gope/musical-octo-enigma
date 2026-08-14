package com.myproject.introduction.arrays;

//Input:
//arr1 = [1, 4, 7, 8, 10]
//arr2 = [2, 3, 9]
//Output: [1,2,3,4,7,8,9,10]
public class Lab2 {

    void main() {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};

        int maxProfit = maxProfit(stockPrices);

        System.out.println("maxProfit = " + maxProfit);
    }

    void merge(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];

        int i = 0, j = 0, idx = 0;

//        while ()
    }


    //    {7, 1, 5, 3, 6, 4}
    public int maxProfit(int[] prices) {
        int maxProfit = 0, bestBuy = prices[0]; //7

        for (int price : prices) { //price:1
            if (price >= bestBuy) {  // 1 > 7
                maxProfit = Math.max(maxProfit, price - bestBuy); // max(0,0)
            }
            bestBuy = Math.min(bestBuy, price); // 7 ()
        }

        System.out.println("bestBuy = " + bestBuy);
        return maxProfit;
    }
}
