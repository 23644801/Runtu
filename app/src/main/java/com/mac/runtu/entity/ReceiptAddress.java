package com.mac.runtu.entity;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class ReceiptAddress {
    ReceiptUser receiptUser;
    Address address;
    boolean isDefault;

    public ReceiptUser getReceiptUser() {
        return receiptUser;
    }

    public void setReceiptUser(ReceiptUser receiptUser) {
        this.receiptUser = receiptUser;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
