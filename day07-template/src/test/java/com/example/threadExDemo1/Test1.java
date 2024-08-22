package com.example.threadExDemo1;

public class Test1 {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        shareData.write("dasd");
        shareData.read();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    shareData.write(Thread.currentThread().getName());
                    System.out.println("执行了");
                }
            },"进程"+(i+1)).start();
        }
        new Thread(()->{
            shareData.read();
        }).start();



    }
}
