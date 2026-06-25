package com.myproject.introduction;

public class Introduction {

    static void main() {
        double totalAmount = 363;
        double perCost = 18.5;
        double forChoco = 5;

        double canPurchase = Math.floor(totalAmount / perCost);
        double freeChoco = Math.floor(canPurchase / forChoco);

        double totalChoco = canPurchase + freeChoco;

        double remainingAmount = totalAmount % perCost;

        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Each Choco Cost: " + perCost);
        System.out.println("-------------------------------");
        System.out.println("Can Purchase: " + canPurchase);
        System.out.println("Free Choco: " + freeChoco);
        System.out.println("Total Choco: " + totalChoco);
        System.out.println("Remaining Amount: " + remainingAmount);
    }
}
