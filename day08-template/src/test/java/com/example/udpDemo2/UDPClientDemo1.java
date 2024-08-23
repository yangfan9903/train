package com.example.udpDemo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======客户端启动=======");
        DatagramSocket socket = new DatagramSocket(); // 客户端不需要固定的端口，服务端接受数据需要固定的端口号
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据：");
            String s = sc.nextLine();
            if ("exit".equals(s)){
                break;
            }
            byte[] bytes = s.getBytes();
            /*
            *   public DatagramPacket(byte[] buf, int length, InetAddress address, int port)
            *   参数一：发送的数据，字节数据
            *   参数二：发送的字节长度
            *   参数三：目的地的IP地址
            *   参数四：目的地的端口号
            * */
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8080);
            socket.send(packet);
        }
    }
}
