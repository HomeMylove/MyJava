package com.test.service;

import com.test.qqcommon.Message;
import com.test.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread{
    private final Socket socket;
    private final String userId;// 连接到客户端的 userId

    public Socket getSocket() {
        return socket;
    }

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
                ObjectOutputStream oos = null;
                Message message = (Message) ois.readObject();
//                根据 message 的类型做相应的业务处理
                if(message.getMsgType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    System.out.println(message.getSender() + "要获取在线列表");
                    String onlineUser = ManageClientsThread.getOnlineUser();
//                    返回 message
                    Message message1 = new Message();
                    message1.setMsgType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(onlineUser);
                    message1.setGetter(message.getSender());
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                }else if(message.getMsgType().equals(MessageType.MESSAGE_CLIENT_EX)){
//                    关闭连接
                    System.out.println(message.getSender()+"退出");
                    sleep(1);
                    ManageClientsThread.removeServerConnectClientThread(message.getSender());
                    socket.close();
//                    退出线程
                    break;
                }else if(message.getMsgType().equals(MessageType.MESSAGE_COMM_MES)){
//                    普通消息
//                    获取线程
                    ServerConnectClientThread clientThread = ManageClientsThread.getClientThread(message.getGetter());
                    if(clientThread == null){
                        oos = new ObjectOutputStream(socket.getOutputStream());
                        Message message1 = new Message();
                        message1.setMsgType(MessageType.MESSAGE_WARNING);
                        message1.setContent("用户未上线");
                        oos.writeObject(message1);
                    }else {
                        //                    获取 socket
                        Socket getterSocket = clientThread.getSocket();
//                    转发
                        oos = new ObjectOutputStream(getterSocket.getOutputStream());
                        oos.writeObject(message);
                    }

                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}
