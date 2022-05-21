package com.neta.qqclient.service;

import com.neta.qqcommon.Message;
import com.neta.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

//提供和消息相关的方法
public class MessageClientService {

    public void sendMessageToOne(String content,String senderId,String getterId){
        Message message = new Message();
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setMsgType(MessageType.MESSAGE_COMM_MES);
        message.setSendTime(new Date().toString());
        System.out.println("你 对 "+getterId+" 说: "+content);
//        发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void sendMessageToAll(String content,String sendId){
        Message message = new Message();
        message.setSender(sendId);
        message.setMsgType(MessageType.MESSAGE_TOALL_MES);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(sendId + " 对大家说:" + content);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sendId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
