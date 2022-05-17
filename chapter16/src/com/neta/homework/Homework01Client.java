package com.neta.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Homework01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9000);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String str = "name";
        bw.write(str);
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();

        System.out.println("收到回复"+line);

        bw.close();
        br.close();
        socket.close();
    }
}
