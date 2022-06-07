package com.neta.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ResultSet01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties info = new Properties();
        info.load(new FileInputStream("E:\\sql.properties"));

        Class.forName(info.getProperty("driver"));
        String url = info.getProperty("url");
        String user = info.getProperty("user");
        String password = info.getProperty("password");

        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM actor";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt(1);// 获取第一列
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            String phone = resultSet.getString(5);

            System.out.printf("id=%d\nname=%s\nsex=%s\ndate=%s\nphone=%s",id,name,sex,date.toString(),phone);
        }

        resultSet.close();
        statement.close();
        connection.close();


    }
}
