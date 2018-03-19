package com.silent.fiveghost.tourist.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/20.
 */

public class PersonBean implements Serializable{
    private int type;
    private String username;
    private String birthday;
    private int number;
    private String remarks;
    public PersonBean() {
    }

    public PersonBean(int type, String username, String birthday, int number, String remarks) {
        this.type = type;
        this.username = username;
        this.birthday = birthday;
        this.number = number;
        this.remarks = remarks;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
