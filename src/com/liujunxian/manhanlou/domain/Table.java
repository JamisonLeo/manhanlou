package com.liujunxian.manhanlou.domain;

public class Table {
    private Integer ID;
    private String state;
    private String orderName;
    private String orderPhone;
    
    public Table() {
    }
    
    public Table(Integer ID, String state, String orderName, String orderPhone) {
        this.ID = ID;
        this.state = state;
        this.orderName = orderName;
        this.orderPhone = orderPhone;
    }
    
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getOrderName() {
        return orderName;
    }
    
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    
    public String getOrderPhone() {
        return orderPhone;
    }
    
    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }
    
    @Override
    public String toString() {
        return "\t  " + ID + "\t\t\t\t" + state;
    }
}
