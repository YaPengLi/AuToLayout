package com.silent.fiveghost.tourist.bean;

/**
 * Created by yiheng on 2018/3/19.
 */

public class Documents {
    public int type;
    public String username;
    public String birthday;
    public String number;
    public String remarks;

    public Documents() {
    }

    public Documents(int type, String username, String birthday, String number, String remarks) {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Documents{" +
                "type=" + type +
                ", username='" + username + '\'' +
                ", birthday='" + birthday + '\'' +
                ", number='" + number + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
