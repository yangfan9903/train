package com.example.threadDemo;

public class Demo1 {
    public static void main(String[] args) {
        Desk desk = new Desk();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                desk.makeFood();
//            }
//        }).start();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true){
                    desk.makeFood();
                }
            },"厨师"+ (i + 1)).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true){
                    desk.eatFood();
                }

            },"吃货"+(i+1)).start();
        }

    }


}
