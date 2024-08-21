package com.example.executorServiceDemo1;

import java.util.concurrent.*;

public class ExecutorServiceDemo1 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3,5,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Runnable target = new MyRunnable();
        for (int i = 0; i < 5; i++) {
            pool.execute(target);
        }
    }
}
