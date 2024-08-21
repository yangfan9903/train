package com.example.executorServiceDemo2;

import java.util.concurrent.Callable;

class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=i;
        }
        return Thread.currentThread().getName()+"  "+"1-"+n+"的加和为"+sum;
    }
}
