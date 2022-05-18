package com.neta.qqserver.service;

import com.neta.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread{
    private final Socket socket;
    private final String userId;// 连接到客户端的 userId

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
//        可以发送或者接收消息
        while (true){
            try {
                System.out.println("服务端和客户端保持通信..."+userId);
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}
