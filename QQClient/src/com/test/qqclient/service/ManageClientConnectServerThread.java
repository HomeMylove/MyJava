package com.test.qqclient.service;

import java.util.HashMap;

/**
 * 管理客户端连接到服务器端的线程
 */
public class ManageClientConnectServerThread {
//    把多个线程放入 hm
//    key 用户 id
//    value 线程
    private static final HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

//    将一个线程加入到集合中
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread){
        hm.put(userId,clientConnectServerThread);
    }

//    通过 userId 得到对应的线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }
}
