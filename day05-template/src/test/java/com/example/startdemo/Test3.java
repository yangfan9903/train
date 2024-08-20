package com.example.startdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test3 {
    public static void main(String[] args) {
        Callable<String> myThread2 = new MyThread2(10);
        FutureTask<String> task = new FutureTask<>(myThread2);
        Thread t1 = new Thread(task);
        t1.start();
        try {
            System.out.println(task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Callable<String> myThread3 = new MyThread2(15);
        FutureTask<String> task1 = new FutureTask<>(myThread3);
        Thread t2 = new Thread(task1);
        t2.start();
        try {
            System.out.println(task1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
class MyThread2 implements Callable<String> {
    private int n;
    public MyThread2(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=i;
        }
        return "1-"+n+"的加和为"+sum;
    }
}
