package com.test.qqclient.service;

import com.test.qqcommon.Message;
import com.test.qqcommon.MessageType;
import com.test.qqcommon.User;

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

//    向服务器请求在线用户列表
    public void olineFriendList(){

//        发送一个 message
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
//        发送
//        获取 线程对应的 socket
        socket = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    退出客户端，并且向服务端发送退出系统的 message
    public void logout(){
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_CLIENT_EX);
        message.setSender(u.getUserId());  // 指定是谁要退出

        socket = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId()+"退出系统");

                socket.close();

            System.exit(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    发送私聊消息
    public void sendPrivateMessage(String userId,String msg){
//        创建消息
        Message message = new Message();
        message.setSender(u.getUserId());  // 发送者
        message.setGetter(userId);   // 接受者
        message.setContent(msg);
        message.setMsgType(MessageType.MESSAGE_COMM_MES);

        socket = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println("你 对 "+userId + "说: "+msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
