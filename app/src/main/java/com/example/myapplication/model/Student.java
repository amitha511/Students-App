package com.example.myapplication.model;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;
    public String id;
    public String phone;
    public String address;
    public Boolean cb;

    public Student(String name, String id, String phone,String address, Boolean cb) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.cb = cb;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getCb() {
        return cb;
    }

    public void setCb(Boolean cb) {
        this.cb = cb;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
