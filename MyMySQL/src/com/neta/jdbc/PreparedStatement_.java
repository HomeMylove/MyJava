package com.neta.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class PreparedStatement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties info = new Properties();
        info.load(new FileInputStream("E:\\sql.properties"));

        Class.forName(info.getProperty("driver"));
        String url = info.getProperty("url");
        String user = info.getProperty("user");
        String password = info.getProperty("password");

        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "SELECT uer, password FROM admin WHERE uer=? and password=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,"root");
        preparedStatement.setString(2,"abc");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            String uer = resultSet.getString(1);
            String pwd = resultSet.getString(2);
            System.out.printf("user=%s\npwd=%s",user,pwd);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
