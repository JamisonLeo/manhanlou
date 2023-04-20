package com.liujunxian.manhanlou.domain;

import java.time.LocalDateTime;

public class Bill {
    private Integer ID;
    private Integer menuID;
    private Integer num;
    private double price;
    private Integer tableID;
    private LocalDateTime date;
    private String state;
    
    public Bill() {
    }
    
    public Bill(Integer ID, Integer menuID, Integer num, double price, Integer tableID, LocalDateTime date, String state) {
        this.ID = ID;
        this.menuID = menuID;
        this.num = num;
        this.price = price;
        this.tableID = tableID;
        this.date = date;
        this.state = state;
    }
    
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public Integer getMenuID() {
        return menuID;
    }
    
    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }
    
    public Integer getNum() {
        return num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public Integer getTableID() {
        return tableID;
    }
    
    public void setTableID(Integer tableID) {
        this.tableID = tableID;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
}
