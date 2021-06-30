package com.neu.his.entity;

public class Department {
    private String id;
    private String name;
    private String category;
    private String type;

    public Department(String id, String name, String category, String type) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.type = type;
    }

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Department(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
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
}
