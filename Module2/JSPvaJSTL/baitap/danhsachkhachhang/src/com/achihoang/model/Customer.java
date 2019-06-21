package com.achihoang.model;

import java.util.Date;

public class Customer {
    private int id;
    private String name;
    private String daybirth;
    private String address;
    private String image;

    public Customer(){}

    public Customer(int id,String name,String daybirth,String address,String image){
        this.id=id;
        this.name=name;
        this.daybirth=daybirth;
        this.address=address;
        this.image=image;
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

    public String getDaybirth() {
        return daybirth;
    }

    public void setDaybirth(String daybirth) {
        this.daybirth = daybirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
