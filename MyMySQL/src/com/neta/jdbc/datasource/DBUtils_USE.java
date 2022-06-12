package com.neta.jdbc.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_USE {
    public static void main(String[] args) throws SQLException {
        testQueryMany();
//        testQuerySingle();
//        testDML();
    }


    public static void testQueryMany() throws SQLException {

        Connection connection = JDBCUtilsByDruid.getConnection();
        // 使用 dbutils 类
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT id,content FROM news";

        // 执行 query 方法，返回结果集
        // 通过反射看有哪些属性
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class));

        for (Actor actor : list) {
            System.out.println(actor);
        }

        JDBCUtilsByDruid.close(null,null,connection);


    }


    public static void testQuerySingle() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 使用 dbutils 类
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT content FROM news WHERE id = ?";

        // 执行 query 方法，返回结果集
        // 通过反射看有哪些属性
//        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
//        System.out.println(actor);
        Object obj = queryRunner.query(connection, sql, new ScalarHandler<>(), 1);

        System.out.println(obj);


        JDBCUtilsByDruid.close(null,null,connection);

    }

    public static void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "UPDATE news SET content = ? WHERE id = ?";

        // rows 受影响的行数
        int rows = queryRunner.update(connection, sql, "Keqing", 2);

        sql = "INSERT INTO news VALUES(null,?)";
        rows = queryRunner.update(connection, sql, "Ayaka");


    }



}
