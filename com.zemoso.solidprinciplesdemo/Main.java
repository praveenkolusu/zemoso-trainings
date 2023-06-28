package com.zemoso.solidprinciplesdemo;

public class Main {
    public static void main(String[] args) {

        Laptop[] laptop = new Laptop[2];
        laptop[0] = new DiscountOnDellLaptop(45000, 10);
        laptop[1] = new DiscountOnHPLaptop("white", 50000);
        DiscountCalculator discountcal = new DiscountCalculator();
        discountcal.calculateDiscountPrice(laptop);
    }
}