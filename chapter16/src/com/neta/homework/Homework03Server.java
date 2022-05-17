package com.neta.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);

        System.out.println("服务器等待请求...");
        Socket socket = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();

        File fatherPath = new File("E:\\music");
        String fileName;
        System.out.println("name="+s);
        if(s.equals("crack"))
            fileName = "crack.mp3";
        else if(s.equals("decide"))
            fileName = "decide.mp3";
        else
            fileName = "grief.flac";

        byte[] data = StreamUtils.streamToByteArray(new FileInputStream(new File(fatherPath, fileName)));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(data);
        socket.shutdownOutput();
        bos.close();

        System.out.println("发送成功"+fileName);
        br.close();
        socket.close();
        serverSocket.close();
    }
}
