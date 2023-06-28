package com.zemoso.solidprinciplesviolation;

//To violate the LSP, we can create a subclass that breaks the contract defined by the base interface, doesn't adhere to the discount calculation behavior.
public class BasicLaptop implements Laptop{
    double originalPrice;

    public BasicLaptop(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double discountPrice() {
        return originalPrice; // No discount applied
    }
}
