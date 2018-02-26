package com.silent.fiveghost.tourist.bean;

/**
 * Created by 韩学文 on 2018/1/29.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */

public class VerificationCodeBean {

    /**
     * errcode : 1
     * errmsg : ok
     * data : 3379
     */

    private int errcode;
    private String errmsg;
    private int data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
