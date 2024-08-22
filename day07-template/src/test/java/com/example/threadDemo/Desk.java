package com.example.threadDemo;

import java.util.ArrayList;
import java.util.List;

public class Desk {
    private List<String> list = new ArrayList<>();

    public synchronized void makeFood() {
        try {
            if(list.isEmpty()){
                String name = Thread.currentThread().getName();
                list.add(name+"制作的包子");
                System.out.println(name + "制作了一个包子");
                Thread.sleep(2000);

                // 唤醒别人 等待自己
                this.notifyAll();
                this.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void eatFood() {
        try {
            if(!list.isEmpty()){
                String name = Thread.currentThread().getName();
                System.out.println(name+"吃了"+list.get(0));
                list.clear();
                Thread.sleep(1000);

                // 唤醒别人 等待自己
                this.notifyAll();
                this.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
