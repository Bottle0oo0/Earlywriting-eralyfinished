package com.neu.his.entity;

public class Drug {
    private int id;
    private String code;
    private String name;
    private String format;
    private String unit;
    private String manufacturer;
    private String dosage;
    private String type;
    private double price;
    private String mnemonicCode; //助记码


    public Drug(int id, String code, String name, String format, String unit, String manufacturer, String dosage, String type, double price, String mnemonicCode) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.format = format;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.dosage = dosage;
        this.type = type;
        this.price = price;
        this.mnemonicCode = mnemonicCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
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

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }
}
