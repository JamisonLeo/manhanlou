package com.liujunxian.manhanlou.service;

import com.liujunxian.manhanlou.dao.TableDAO;
import com.liujunxian.manhanlou.domain.Table;
import com.liujunxian.manhanlou.utils.Utility;

import java.util.List;

/**
 * 完成对table表的各种操作
 */
public class TableService {
    static TableDAO tableDAO = new TableDAO();
    
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
     */
    public static void bookTable() {
        System.out.println("==========预定餐桌==========");
        while (true) {
            System.out.print("请选择要预定的餐桌编号(-1退出)：");
            int key = Utility.readInt();
            if (key == -1) {
                System.out.print("取消预定\t\t");
                break;
            }
            Table table = getTable(key);
            if (table == null) {
                System.out.println("餐桌不存在！");
            } else if (!"空".equals(table.getState())) {
                System.out.println("该餐桌不是空闲餐桌！");
            } else {
                System.out.print("预定人姓名：");
                String name = Utility.readString(20);
                System.out.print("预定人电话：");
                String phone = Utility.readString(12);
                System.out.print("确认是否预定(Y:确定 | 其他任意键取消)：");
                char c = Utility.readChar();
                if ('y' == c || 'Y' == c) {
                    String sql = "update `table` set state = '预定', order_name = ?, order_phone = ? where id = ?";
                    System.out.println(tableDAO.update(sql, name, phone, key) > 0 ? "\n---预定成功" : "\n---预定失败");
                    break;
                }
                System.out.print("取消预定\t\t");
                break;
            }
        }
    }
}
