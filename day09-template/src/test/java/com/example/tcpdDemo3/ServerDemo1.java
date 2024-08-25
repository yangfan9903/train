package com.example.tcpdDemo3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动了");
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            Socket socket = ss.accept();
            System.out.println("一个新的客户端上线了");
            ServerReader sr = new ServerReader(socket);
            sr.start();

        }
    }
}
