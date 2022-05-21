package com.neta.qqserver.service;


import com.neta.qqcommon.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理和客户端通信的线程
 */
public class ManageClientsThread {
    private static final HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    private static final ConcurrentHashMap<String, Message> chm = new ConcurrentHashMap<>();

    public static void addOfflineMessage(String getterId,Message message){
        chm.put(getterId,message);
    }

    public static Message getOfflineMessage(String getterId){
        return chm.get(getterId);
    }



//    添加线程对象到 hm
    public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }
//   获取线程
    public static ServerConnectClientThread getClientThread(String userId){
        return hm.get(userId);
    }
//    返回在线用户列表
    public static String getOnlineUser(){
        StringBuilder sb = new StringBuilder();
        Set<String> keys = hm.keySet();
        for (String userId : keys) {
            sb.append(userId).append(" ");
        }
        return sb.toString();
    }

//    从集合中移除线程
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }

    public static Set<Map.Entry<String, ServerConnectClientThread>> getOtherOnlineSocket(){
        return hm.entrySet();
    }


}
