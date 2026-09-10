package com.myproject.introduction.abstraction.impl;

import com.myproject.introduction.abstraction.FoodOrder;

public class BurgerOrder extends FoodOrder {
    @Override
    public double calculateBill() {
        return 200 + deliveryCharge();
    }

    @Override
    public double deliveryCharge() {
        return 70;
    }
}
