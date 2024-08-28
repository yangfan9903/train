package com.example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("server is runnning");

        while (true){
            Socket socket = ss.accept();
            System.out.println("client connected from"+ socket.getRemoteSocketAddress());

            Thread t = new Handler(socket);
            t.start();
        }
    }
}
class Handler extends Thread{
    private Socket socket;
    OutputStream os = socket.getOutputStream();
    public Handler(Socket socket) throws IOException {
        this.socket = socket;
    }

    PrintStream ps = new PrintStream(os);


    DataOutputStream dos = new DataOutputStream(os);
    @Override
    public void run() {
        ps.println("HTTP/1.1 200 OK");
        ps.println("Content-Type:text/html;charset=utf-8");
        ps.println();//必须进行换行操作
        ps.println("<html>");
        ps.println("<h1>Hello World</h1>");
    }
}
