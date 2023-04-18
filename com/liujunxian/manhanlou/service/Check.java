package com.liujunxian.manhanlou.service;

import com.liujunxian.manhanlou.dao.EmployeeDAO;
import com.liujunxian.manhanlou.domain.Employee;
import com.liujunxian.manhanlou.utils.MD5Utils;

import java.util.Objects;

/**
 * 用于验证账户信息
 */
public class Check {
    /**
     * 验证用户名及密码是否正确
     * @param ID 员工号
     * @param password 员工密码
     * @return 是否验证成功
     */
    public static boolean CheckAccount(String ID, String password) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        String sql = "select * from employee where emp_id = ?";
        Employee employee = employeeDAO.querySingle(sql, Employee.class, ID);
        if (employee != null) {
            return Objects.equals(MD5Utils.MD5(password), employee.getPassword());
        }
        return false;
    }
}
