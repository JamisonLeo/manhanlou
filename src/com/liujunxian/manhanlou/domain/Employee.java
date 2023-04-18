package com.liujunxian.manhanlou.domain;

public class Employee {
    private String EmpID;
    private String Password;
    private String Name;
    private String Job;
    
    public Employee() {
    }
    
    public Employee(String empID, String password, String name, String job) {
        EmpID = empID;
        Password = password;
        Name = name;
        Job = job;
    }
    
    public String getEmpID() {
        return EmpID;
    }
    
    public void setEmpID(String empID) {
        EmpID = empID;
    }
    
    public String getPassword() {
        return Password;
    }
    
    public void setPassword(String password) {
        Password = password;
    }
    
    public String getName() {
        return Name;
    }
    
    public void setName(String name) {
        Name = name;
    }
    
    public String getJob() {
        return Job;
    }
    
    public void setJob(String job) {
        Job = job;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "EmpID='" + EmpID + '\'' +
                ", Password='" + Password + '\'' +
                ", Name='" + Name + '\'' +
                ", Job='" + Job + '\'' +
                '}';
    }
}
