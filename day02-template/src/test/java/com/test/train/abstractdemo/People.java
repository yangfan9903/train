package com.test.train.abstractdemo;

public abstract class People {
    public void write(){
        System.out.println("今天星期一happy");
        writekind();
        System.out.println("今天星期四happy");
    }
    public abstract void writekind();
}
