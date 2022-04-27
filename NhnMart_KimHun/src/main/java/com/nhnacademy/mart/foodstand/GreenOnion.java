package com.nhnacademy.mart.foodstand;

public class GreenOnion implements Food{
    private int price = 500;
    private int quantity;

    public GreenOnion(int quantity) {
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
    public void deductFood(int basketCnt) {
        this.quantity -= basketCnt;
    }
    @Override
    public String toString() {
        return "GreenOnion{" +
            "price=" + price +
            ", quantity=" + quantity +
            '}';
    }
}
