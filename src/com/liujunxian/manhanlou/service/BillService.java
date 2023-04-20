package com.liujunxian.manhanlou.service;

import com.liujunxian.manhanlou.dao.BillDAO;
import com.liujunxian.manhanlou.dao.TableDAO;
import com.liujunxian.manhanlou.domain.Menu;

public class BillService {
    private static final BillDAO billDAO = new BillDAO();
    private static final TableDAO tableDAO = new TableDAO();
    
    /**
     * 订餐
     * @param tableID 餐桌ID
     * @param menuID 菜品ID
     * @param num 菜品数量
     */
    public static void order(int tableID, int menuID, int num) {
        String sql = "insert into `bill` values(null, ?, ?, ?, ?, now(), '未支付')";
        Menu menu = MenuService.getMenu(menuID);
        billDAO.update(sql, menuID, num, menu.getPrice() * num, tableID);
        tableDAO.update("update `table` set state = '用餐中' where id = ?", tableID);
    }
    
    /**
     * 订餐
     * @param tableID 餐桌ID
     * @param menuName 菜品名
     * @param num 菜品数量
     */
    public static void order(int tableID, String menuName, int num) {
        String sql = "insert into `bill` values(null, ?, ?, ?, ?, now(), '未支付')";
        Menu menu = MenuService.getMenu(menuName);
        billDAO.update(sql, menu.getID(), num, menu.getPrice() * num, tableID);
        tableDAO.update("update `table` set state = '用餐中' where id = ?", tableID);
    }
}
