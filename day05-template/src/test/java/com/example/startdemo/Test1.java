package com.example.startdemo;

public class Test1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);

        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
