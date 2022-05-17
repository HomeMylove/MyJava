package com.neta.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
//        在本机的 9999 端口监听，等待连接
//        细节：要求 9999 端口没有被占用
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("监听 9999 端口，等待连接。。。");
//        没有连接 9999 端口时，会阻塞
//        如果有连接，会返回一个 Socket 对象
        Socket accept = serverSocket.accept();
        System.out.println("服务端 socket=" + accept.getClass());

        InputStream inputStream = accept.getInputStream();
        byte[] data = new byte[1024];
        int len;
        while ((len = inputStream.read(data)) != -1)
            System.out.println(new String(data,0,len));

        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
