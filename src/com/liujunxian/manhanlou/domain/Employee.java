package com.liujunxian.manhanlou.domain;

public class Employee {
    private String empID;
    private String password;
    private String name;
    private String job;
    
    public Employee() {
    }
    
    public Employee(String empID, String password, String name, String job) {
        this.empID = empID;
        this.password = password;
        this.name = name;
        this.job = job;
    }
    
    public String getEmpID() {
        return empID;
    }
    
    public void setEmpID(String empID) {
        this.empID = empID;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getJob() {
        return job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }
}
