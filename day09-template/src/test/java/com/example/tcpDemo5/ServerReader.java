package com.example.tcpDemo5;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try {
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=utf-8");
            ps.println();//必须进行换行操作
            ps.println("<html>");
            ps.println("<h1>Hello World</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
