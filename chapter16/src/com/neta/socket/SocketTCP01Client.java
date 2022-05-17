package com.neta.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
//        连接服务器(ip,端口)
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
//        连接上后，生成 Socket
//        通过 socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("hello world".getBytes());
        outputStream.close(); // 关闭流
        socket.close();       // 关闭 socket
        System.out.println("客户端退出");
    }
}
