package com.neta.qqclient.service;

import com.neta.qqcommon.Message;
import com.neta.qqcommon.MessageType;
import com.neta.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 完成用户注册和登录等功能
 */
public class UserClientService {

//  因为可能在其他地方使用
    private final User u = new User();
    private Socket socket;

//    根据 userId 和 pwd 验证是否合法
    public boolean checkUser(String userId, String pwd) {
        boolean b = false;
        // 创建 User
        u.setUserId(userId);
        u.setPassword(pwd);

//        连接到服务器，发送 User 对象
        try {
            socket = new Socket("127.0.0.1", 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);  // 发送 User 对象

//            读取返回的 Message 对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            if(ms.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){

//                准备创建一个和服务器端保持通信的线程 -> 创建一个类
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();

                ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
                b = true;
            }else{
//                登录失败，不启动线程，关闭 socket
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }
}
