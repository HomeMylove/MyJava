package com.neta.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
//        1.创建一个 DatagramSocket 对象, 在 9999 端口接收数据
        DatagramSocket socket = new DatagramSocket(9999);
//        2.构建一个 DatagramPacket 对象，准备接收数据
//        一个数据包最大 64k
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

//        3.调用接收方法，将 网络传输的 DatagramPacket 对象填充到 packet 对象
//        如果没有数据发送到本机 9999 端口，会阻塞
        System.out.println("接收端A在等待...");
        socket.receive(packet);

//        4.拆包 packet
        int length = packet.getLength();  // 实际的数据长度
        byte[] data = packet.getData();
        String str = new String(data,0,length);
        System.out.println(str);

//       回送
        data = "好的 明天见~".getBytes();
        packet =  new DatagramPacket(data,data.length, InetAddress.getLocalHost(),9998);
        socket.send(packet);


        socket.close();
        System.out.println("A端退出");

    }
}
