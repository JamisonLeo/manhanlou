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
}
