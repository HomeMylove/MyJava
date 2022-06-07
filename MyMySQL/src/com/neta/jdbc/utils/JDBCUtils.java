package com.neta.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 这是一个工具类
 */
public class JDBCUtils {
    // 定义相关的属性
    // 只需要一份，做成静态属性
    private static final String user;
    private static final String password;
    private static final String url;
    private static final String driver;

    // 初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("E:\\sql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            // 1.将编译异常转成运行异常
            // 2.调用者可以选择捕获，也可以默认处理
            throw new RuntimeException(e);
        }
    }

    // 返回 Connection 对象
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 关闭资源
    public static void close(ResultSet set, Statement statement,Connection connection){
        // 判断是否为空
        try {
            if(set != null)
                set.close();
            if(statement != null)
                statement.close();
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
