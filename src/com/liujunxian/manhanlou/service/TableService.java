package com.liujunxian.manhanlou.service;

import com.liujunxian.manhanlou.dao.TableDAO;
import com.liujunxian.manhanlou.domain.Table;

import java.util.List;

/**
 * 完成对table表的各种操作
 */
public class TableService {
    private static final TableDAO tableDAO = new TableDAO();
    
    /**
     * 查询所有餐桌的信息
     *
     * @return 以List实例返回餐桌的id和state
     */
    public static List<Table> list() {
        String sql = "select id, state from `table`";
        return tableDAO.queryMulti(sql, Table.class);
    }
    
    /**
     * 根据ID获取Table对象
     *
     * @param ID 餐桌编号
     * @return ID对应的餐桌
     */
    public static Table getTable(int ID) {
        String sql = "select state from `table` where id = ?";
        return tableDAO.querySingle(sql, Table.class, ID);
    }
    
    /**
     * 预定餐桌
     * @param ID 餐桌编号
     * @param name 预定人姓名
     * @param phone 预定人电话
     * @return 是否预定成功
     */
    public static boolean bookTable(int ID, String name, String phone) {
        String sql = "update `table` set state = '预定', order_name = ?, order_phone = ? where id = ?";
        return tableDAO.update(sql, name, phone, ID) > 0;
    }
}
