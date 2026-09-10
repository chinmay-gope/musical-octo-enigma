package com.myproject.introduction.abstraction.impl;

import com.myproject.introduction.abstraction.FoodOrder;

public class PizzaOrder extends FoodOrder {
    @Override
    public double calculateBill() {
        return 100 + deliveryCharge();
    }

    @Override
    public double deliveryCharge() {
        return 50;
    }
}
