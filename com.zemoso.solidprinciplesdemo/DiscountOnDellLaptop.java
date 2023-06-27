package com.zemoso.solidprinciplesdemo;

public class DiscountOnDellLaptop implements Laptop {

    double originalPrice;
    double discountPercentage;

    public DiscountOnDellLaptop(double originalPrice, double discountPercentage) {

        this.originalPrice = originalPrice;
        this.discountPercentage = discountPercentage;
    }

    public double discountPrice() {

        double discountAmount;
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            discountAmount = (discountPercentage / 100) * originalPrice;
        } else {
            discountAmount = 0;
        }
        return discountAmount;
    }
}