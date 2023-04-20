package com.liujunxian.manhanlou.domain;

public class Menu {
    private Integer ID;
    private String name;
    private String type;
    private double price;
    
    public Menu() {
    }
    
    public Menu(int ID, String name, String type, double price) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.price = price;
    }
    
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "\t\t   " + ID + "\t\t" + name + "\t\t" + type + "\t\t" + price;
    }
}
