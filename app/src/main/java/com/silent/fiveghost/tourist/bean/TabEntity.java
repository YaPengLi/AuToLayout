package com.silent.fiveghost.tourist.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/18.
 */

public class TabEntity implements Serializable{
    private String name;
    private String type;
    private String status;

    public TabEntity() {
    }

    public TabEntity(String name, String type, String status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}