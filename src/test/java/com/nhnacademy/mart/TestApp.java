package com.nhnacademy.mart;


import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestApp {
    @Test
    @Description("input func 확인")
    public void testInput(){
        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("사과", 200));

        Assertions.assertEquals(buyList.getItems().get(0), "사과");
    }

    @Test
    @Description("FoodStand delete 테스트")
    public void testDelete(){
        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("apple", 200));
        foodStand.add(new Food("apple", 200));
        foodStand.add(new Food("apple", 200));

        foodStand.delete(new BuyList.Item("apple", 3));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            foodStand.delete(new BuyList.Item("apple", 1));
        });
    }

    @Test
    @Description("FoodStand 더 많은양 주문 테스트")
    public void testDeleteOverflow(){
        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("apple", 200));
        foodStand.add(new Food("apple", 200));
        foodStand.add(new Food("apple", 200));


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            foodStand.delete(new BuyList.Item("apple", 4));
        });
    }

    @Test
    @Description("FoodStand 없는 음식 주문 테스트")
    public void testDeleteUnderflow(){
        FoodStand foodStand = new FoodStand();

        Assertions.assertThrows(IllegalArgumentException.class , ()->{
            foodStand.delete(new BuyList.Item("apple", 1));
        });
    }


}
