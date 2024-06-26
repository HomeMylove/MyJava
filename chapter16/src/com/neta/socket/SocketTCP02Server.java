package com.neta.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len;
        while ((len = inputStream.read(buf)) != -1)
            System.out.println(new String(buf,0,len));


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello Client".getBytes());
        socket.shutdownOutput();  // 结束标记

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
