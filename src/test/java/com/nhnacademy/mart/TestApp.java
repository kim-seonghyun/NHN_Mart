package com.nhnacademy.mart;


import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestApp {
    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        // TODO Scanner 입력을 받아 buyList 만들기

        String input = "apple 2 banana 3";

        String[] inputs = input.split(" ");
        BuyList buyList = new BuyList();
        for (int i = 0; i < inputs.length; i += 2) {
            buyList.add(new BuyList.Item(inputs[i], Integer.parseInt(inputs[i + 1])));
        }

        return buyList;

    }

    @Test
    @Description("쉘입력 받는 테스트")
    public void testInputShell() {
        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("apple", 2));
        buyList.add(new BuyList.Item("banana", 3));
        Assertions.assertEquals(inputBuyListFromShell().getItems().get(1).getName(), buyList.getItems().get(1).getName());
    }

    @Test
    @Description("input func 확인")
    public void testInput() {
        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("사과", 200));

        Assertions.assertEquals(buyList.getItems().get(0).getName(), "사과");
    }

    @Test
    @Description("FoodStand delete 테스트")
    public void testDelete() {
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
    public void testDeleteOverflow() {
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
    public void testDeleteUnderflow() {
        FoodStand foodStand = new FoodStand();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            foodStand.delete(new BuyList.Item("apple", 1));
        });
    }


    @Test
    @Description("pickFoods Overflow 테스트")
    public void testPickFoods() {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("apple", 4));


        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer seonghyun = new Customer(buyList);

        // 장바구니를 챙긴다.
        seonghyun.bring(mart.provideBasket());


        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("apple", 200));
        foodStand.add(new Food("apple", 200));
        foodStand.add(new Food("apple", 200));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            seonghyun.pickFoods(foodStand);
        });
    }

    @Test
    @Description("payTox 메서드 구현")
    public void testPayTox() {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("apple", 3));


        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer seonghyun = new Customer(buyList);

        // 장바구니를 챙긴다.
        seonghyun.bring(mart.provideBasket());


        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("apple", 200));
        foodStand.add(new Food("apple", 200));
        foodStand.add(new Food("apple", 200));

        seonghyun.pickFoods(foodStand);

        int result = seonghyun.payTox(mart.getCounter());

        Assertions.assertEquals(result, 20000 - 600);
    }
}
