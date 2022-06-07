package com.neta.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        // 1.注册驱动
//        Driver driver = new Driver();
        Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)cls.newInstance();


        // 2.得到连接
        // (1) jdbc:mysql 协议
        // (2) localhost 主机 (也可以是 ip)
        // (3) 3306 端口
        // (4) exercise 数据库
        // (5) 本质是 socket
        String url = "jdbc:mysql://localhost:3306/exercise";

        // 将用户名和密码封装
        // user 和 password 是规定好的
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","password");

        Connection connect = driver.connect(url, properties);

        // 3.执行 mysql
        String sql = "INSERT INTO actor VALUES (NULL,'Yae','女','2000-10-22','138')";

        // 得到 statement 对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        // 如果是 dml 函数， rows 表示影响的行数

        System.out.println(rows > 0 ? "成功":"失败");
        connect.close();
    }
}
