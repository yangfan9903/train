package com.example.catchDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker {
    private List<Integer> hongbaos;
    Random r = new Random();
    public Integer catchMoney(){
        int n = r.nextInt(hongbaos.size());
        int money=hongbaos.get(n);
        hongbaos.remove(n);
        System.out.println(Thread.currentThread().getName()+" 抢到了"+money+"元");
        return money;
    }
}
