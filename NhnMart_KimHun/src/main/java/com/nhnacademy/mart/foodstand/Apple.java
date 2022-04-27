package com.nhnacademy.mart.foodstand;

public class Apple implements Food{

    private int price = 2000;
    private int quantity;

    public Apple(int quantity) {
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
        return "Apple{" +
            "price=" + price +
            ", quantity=" + quantity +
            '}';
    }
}
