package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankUser {
    private String username;
    private double money;
    public void saveMoney(double money)
    {
        this.money += money;
    }
    public void drawMoney(double money)
    {
        String name = Thread.currentThread().getName();
        if (this.money>=money){
            System.out.println(name+"取走了"+money);
            this.money -= money;
            System.out.println("该账户剩余"+this.money);
        }else{
            System.out.println(name+"取款失败");
        }
    }
}
