package com.liujunxian.manhanlou.service;

import com.liujunxian.manhanlou.dao.TableDAO;
import com.liujunxian.manhanlou.domain.Table;

import java.util.List;

/**
 * 完成对table表的各种操作
 */
public class TableService {
    static TableDAO table = new TableDAO();
    
    /**
     * 查询所有餐桌的信息
     * @return 以List实例返回餐桌的id和state
     */
    public static List<Table> list() {
        String sql = "select id, state from `table`";
        return table.queryMulti(sql, Table.class);
    }
    
    /**
     * 检查餐桌是否为空闲状态
     * @param ID 餐桌编号
     * @return 是否为空闲状态
     */
    public static boolean isEmpty(int ID) {
        String sql = "select state from `table` where id = ?";
        return table.queryScalar(sql, ID).equals("空");
    }
    
    /**
     * 预定餐桌
     * @return 是否预定成功
     */
    public static boolean book(int ID, String name, String phone) {
        String sql = "update `table` set state = '预定', order_name = ?, order_phone = ? where id = ?";
        return table.update(sql, name, phone, ID) > 0;
    }
}
