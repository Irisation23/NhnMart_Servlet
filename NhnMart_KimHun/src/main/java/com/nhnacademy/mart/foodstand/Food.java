package com.nhnacademy.mart.foodstand;

public interface Food {
    int getPrice();
    int getQuantity();
    void deductFood(int basketCnt);
}
