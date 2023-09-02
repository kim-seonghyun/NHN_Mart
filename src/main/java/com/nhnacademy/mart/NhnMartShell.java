package com.nhnacademy.mart;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NhnMartShell {
    private static final Logger logger = Logger.getLogger("NhnMartShell");

    public static Logger getLogger(){
        logger.setLevel(Level.ALL);
        return logger;
    }
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
        logger.info("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
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
