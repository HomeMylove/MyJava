package com.neta.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

// 演示 INetAddress
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
//        获取本机的 InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);


//        根据指定主机名，获取 InetAddress 对象
        InetAddress byName = InetAddress.getByName("DESKTOP-I9EJ2FT");
        System.out.println("host1="+byName);

//        根据指定域名，获取 InetAddress 对象
        InetAddress byName1 = InetAddress.getByName("www.baidu.com");
        System.out.println("baidu="+byName1);

//      根据 InetAddress 对象，获取 ip 地址
        String hostAddress = byName1.getHostAddress();
        System.out.println("hostAddress="+hostAddress);

//        获取主机名
        String hostName = byName1.getHostName();
        System.out.println("hostName="+hostName);
    }
}
