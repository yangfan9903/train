package com.example.tcpdDemo3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("客户端已启动");
        Socket socket = new Socket("192.168.1.2",8080);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        while (true){
            System.out.println("请输入要发送的信息(输入exit退出)");
            String msg = sc.nextLine();
            dos.writeUTF(msg);
            if (msg.equals("exit")) break;

        }
        dos.close();
    }
}
