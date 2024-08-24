package com.example.tcpDemo1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        ServerSocket ss = new ServerSocket(8080);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        DataInputStream dis= new DataInputStream(is);
        int id = dis.readInt();
        String msg = dis.readUTF();
        System.out.println("id:"+id+" msg:"+msg);
        System.out.println("客户端的ip是" + socket.getInetAddress().getHostAddress());
        System.out.println("客户端的端口是" + socket.getPort());
        ss.close();

    }
}
