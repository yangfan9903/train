package com.example.tcpDemo5;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class ServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动了");
        ServerSocket ss = new ServerSocket(8080);
        ExecutorService pool = new ThreadPoolExecutor(3,10,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        while (true){
            Socket socket = ss.accept();
            System.out.println("一个客户端上线了");
            pool.execute(new ServerReader(socket));


        }
    }
}
