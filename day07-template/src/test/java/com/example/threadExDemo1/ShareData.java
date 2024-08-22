package com.example.threadExDemo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
