package com.neta.qqcommon;

import java.io.Serializable;

/**
 * 消息对象
 */
public class Message implements Serializable {
    private static final long serialVersionID = 1L;
    private String sender; // 发送方
    private String getter; // 接收者
    private String content; // 消息内容
    private String sendTime; // 发送时间
    private String msgType;  // 消息类型

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}