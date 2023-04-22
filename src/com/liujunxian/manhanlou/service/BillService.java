package com.liujunxian.manhanlou.service;

import com.liujunxian.manhanlou.dao.BillDAO;
import com.liujunxian.manhanlou.domain.Bill;
import com.liujunxian.manhanlou.domain.Menu;
import com.liujunxian.manhanlou.domain.Table;

import java.util.List;
import java.util.UUID;

public class BillService {
    private static final BillDAO billDAO = new BillDAO();
    
    /**
     * 订餐
     *
     * @param tableID 餐桌ID
     * @param menuID  菜品ID
     * @param num     菜品数量
     */
    public static void order(Table table, int tableID, int menuID, int num) {
        String billID = UUID.randomUUID().toString();
        String sql = "insert into `bill` values(?, ?, ?, ?, ?, now(), '未支付')";
        Menu menu = MenuService.getMenu(menuID);
        billDAO.update(sql, billID, menuID, num, menu.getPrice() * num, tableID);
        TableService.updateTableState(table, tableID, "用餐中");
    }
    
    /**
     * 订餐
     *
     * @param tableID  餐桌ID
     * @param menuName 菜品名
     * @param num      菜品数量
     */
    public static void order(Table table, int tableID, String menuName, int num) {
        String billID = UUID.randomUUID().toString();
        String sql = "insert into `bill` values(?, ?, ?, ?, ?, now(), '未支付')";
        Menu menu = MenuService.getMenu(menuName);
        billDAO.update(sql, billID, menu.getID(), num, menu.getPrice() * num, tableID);
        TableService.updateTableState(table, tableID, "用餐中");
    }
    
    /**
     * 查询所有账单
     *
     * @return 以List实例返回所有账单信息
     */
    public static List<Bill> list() {
        String sql = "select * from `bill`";
        return billDAO.queryMulti(sql, Bill.class);
    }
}
