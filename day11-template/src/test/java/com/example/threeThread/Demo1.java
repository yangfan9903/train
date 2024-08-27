package com.example.threeThread;

public class Demo1 {
    public static void main(String[] args) {
        Thread A = new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);

            }
        },"A");
        Thread B = new Thread(()->{

                try {
                    A.join();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }
        },"B");
        Thread C = new Thread(()->{
                try {
                    B.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);

            }
        },"C");
        A.start();
        B.start();
        C.start();
    }
}
