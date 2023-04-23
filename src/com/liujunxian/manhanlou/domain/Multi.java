package com.liujunxian.manhanlou.domain;

import java.time.LocalDateTime;

public class Multi {
    private String ID;
    private Integer num;
    private double price;
    private Integer tableID;
    private LocalDateTime date;
    private String state;
    private String name;
    
    public Multi() {
    }
    
    public Multi(String ID, Integer num, double price, Integer tableID, LocalDateTime date, String state, String name) {
        this.ID = ID;
        this.num = num;
        this.price = price;
        this.tableID = tableID;
        this.date = date;
        this.state = state;
        this.name = name;
    }
    
    public String getID() {
        return ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return " " + tableID + "\t\t" + date + "\t\t" + name + "\t\t " + num + "\t\t" + price + "\t" + state;
    }
}
