package com.zemoso.solidprinciplesdemo;

public class DiscountCalculator {

    public double calculateDiscountPrice(Laptop[] laptop) {
        double discountPrice = 0;

        for (Laptop lap : laptop) {
            discountPrice = lap.discountPrice();
            System.out.println(discountPrice);
        }

        return discountPrice;
    }
}