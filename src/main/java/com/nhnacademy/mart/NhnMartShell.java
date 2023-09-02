package com.nhnacademy.mart;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NhnMartShell {
    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer seonghyun = new Customer(buyList);

        // 장바구니를 챙긴다.
        seonghyun.bring(mart.provideBasket());

        // 식품을 담는다.
        seonghyun.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        // basket 채우면 될듯
        // basket 안에 Food 객체 있음.
        // basket 순회 하면서 가격 리턴.
        seonghyun.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] inputs = input.split(" ");
        BuyList buyList = new BuyList();
        for (int i = 0; i < inputs.length; i += 2) {
            buyList.add(new BuyList.Item(inputs[i], Integer.parseInt(inputs[i + 1])));
        }

        return buyList;
    }
}
