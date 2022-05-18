package com.neta.qqclient.service;

import com.neta.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread{
//    需要持有 socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
//        因为 Thread 需要在后台和服务器通信，所以使用 while 循环
        while (true){
            System.out.println("等待服务器的消息...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message ms = (Message) ois.readObject();  // 如果没有发送,readObject 会阻塞

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //    为了取得 socket，提供 setter 和 getter
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
