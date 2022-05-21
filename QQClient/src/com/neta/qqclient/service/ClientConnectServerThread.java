package com.neta.qqclient.service;

import com.neta.qqcommon.Message;
import com.neta.qqcommon.MessageType;

import java.io.*;
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
                Message message = (Message) ois.readObject();  // 如果没有发送,readObject 会阻塞

//                判断 message 类型
//                ret_friend 类型
                if(message.getMsgType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)){
//                    取出信息
                    String[] onlineFriends = message.getContent().split(" ");
                    System.out.println("\n========在线用户列表========");
                    for(int i = 0; i < onlineFriends.length; i++){
                        System.out.println("用户: "+onlineFriends[i]);
                    }
                }else if(message.getMsgType().equals(MessageType.MESSAGE_COMM_MES)){
//                    普通的聊天消息
                    System.out.println("\n" + message.getSender()+" 对你说:"+message.getContent());
                }else if(message.getMsgType().equals(MessageType.MESSAGE_FILE_MES)){
//                    文件消息
                    System.out.println("\n"+message.getSender() + " 给你发送了" + message.getSrc());
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(message.getDest()));
                    bos.write(message.getFileBytes());
                    bos.close();

                }

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
