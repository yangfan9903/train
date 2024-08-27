package com.example.volatileDemo1;

import java.util.ArrayList;
import java.util.Collections;

public class Demo1 {
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Collections.addAll(list,1);
        Thread t1 = new Thread(()->{
            int i = 6;
            while (true){
                list.add(i);
                i++;
                System.out.println("count被增加了");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
//        Thread t1 = new WriteExample(count);
        Thread t2 = new Thread(()->{
            while (true) {
                System.out.println(list);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}

