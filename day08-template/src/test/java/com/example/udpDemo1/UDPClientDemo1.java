package com.example.udpDemo1;

import java.net.*;

public class UDPClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======客户端启动=======");
        DatagramSocket socket = new DatagramSocket(); // 客户端不需要固定的端口，服务端接受数据需要固定的端口号
        byte[] bytes = "我是客户端，正在向你发送数据".getBytes();
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
