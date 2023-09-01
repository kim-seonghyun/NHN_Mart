package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class FoodStand {

    private static final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현
    public void add(Food food) {
        foods.add(food);
    }

    // TODO 장바구니에 담은 Food 삭제 구현
    public Food delete(BuyList.Item item) throws IllegalArgumentException {
        Food food = findFood(item);
        Food result = null;
        if (food == null) {
            throw new IllegalArgumentException("판매 하지 않는 음식입니다.");
        } else {
            result = food;
            for (int i = 0; i < item.getAmount(); i++) {

                int index = foods.indexOf(food);
                if (index == -1) {
                    throw new IllegalArgumentException("판매하는 음식보다 많은 양을 주문하였습니다.");
                }
                foods.remove(index);
                food = findFood(item);
            }
        }
        return result;
    }

    private static Food findFood(BuyList.Item item) {
        Iterator<Food> iterator = foods.iterator();
        Food food = null;
        while (iterator.hasNext()) {
            Food tmp = iterator.next();
            if (Objects.equals(item.getName(), tmp.getName())) {
                food = tmp;
                break;
            }
        }
        return food;
    }
}
