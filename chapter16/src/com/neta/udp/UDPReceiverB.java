package com.neta.udp;

import java.io.IOException;
import java.net.*;

public class UDPReceiverB {
    public static void main(String[] args) throws IOException {
//        1.创建一个 DatagramSocket 对象, 在 9998 端口发送数据
        DatagramSocket socket = new DatagramSocket(9998);

//        2.将数据封装 到 DatagramPacket 对象
        byte[] data = "Hello 明天吃火锅".getBytes();
//        byte buf[], int length,
//        InetAddress address, int port
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        socket.send(packet);

//        接收 A 的回复
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        int length = packet.getLength();
        data = packet.getData();

        String s = new String(data, 0, length);
        System.out.println("B端收到" + s);

        socket.close();
        System.out.println("B端退出");
    }
}
