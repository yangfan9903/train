package com.example.catchDemo;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.concurrent.Callable;

public class CatchHongbao extends Thread {
    private static TreeMap<String, Integer> records;
    private List<Integer> hongbaos;
    Random r = new Random();

    public CatchHongbao(String name, TreeMap<String, Integer> records, List<Integer> hongbaos) {
        //对进程进行命名
        super(name);
        this.records = records;
        this.hongbaos = hongbaos;
    }

    public static TreeMap<String, Integer> getRecords() {
        return records;
    }

    @Override
    public void run(){
        while (true) {
            synchronized (hongbaos) {
                if (hongbaos.isEmpty()){
                    break;
                }
                int n = r.nextInt(hongbaos.size());
                int money = hongbaos.remove(n);
                System.out.println(Thread.currentThread().getName() + " 抢到了" + money + "元");
                records.put(Thread.currentThread().getName(), records.get(Thread.currentThread().getName()) + money);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (hongbaos.isEmpty()){
                    System.out.println("活动结束");
                    // 将records 排序
                    records.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

                    break;
                }
            }
        }
    }
}
