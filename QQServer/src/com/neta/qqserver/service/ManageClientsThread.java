package com.neta.qqserver.service;

import java.util.HashMap;

/**
 * 管理和客户端通信的线程
 */
public class ManageClientsThread {
    private static final HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

//    添加线程对象到 hm
    public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }
//   获取线程
    public static ServerConnectClientThread getClientThread(String userId){
        return hm.get(userId);
    }
}
