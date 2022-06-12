package com.neta.dao_.dao;

import com.neta.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 其他 DAO 的父类
 */
public class BasicDAO<T> {

   private final QueryRunner qr= new  QueryRunner();

   // 通用 dml 方法
   public int update(String sql,Object... parameters){
       Connection connection = null;

       try{
           connection = JDBCUtilsByDruid.getConnection();
           return qr.update(connection, sql, parameters);
       }catch (SQLException e){
           throw new RuntimeException(e);
       }finally {
           JDBCUtilsByDruid.close(null,null,connection);
       }
   }

    // 返回多个对象
    public List<T> queryMulti(String sql,Class<T> clazz,Object... parameters){
       Connection connection = null;

       try{
           connection = JDBCUtilsByDruid.getConnection();

           return qr.query(connection, sql, new BeanListHandler<>(clazz), parameters);
       }catch (SQLException e){
           throw new RuntimeException(e);
       }finally {
           JDBCUtilsByDruid.close(null,null,connection);
       }
    }

    // 查询单行
    public T querySingle(String sql,Class<T> clazz,Object... parameters){
       Connection connection = null;

       try{
           connection = JDBCUtilsByDruid.getConnection();
           return qr.query(connection,sql,new BeanHandler<>(clazz),parameters);
        }catch (SQLException e){
           throw new RuntimeException(e);
       }finally {
           JDBCUtilsByDruid.close(null,null,connection);
       }
    }

    // 返回单值
    public Object queryScalar(String sql,Object... parameters){
       Connection connection = null;

       try{
           connection = JDBCUtilsByDruid.getConnection();
           return qr.query(connection,sql,new ScalarHandler<>(),parameters);
       }catch (SQLException e){
           throw new RuntimeException(e);
       }finally {
           JDBCUtilsByDruid.close(null,null,connection);
       }


    }

}
