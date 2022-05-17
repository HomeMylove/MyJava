package com.neta.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Homework02A {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9000);

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);

        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();

        String s = new String(data, 0,length);
        System.out.println("A收到: "+s);

        String reply;
        if(s.equals("四大名著是什么"))
            reply = "《西游》《水浒》《红楼》《三国》";
        else
            reply = "what?";

        data = reply.getBytes();
        packet = new DatagramPacket(data,data.length, InetAddress.getLocalHost(),9001);

        socket.send(packet);
        System.out.println("A发送了"+reply);

        socket.close();
        System.out.println("A关闭");
    }
}
