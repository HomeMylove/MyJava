package com.neta.jdbc.transaction_;

import com.neta.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction_ {
    public static void main(String[] args) {
        Connection connection = null;

        String sql1 = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
//            不自动提交
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();


            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            在这里回滚
//            默认回到事务的开始
            try {
                System.out.println("异常!回滚");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
