package com.liujunxian.manhanlou.dao;

import com.liujunxian.manhanlou.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 其他DAO的父类
 */
public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();
    
    /**
     * 对数据表进行增、删、改
     *
     * @param sql   要执行的sql语句
     * @param param 传入要执行的sql语句中的参数
     * @return 受影响的行数
     */
    public int update(String sql, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.update(connection, sql, param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    /**
     * 查询多列数据
     *
     * @param sql   要执行的sql语句
     * @param clazz 要生成的ArrayList对象中的类型
     * @param param 传入要执行的sql语句中的参数
     * @return 查询到的数据生成的ArrayList对象
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<>(clazz), param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    /**
     * 查询单行数据
     *
     * @param sql   要执行的sql数据
     * @param clazz 要返回的数据类型
     * @param param 传入要执行的sql语句中的参数
     * @return 查询到的单行数据对应的domain对象
     */
    public T querySingle(String sql, Class<T> clazz, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<>(clazz), param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    /**
     * 查询单行单列数据
     *
     * @param sql   要执行的sql语句
     * @param param 传入要执行的sql语句中的参数
     * @return 查询到的值
     */
    public Object queryScalar(String sql, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler<>(), param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
