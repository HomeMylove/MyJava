package com.neta.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Druid_ {
    public static void main(String[] args) throws Exception {
        // 1.加入 jar 包
        // 2.加入配置文件 druid.properties（名字随意）
        // 3.创建 Properties 对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

//        创建一个指定参数的连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        System.out.println("连接成功");
        connection.close();
    }
}
