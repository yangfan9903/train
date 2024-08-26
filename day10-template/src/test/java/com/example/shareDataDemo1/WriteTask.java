package com.example.shareDataDemo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.CopyOnWriteArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WriteTask implements Runnable{
    private CopyOnWriteArrayList<Integer> list;

    @Override
    public void run() {
        for (int i = 10; i < 15; i++){
            list.add(i);
            System.out.println(Thread.currentThread().getName() + "写入的数据是" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
