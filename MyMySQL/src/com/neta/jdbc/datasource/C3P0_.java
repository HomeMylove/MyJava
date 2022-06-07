package com.neta.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * C3P0 的使用
 */
public class C3P0_ {
    public static void main(String[] args) throws PropertyVetoException, SQLException, IOException {
//        testC3P0_01();
        testC3P0_02();
    }

    public static void testC3P0_01() throws IOException, PropertyVetoException, SQLException {


        // 创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        // 通过配置文件获取连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("E:\\sql.properties"));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

//        给数据源设置相关的参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

//        初始化数据源的连接数
        comboPooledDataSource.setInitialPoolSize(10);
//        最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
//        获取连接
        int i = 0;
        long start = System.currentTimeMillis();
        while (i++ < 500) {
            Connection connection = comboPooledDataSource.getConnection();

            connection.close();
        }
        long end = System.currentTimeMillis();

        System.out.println("用时" + (end - start));
    }

    public static void testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("neta");
        Connection connection = comboPooledDataSource.getConnection();

        connection.close();
    }

}
