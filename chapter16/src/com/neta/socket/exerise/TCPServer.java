package com.neta.socket.exerise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        String fileName = "E:\\dva520.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        bos.write(bytes);
        bos.close();


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.newLine();
        bw.flush();
        bw.close();

        bis.close();
        socket.close();
        serverSocket.close();
    }
}
