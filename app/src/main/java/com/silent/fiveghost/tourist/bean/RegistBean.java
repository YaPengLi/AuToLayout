package com.silent.fiveghost.tourist.bean;

public class RegistBean {

    /**
     * errcode : 1
     * errmsg : ok
     * data : {"access_token":"u-n-6Ep8_iaKNbQDVqJWjX9CcuF23Z5r"}
     */

    private int errcode;
    private String errmsg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * access_token : u-n-6Ep8_iaKNbQDVqJWjX9CcuF23Z5r
         */

        private String access_token;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }
    }
}
