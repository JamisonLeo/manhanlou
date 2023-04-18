package com.liujunxian.manhanlou.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsByDruid {
    private static DataSource ds;
    
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取与数据库连接的Connection对象
     *
     * @return java.sql.Connection
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    /**
     * 将Connection对象放回连接池
     * @param resultSet 执行查询语句的结果集
     * @param statement 执行sql语句的对象
     * @param connection 与数据库连接的Connection对象
     */
    public static void close(ResultSet resultSet, Statement statement , Connection connection) throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }
    
    /**
     * 将Connection对象放回连接池
     * @param statement 执行sql语句的对象
     * @param connection 与数据库连接的Connection对象
     */
    public static void close(Statement statement , Connection connection) throws SQLException {
        statement.close();
        connection.close();
    }
}