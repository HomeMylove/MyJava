package com.neta.qqserver.service;

import com.neta.qqcommon.Message;
import com.neta.qqcommon.MessageType;
import com.neta.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 这是服务器，监听端口，保持通信
 */
public class QQServer {
    private ServerSocket serverSocket = null;

    //    用户列表
    private static final HashMap<String, User> validUsers = new HashMap<>();

    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("珊瑚宫心海", new User("珊瑚宫心海", "520"));
    }

    private boolean checkUser(String userId, String password) {
        User user = validUsers.get(userId);

        if (user == null) {// 不存在的用户
            System.out.println("不存在的用户");
            return false;
        } else if(!user.getPassword().equals(password)){
            System.out.println("错误的密码");
            return false;
        }else{
            return true;
        }
    }


    public QQServer() {
        System.out.println("服务器在9999端口监听....");
        try {
            serverSocket = new ServerSocket(9999);

            while (true) {
//                监听是循环的，当和某个客户端建立连接后会继续监听
                Socket socket = serverSocket.accept();
//                对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//                对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                User user = (User) ois.readObject(); // 读取客户端发送的 User 对象
                Message message = new Message();
//                验证用户
                if (checkUser(user.getUserId(), user.getPassword())) {
//                    合法用户
                    message.setMsgType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
//                    创建一个线程和客户端保持通信
                    //                    尝试获取离线消息

                    ArrayList<Message> offlineMessage = ManageClientsThread.getOfflineMessage(user.getUserId());
                    if(offlineMessage != null){
                        for(int i = 0; i < offlineMessage.size(); i++){
                            message = offlineMessage.get(i);
                            ObjectOutputStream oos1 = new ObjectOutputStream(socket.getOutputStream());
                            oos1.writeObject(message);
                        }
                    }
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUserId());
                    serverConnectClientThread.start();



                    ManageClientsThread.addClientThread(user.getUserId(), serverConnectClientThread);
                } else {
//                    登录失败
                    message.setMsgType(MessageType.MESSAGE_LOGIN_FAILED);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
