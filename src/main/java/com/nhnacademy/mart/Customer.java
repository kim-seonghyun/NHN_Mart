package com.nhnacademy.mart;

import java.util.ArrayList;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }



    // TODO pickFoods 메서드 구현
    // basket에 담아야 하나?
    // buyList , foodstand의 재고를 비교하기
    public void pickFoods(FoodStand foodStand) {
        ArrayList<BuyList.Item> buyList = new ArrayList<>();

        for(int i=0 ; i< buyList.size(); i++){
            buyList.indexOf(i);
        }
    }

    // TODO payTox 메서드 구현


}
