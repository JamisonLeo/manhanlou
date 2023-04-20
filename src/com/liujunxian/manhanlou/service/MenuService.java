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
}
