package com.mac.runtu.entity;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class Order {
    public enum State {
        all,
        completed,
        pending_payment,
        receipt_of_goods
    }

    private State state;
    private int number;
    private float price;
    private Address address;
    private String name;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
