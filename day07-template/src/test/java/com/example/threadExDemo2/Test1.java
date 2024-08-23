package com.example.threadExDemo2;

import java.util.Currency;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

//    public void turnToThreadA() throws InterruptedException {
//        lock.lock();
//        conditionA.await();
//    }
//    private static void await() throws InterruptedException {
//        lock.lock();
//        try {
//            condition.await();
//        } finally {
//            lock.unlock();
//        }
//    }
//    private static void signal() {
//        lock.lock();
//        try {
//            condition.signalAll();
//        } finally {
//            lock.unlock();
//        }
//    }
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
//        Condition conditionB = lock.newCondition();
//        Condition conditionC = lock.newCondition();
        ShareData shareData = new ShareData();
//        shareData.write("dasd");
//        shareData.read();
        Thread t1 = new Thread(()->{
            lock.lock();
            try {

                System.out.println("进入等待状态");
                conditionA.await();
                System.out.println("结束等待状态");
                shareData.read();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        });
            new Thread(() -> {

                for (int i = 0; i < 10; i++) {
                    int finalI = i;
                shareData.write(Thread.currentThread().getName());
                System.out.println(finalI);
                System.out.println("执行了");

                    if (finalI == 5){
                        lock.lock();
                    try {
                        System.out.println("其他线程唤醒了");
                        conditionA.signal();

//                        t1.join();
                        System.out.println("t1执行法币");

                    } finally {
                        System.out.println("释放了锁");
                        lock.unlock();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    }

                }
            },"进程1").start();


        t1.start();



    }
}
