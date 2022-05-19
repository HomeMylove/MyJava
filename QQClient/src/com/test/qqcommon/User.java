package com.test.qqcommon;

import java.io.Serializable;

/**
 * 表示一个客户信息
 */
public class User implements Serializable {
    private static final long serialVersionID = 1L;
    private String userId;
    private String password;

    public User(){}

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
