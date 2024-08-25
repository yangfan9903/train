package com.example.tcpdDemo3;

import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true){
                    String msg = dis.readUTF();
                    if (msg.equals("exit")) {
                        System.out.println("客户端" + socket.getInetAddress().getHostAddress() + "已下线");
                        socket.close();
                        break;
                    }
                    System.out.println("收到来自客户端"+socket.getInetAddress().getHostAddress()+"的消息：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
