package com.silent.fiveghost.tourist.bean;

/**
 * Created by 农民伯伯 on 2018/3/18.
 */

public class RoadBean {
    private String time;
    private String price;

    public RoadBean(String time, String price) {
        this.time = time;
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
