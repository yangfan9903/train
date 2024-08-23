package com.example.threadExDemo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareData {

    private List<String> list = new ArrayList<>();

    public synchronized void read(){
        System.out.println(list);
    }
    public synchronized void write(String name){
        this.list.add(name);
    }
    public synchronized void sortList(){
        Collections.sort(list);
    }

}
