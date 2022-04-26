package com.nhnacademy.mart.foodstand;

public class Onion implements Food{
    private int price = 1000;
    private int quantity;

    public Onion(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Onion{" +
            "price=" + price +
            ", quantity=" + quantity +
            '}';
    }
}
