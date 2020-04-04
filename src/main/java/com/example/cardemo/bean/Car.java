package com.example.cardemo.bean;

import java.io.Serializable;

public class Car implements Serializable {

    String model;
    String carid;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }
}
