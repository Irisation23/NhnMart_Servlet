package com.nhnacademy.mart.foodstand;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Food> basketFoods = new ArrayList<>();

    public void pickupFood(List<Food> buyList){
        basketFoods = buyList;
    }

    public boolean checkMaxFoodNum(List<Food> foodList) {
        for (int i = 0; i < foodList.size(); i++) {
            if(foodList.get(i).getQuantity() < basketFoods.get(i).getQuantity()){
                return false;
            }
        }
        return true;
    }

    public int calcToMoney() {
        int amount = 0;

        for (int i = 0; i < basketFoods.size(); i++) {
            amount += basketFoods.get(i).getPrice() * basketFoods.get(i).getQuantity();
        }

        return amount;
    }

    public List<Food> getBasketFoods() {
        return basketFoods;
    }
}
