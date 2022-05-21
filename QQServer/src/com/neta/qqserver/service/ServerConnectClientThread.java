package com.neta.qqserver.service;

import com.neta.qqcommon.Message;
import com.neta.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

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
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
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
                    oos.writeObject(message1);
                }else if(message.getMsgType().equals(MessageType.MESSAGE_COMM_MES)){
//                    根据message获取getter
                    ServerConnectClientThread clientThread = ManageClientsThread.getClientThread(message.getGetter());
                    if(clientThread == null){
                        ManageClientsThread.addOfflineMessage(message.getGetter(),message);
                    }else{
                        oos = new ObjectOutputStream(clientThread.getSocket().getOutputStream());
                        oos.writeObject(message); // 如果不在线可以保存到数据库,实现离线留言
                    }
                }else if(message.getMsgType().equals(MessageType.MESSAGE_TOALL_MES)){
//                    转发群发消息
                    message.setMsgType(MessageType.MESSAGE_COMM_MES);
                    Set<Map.Entry<String, ServerConnectClientThread>> otherOnlineSocket = ManageClientsThread.getOtherOnlineSocket();
                    for (Map.Entry<String, ServerConnectClientThread> onlineSocket : otherOnlineSocket) {
                        if(!onlineSocket.getKey().equals(message.getSender())){
                            oos = new ObjectOutputStream(onlineSocket.getValue().getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                }else if(message.getMsgType().equals(MessageType.MESSAGE_FILE_MES)){
//                    转发文件
                    Socket socket = ManageClientsThread.getClientThread(message.getGetter()).getSocket();
                     oos = new ObjectOutputStream(socket.getOutputStream());
                     oos.writeObject(message);
                }

                else if(message.getMsgType().equals(MessageType.MESSAGE_CLIENT_EX)){
//                    关闭连接
                    System.out.println(message.getSender()+"退出");
                    sleep(1);
                    ManageClientsThread.removeServerConnectClientThread(message.getSender());
                    socket.close();
//                    退出线程
                    break;
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}
