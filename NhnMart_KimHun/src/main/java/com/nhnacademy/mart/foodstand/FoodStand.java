package com.nhnacademy.mart.foodstand;

import java.util.ArrayList;
import java.util.List;

public class FoodStand {
    List<Food> foodList = new ArrayList<>();
    public void fillInFood(Food food) {
        foodList.add(food);
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
