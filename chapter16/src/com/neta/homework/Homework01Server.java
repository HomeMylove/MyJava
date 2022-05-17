package com.neta.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("服务端在等待");
        Socket socket = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();

        String reply;
        switch (line){
            case "name":
                reply = "我是nova";
                break;
            case "hobby":
                reply = "编写java程序";
                break;
            default:
                reply = "你说啥呢";
                break;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(reply);
        bw.newLine();
        bw.flush();
        System.out.println("发送成功");
        br.close();
        bw.close();
        socket.close();
        serverSocket.close();
    }
}
