package com.example.cardemo.bean;

import java.io.Serializable;

public class Carbooking implements Serializable {

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public String getCarid() {
        return carid;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }


    private String phonenum;

    private String carid;

    private String starttime;

    private String endtime;


    @Override
    public String toString() {
        return "Carbooking{" +
                "phonenum='" + phonenum + '\'' +
                ", carid='" + carid + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                '}';
    }
}
