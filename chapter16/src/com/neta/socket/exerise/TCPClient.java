package com.neta.socket.exerise;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\dva.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        bos.write(bytes);
        bis.close();
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        String str = StreamUtils.streamToString(inputStream);
        System.out.println(str);
        inputStream.close();

        bos.close();
        socket.close();
    }
}
