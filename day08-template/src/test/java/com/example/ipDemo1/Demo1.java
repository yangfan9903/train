package com.example.ipDemo1;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Slf4j
public class Demo1 {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getLocalHost();
        log.info("ip:{}", ip);
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        log.info("ip2:{}", ip2.getHostName());
        log.info("ip2:{}", ip2.getHostAddress());
        log.info(String.valueOf(ip2.isReachable(5000)));
    }
}
