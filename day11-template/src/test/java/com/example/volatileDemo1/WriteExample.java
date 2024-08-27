package com.example.volatileDemo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriteExample extends Thread{
    private volatile Integer count;
    @Override
    public void run() {
        count++;
    }

}
