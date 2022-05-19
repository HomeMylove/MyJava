package com.test.qqcommon;

/**
 * 消息类型
 */
public interface MessageType {
    // 定义一些常量，不同的值表示不同的消息类型
    String MESSAGE_LOGIN_SUCCEED = "1";  // 登录成功
    String MESSAGE_LOGIN_FAILED = "2";   // 登录失败
    String MESSAGE_COMM_MES = "3"; // 普通信息包
    String MESSAGE_GET_ONLINE_FRIEND = "4";// 要求返回在线列表
    String MESSAGE_RET_ONLINE_FRIEND = "5"; // 返回在线列表
    String MESSAGE_CLIENT_EX = "6";  // 客户端请求退出
    String MESSAGE_WARNING = "7"; // 警告
}
