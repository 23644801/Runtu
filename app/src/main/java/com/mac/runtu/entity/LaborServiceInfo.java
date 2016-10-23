package com.mac.runtu.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/10/23 0023.
 */
public class LaborServiceInfo implements Parcelable {
    /**
     * 精度
     */
    private double latitude;
    /**
     * 纬度
     */
    private double longitude;
    /**
     * 图片ID，
     */
    private int imgId;
    /**
     * 弹出框地点
     */
    private String address;
    /**
     * 弹出框信息
     */
    private String msg;

    /**
     * 弹出框时间
     */
    private String time;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public LaborServiceInfo(double latitude, double longitude, int imgId, String address, String msg, String time) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.imgId = imgId;
        this.address = address;
        this.msg = msg;
        this.time = time;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeInt(this.imgId);
        dest.writeString(this.address);
        dest.writeString(this.msg);
        dest.writeString(this.time);
    }

    public LaborServiceInfo() {
    }

    protected LaborServiceInfo(Parcel in) {
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.imgId = in.readInt();
        this.address = in.readString();
        this.msg = in.readString();
        this.time = in.readString();
    }

    public static final Parcelable.Creator<LaborServiceInfo> CREATOR = new Parcelable.Creator<LaborServiceInfo>() {
        @Override
        public LaborServiceInfo createFromParcel(Parcel source) {
            return new LaborServiceInfo(source);
        }

        @Override
        public LaborServiceInfo[] newArray(int size) {
            return new LaborServiceInfo[size];
        }
    };
}
