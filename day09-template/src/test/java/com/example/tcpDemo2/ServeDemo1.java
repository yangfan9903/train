package com.example.tcpDemo2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端已启动");
        ServerSocket ss = new ServerSocket(8080);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        while (true){
            String msg = dis.readUTF();
            if (msg.equals("exit")) break;
            System.out.println("收到的信息是:" + msg);
        }
        ss.close();
    }
}
