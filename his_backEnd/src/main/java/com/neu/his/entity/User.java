package com.neu.his.entity;
public class User {
    private int id;
    private String psw;
    private String name;
    private String departmentId;
    private int type;

    public User(int id, String psw, String name, String departmentId, int type) {
        this.id = id;
        this.psw = psw;
        this.name = name;
        this.departmentId = departmentId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}