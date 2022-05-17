package com.neta.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
//        转成 包装流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("Hello Server");

        bufferedWriter.newLine();  // 插入一个换行符
        bufferedWriter.flush();  // 使用字符流需要刷新，否则不会写入

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = bufferedReader.readLine();
        System.out.println(line);

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
