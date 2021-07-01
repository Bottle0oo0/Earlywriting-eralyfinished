package com.neu.his.entity;

public class Department {
    private int id;
    private String code;
    private String name;
    private String category;
    private String type;

    public Department(int id, String name, String code, String category, String type) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.category = category;
        this.type = type;
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Department(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
