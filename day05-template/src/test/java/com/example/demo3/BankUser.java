package com.example.demo3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankUser {
    private String username;
    private double money;
    private final Lock lk = new ReentrantLock();
    public void saveMoney(double money)
    {
        this.money += money;
    }

    public void drawMoney(double money)
    {
        String name = Thread.currentThread().getName();
        lk.lock();
        try {
            if (this.money>=money){
                System.out.println(name+"取走了"+money);
                this.money -= money;
                System.out.println("该账户剩余"+this.money);
            }else{
                System.out.println(name+"取款失败");
            }
        } finally {
            lk.unlock();

        }
    }
}
