package com.zemoso.solidprinciplesdemo;

public class DiscountOnHPLaptop implements Laptop {

    double originalPrice;
    String color;

    public DiscountOnHPLaptop(String color, double originalPrice) {

        this.originalPrice = originalPrice;
        this.color = color;
    }

    public double discountPrice() {
        double discountAmount;
        if (color.equals("white")) {
            discountAmount = originalPrice - originalPrice * 0.9;

        } else {
            discountAmount = 0;
        }
        return discountAmount;
    }
}