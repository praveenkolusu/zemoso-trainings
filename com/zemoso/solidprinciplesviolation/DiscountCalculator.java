package com.zemoso.solidprinciplesviolation;

//code is violate the SRP by separating these responsibilities into different classes.
class DiscountCalculator {
    public double calculateDiscountPrice(Laptop[] laptops) {
        double discountPrice = 0;
        for (Laptop laptop : laptops) {
            discountPrice = laptop.discountPrice();
        }
        return discountPrice;
    }
}
class DiscountPrinter {
    public void printDiscount(double discountPrice) {
        System.out.println(discountPrice);
    }
}


