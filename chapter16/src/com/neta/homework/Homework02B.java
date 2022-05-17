package com.neta.homework;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Homework02B {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9001);

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一句话");
        String word = scanner.nextLine();
        byte[] data = word.getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9000);
        socket.send(packet);
        System.out.println("B发送了"+word);

        System.out.println("等待A...");
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);

        int length = packet.getLength();
        data = packet.getData();

        word = new String(data,0 ,length);
        System.out.println("B收到的回复： "+ word);

        socket.close();
        System.out.println("B退出");



    }
}
