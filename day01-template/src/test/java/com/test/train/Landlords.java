package com.test.train;

import java.util.ArrayList;
import java.util.Random;

public class Landlords {
    public static void main(String[] args) {
        String[] name = {"1","2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        // 准备四种花色
        String[] color = {"♥","♦","♣","♠"};
        ArrayList<String> cards = new ArrayList<>();
        ArrayList<String> newcards = new ArrayList<>();
        for (String s : name) {
            for (int i = 0; i < color.length; i++) {
                cards.add(s+color[i]);
            }
        }
        cards.add("queen1");
        cards.add("queen2");
        System.out.println("========开始洗牌========");
        newcards = washcard(cards);
        System.out.println(newcards);

    }
    public static ArrayList<String> washcard(ArrayList<String> cards){
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int exchangenum = random.nextInt(cards.size());
            String a = cards.get(i);
            cards.set(i, cards.get(exchangenum));
            cards.set(exchangenum, a);
        }
        return cards;
    }
}
