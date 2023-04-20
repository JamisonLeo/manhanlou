package com.liujunxian.manhanlou.view;

import com.liujunxian.manhanlou.domain.Employee;
import com.liujunxian.manhanlou.domain.Menu;
import com.liujunxian.manhanlou.domain.Table;
import com.liujunxian.manhanlou.service.BillService;
import com.liujunxian.manhanlou.service.EmployeeService;
import com.liujunxian.manhanlou.service.MenuService;
import com.liujunxian.manhanlou.service.TableService;
import com.liujunxian.manhanlou.utils.Utility;

import java.util.List;

public class AppView {
    /**
     * 控制是否退出菜单
     */
    private boolean loop = true;
    
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
            String key = Utility.readString(1);
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
                                    tableList();
                                    EnterContinue();
                                    break;
                                case "2":
                                    bookTable();
                                    EnterContinue();
                                    break;
                                case "3":
                                    menuList();
                                    EnterContinue();
                                    break;
                                case "4":
                                    order();
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
    
    /**
     * 提示“按下 Enter 继续”并监听用户输入
     */
    private static void EnterContinue() {
        System.out.print("按下 Enter 继续~");
        Utility.readString(20, "继续");
    }
    
    /**
     * 显示餐桌状态
     */
    private static void tableList() {
        List<Table> list = TableService.list();
        System.out.println("==============================");
        System.out.println("\t餐桌号\t\t\t状态");
        System.out.println("\t--------------------");
        for (Table table : list) {
            System.out.println(table);
        }
        System.out.println("==============================");
    }
    
    private static void menuList() {
        List<Menu> list = MenuService.list();
        System.out.println("============================================================");
        System.out.println("\t\t菜品编号\t\t菜品名\t\t类别\t\t价格");
        System.out.println("\t\t------------------------------------------");
        for (Menu menu : list) {
            System.out.println(menu);
        }
        System.out.println("============================================================");
    }
    
    /**
     * 预定餐桌界面
     */
    private static void bookTable() {
        System.out.println("==========预定餐桌==========");
        while (true) {
            System.out.print("请选择要预定的餐桌编号(-1退出)：");
            int tableID = Utility.readInt();
            if (tableID == -1) {
                System.out.println("取消预定\t\t");
                break;
            }
            Table table = TableService.getTable(tableID);
            if (table == null)
                System.out.println("该餐桌不存在！");
            else if (!("空".equals(table.getState())))
                System.out.println("该餐桌不是空闲餐桌！");
            else {
                System.out.print("预定人姓名：");
                String name = Utility.readString(20);
                System.out.print("预定人电话：");
                String phone = Utility.readString(12);
                System.out.print("确认是否预定(Y:确定 | 其他任意键取消)：");
                char c = Utility.readChar();
                if ('y' == c || 'Y' == c) {
                    System.out.print(TableService.bookTable(tableID, name, phone) ? "\n---预定成功\t\t" : "\n---预定失败\t\t");
                    break;
                }
                System.out.print("取消预定\t\t");
                break;
            }
        }
    }
    
    /**
     * 点餐界面
     */
    private static void order() {
        System.out.println("==========点餐服务==========");
        while (true) {
            System.out.print("选择点餐的桌号(-1退出)：");
            int tableID = Utility.readInt();
            if (tableID == -1) break;
            Table table = TableService.getTable(tableID);
            if (!("空".equals(table.getState()))) {
                if ("预定".equals(table.getState())) {
                    System.out.print("请输入预定人手机号码：");
                    String orderPhone = Utility.readString(12);
                    if (!(orderPhone.equals(table.getOrderPhone()))) {
                        System.out.println("预定人信息不正确，无法在此餐桌就餐！");
                        break;
                    }
                }
            }
            System.out.print("请选择菜品编号或菜品名(-1退出)：");
            String s = Utility.readString(20);
            Object good;
            try {
                good = Integer.parseInt(s);
                if ((int) good == -1) break;
            } catch (NumberFormatException e) {
                good = s;
            }
            System.out.print("请输入点菜数量(-1退出)：");
            int goodNum = Utility.readInt();
            if (goodNum == -1) break;
            System.out.print("确认是否点菜(Y:确定 | 其他任意键取消)：");
            char c = Utility.readChar();
            if ('y' == c || 'Y' == c) {
                if (good instanceof Integer)
                    BillService.order(tableID, (int) good, goodNum);
                if (good instanceof String)
                    BillService.order(tableID, (String) good, goodNum);
                System.out.print("\n---点餐成功\t\t");
                System.out.print("是否继续点餐(Y:继续 | 其他任意键结束点餐)：");
                char c1 = Utility.readChar();
                if ('y' == c1 || 'Y' == c1) continue;
                else break;
            }
            System.out.print("取消预定\t\t");
            break;
        }
    }
}
