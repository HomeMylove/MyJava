package com.test.service;

import java.util.HashMap;
import java.util.Set;

/**
 * 管理和客户端通信的线程
 */
public class ManageClientsThread {
    private static final HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

//    添加线程对象到 hm
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread){
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

}
