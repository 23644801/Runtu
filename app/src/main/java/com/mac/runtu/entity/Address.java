package com.mac.runtu.entity;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class Address {
    String province;
    String city;
    String area;
    String other;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return province + " " + city + " " + area +" "+other;
    }
}
