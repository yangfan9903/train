package com.example.catchDemo;

import sun.reflect.generics.tree.Tree;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> hongbaos = new ArrayList();
        TreeMap<String,Integer> records = new TreeMap<String,Integer>();
//        ExecutorService pool = new ThreadPoolExecutor(3,5,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
//                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 200; i++) {
            if (i<100){
                records.put("员工"+String.valueOf(i),0);
            }

            if (i < 160){
                hongbaos.add(r.nextInt(30)+1);
            }
            else {
                hongbaos.add(r.nextInt(70)+31);
            }
        }

            for (int i = 0; i < 100; i++) {
                new CatchHongbao("员工"+String.valueOf(i),records,hongbaos).start();
            }
        // 在以上所有进程结束后，打印records
//            records = CatchHongbao.getRecords();







    }
}
