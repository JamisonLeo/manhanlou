package com.liujunxian.manhanlou.view;

import com.liujunxian.manhanlou.domain.Employee;
import com.liujunxian.manhanlou.domain.Table;
import com.liujunxian.manhanlou.service.EmployeeService;
import com.liujunxian.manhanlou.service.TableService;
import com.liujunxian.manhanlou.utils.Utility;

import java.util.List;

public class AppView {
    /**
     * 控制是否退出菜单
     */
    private boolean loop = true;
    /**
     * 接收用户输入
     */
    private String key;
    
    public static void main(String[] args) {
        new AppView().mainMenu();
    }
    
    /**
     * 显示主菜单
     */
    public void mainMenu() {
        while (loop) {
            System.out.println("===============满汉楼===============");
            System.out.println("\t\t1. 登录满汉楼");
            System.out.println("\t\t2. 退出满汉楼");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入工号：");
                    String ID = Utility.readString(12);
                    System.out.print("请输入密码：");
                    String password = Utility.readString(18);
                    Employee employee = EmployeeService.getEmployee(ID, password);
                    if (employee != null) {
                        System.out.println("===============登录成功" + employee.getName() + "===============\n");
                        EnterContinue();
                        while (loop) {
                            System.out.println("===============满汉楼===============");
                            System.out.println("\t\t1. 显示餐桌状态");
                            System.out.println("\t\t2. 预定餐桌");
                            System.out.println("\t\t3. 显示所有菜品");
                            System.out.println("\t\t4. 点餐服务");
                            System.out.println("\t\t5. 查看账单");
                            System.out.println("\t\t6. 结账");
                            System.out.println("\t\t9. 退出满汉楼");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    List<Table> list = TableService.list();
                                    System.out.println("==============================");
                                    System.out.println("\t餐桌号\t\t\t状态");
                                    for (Table table : list) {
                                        System.out.println(table);
                                    }
                                    System.out.println("==============================");
                                    EnterContinue();
                                    break;
                                case "2":
                                    EnterContinue();
                                    break;
                                case "3":
                                    EnterContinue();
                                    break;
                                case "4":
                                    EnterContinue();
                                    break;
                                case "5":
                                    EnterContinue();
                                    break;
                                case "6":
                                    EnterContinue();
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("输入有误，请重新输入！");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("===============工号或密码错误，请重试！===============");
                        EnterContinue();
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
        System.out.println("退出满汉楼系统~");
    }
    
    private static void EnterContinue() {
        System.out.print("按下 Enter 继续~");
        Utility.readString(20, "继续");
    }
}
