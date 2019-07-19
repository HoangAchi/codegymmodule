package com.achihoang.model;

public class Product {
    private int id;
    private String name;
    private int count;
    private int unitPrice;
    public Product(){}

    public Product(int id, String name, int count, int unitPrice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
