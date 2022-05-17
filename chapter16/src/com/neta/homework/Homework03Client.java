package com.neta.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9000);

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入想要获取的歌曲");
        String s = scanner.nextLine();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(s.getBytes());
        socket.shutdownOutput();

        byte[] data = StreamUtils.streamToByteArray(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\music\\music.mp3"));
        bos.write(data);
        System.out.println("写入完毕");

        outputStream.close();
        bos.close();
        socket.close();

    }
}
