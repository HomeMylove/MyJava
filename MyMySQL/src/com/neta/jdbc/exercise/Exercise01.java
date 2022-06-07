package com.neta.jdbc.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Exercise01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Properties info = new Properties();
        info.load(new FileInputStream("E:\\sql.properties"));

        Class.forName(info.getProperty("driver"));
        String url = info.getProperty("url");
        String user = info.getProperty("user");
        String password = info.getProperty("password");

        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

//        String sql = "INSERT INTO news VALUES (null,'Hello world'),(null,'hi'),(null,'yae'),(null,'Ei'),(null,'Kokomi')";
//        String sql = "UPDATE news SET content='Klee' WHERE id=1";
        String sql = "DELETE FROM news WHERE id=3";

        int rows = statement.executeUpdate(sql);
        System.out.printf("rows%d", rows);

        connection.close();

    }
}
