package com.example.shareDataDemo1;

import java.util.concurrent.CopyOnWriteArrayList;

public class Demo1 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        Thread reader1 = new Thread(new ReadTask(list),"Reader-1");
        Thread reader2 = new Thread(new ReadTask(list),"Reader-2");
        Thread reader3 = new Thread(new ReadTask(list),"Reader-3");
        Thread writer = new Thread(new WriteTask(list),"Writer-1");
        reader1.start();
        reader2.start();
        reader3.start();
        writer.start();
        try {
            reader1.join();
            reader2.join();
            reader3.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);

    }
}
