package com.neta.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)cls.newInstance();

        String url = "jdbc:mysql://localhost:3306/exercise";

        String user = "root";
        String password = "password";

        DriverManager.deregisterDriver(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }
}
