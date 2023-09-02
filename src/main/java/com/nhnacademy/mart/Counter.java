package com.nhnacademy.mart;

import java.util.ArrayList;

public class Counter {

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    public int pay(Basket basket){
        ArrayList<Food> foods = basket.getFoods();
        int cost = 0;
        for(Food food:foods){
            cost += food.getPrice();
        }
        return cost;
    }
}
