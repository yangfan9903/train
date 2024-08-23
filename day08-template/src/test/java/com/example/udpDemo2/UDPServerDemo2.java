package com.example.udpDemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerDemo2 {
    public static void main(String[] args) throws IOException {
        System.out.println("===========服务端启动============");
        DatagramSocket socket = new DatagramSocket(8080);
        byte[] buf = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        while (true) {
            socket.receive(packet);
            String str = new String(packet.getData(), 0, packet.getLength());
            System.out.println("服务端接收到了数据：" + str);
            // 读取接受客户端数据的ip 和 端口
            System.out.println("服务端接收到了数据：" + packet.getAddress().getHostAddress() + ":" + packet.getPort());
        }

    }
}
