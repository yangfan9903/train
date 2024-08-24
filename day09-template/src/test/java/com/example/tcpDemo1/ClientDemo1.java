package com.example.tcpDemo1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("=========客户端已启动===========");
        Socket socket = new Socket("192.168.1.2",8080);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(1);
        dos.writeUTF("你好已连接了");

        socket.close();
    }
}
