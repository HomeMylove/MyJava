package com.neta.qqclient.service;

import com.neta.qqcommon.MessageType;
import com.neta.qqcommon.Message;

import java.io.*;
import java.net.Socket;


public class FileClientService {


    /**
     *
     * @param src 源文件
     * @param dest 目标
     * @param senderId 发送人
     * @param getter 接收人
     */
    public void sendFileToOne(String src,String dest,String senderId,String getter){
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream bos = null;

        try {
             fileInputStream = new FileInputStream(src);
            int len = 0;
            byte[] buf = new byte[1024];
             bos = new ByteArrayOutputStream();
            while ((len = fileInputStream.read(buf)) != -1){
                bos.write(buf,0,len);
            }
            byte[] bytes = bos.toByteArray();
            Message message = new Message();
            message.setSender(senderId);
            message.setGetter(getter);
            message.setMsgType(MessageType.MESSAGE_FILE_MES);
            message.setSrc(src);
            message.setDest(dest);
            message.setFileBytes(bytes);
            message.setFileLen(bytes.length);

            System.out.println("你向 "+getter +"发送了"+src);
            Socket socket = ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);


        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
