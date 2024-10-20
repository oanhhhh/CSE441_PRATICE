package com.example.prac02_1;

public class Staff {
    private String id;
    private String name;
    private String bd;
    private String salary;

    public Staff(String id, String name, String bd, String salary) {
        this.id = id;
        this.name = name;
        this.bd = bd;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
