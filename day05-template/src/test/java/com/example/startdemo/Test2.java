package com.example.startdemo;

public class Test2 {
    public static void main(String[] args) {
        Runnable t1 = new MyThread1();
        new Thread(t1).start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
class MyThread1 implements Runnable{
    public void run()
    {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
