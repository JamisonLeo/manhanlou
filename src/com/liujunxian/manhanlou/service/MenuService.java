package com.liujunxian.manhanlou.service;

import com.liujunxian.manhanlou.dao.MenuDAO;
import com.liujunxian.manhanlou.domain.Menu;

import java.util.List;

/**
 * 完成对menu表的各种操作
 */
public class MenuService {
    private static final MenuDAO menuDAO = new MenuDAO();
    
    /**
     * @return 所有菜品信息
     */
    public static List<Menu> list() {
        String sql ="select * from `menu`";
        return menuDAO.queryMulti(sql, Menu.class);
    }
    
    /**
     * 根据ID获取对应的菜品信息
     * @param ID 菜品ID
     * @return Menu对象
     */
    public static Menu getMenu(int ID) {
        String sql = "select * from menu where id = ?";
        return menuDAO.querySingle(sql, Menu.class, ID);
    }
    
    /**
     * 根据菜名获取对应的菜品信息
     * @param name 菜品名
     * @return Menu对象
     */
    public static Menu getMenu(String name) {
        String sql = "select * from menu where name = ?";
        return menuDAO.querySingle(sql, Menu.class, name);
    }
}
