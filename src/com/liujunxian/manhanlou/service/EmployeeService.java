package com.liujunxian.manhanlou.service;

import com.liujunxian.manhanlou.dao.EmployeeDAO;
import com.liujunxian.manhanlou.domain.Employee;

/**
 * 完成对Employee表的各种操作
 */
public class EmployeeService {
    private static final EmployeeDAO employeeDAO = new EmployeeDAO();
    /**
     * 根据提供的形参生成Employee对象
     * @param ID 员工号
     * @param password 员工密码
     * @return Employee对象
     */
    public static Employee getEmployee(String ID, String password) {
        String sql = "select * from `employee` where empID = ? and password = md5(?)";
        return employeeDAO.querySingle(sql, Employee.class, ID, password);
    }
}
