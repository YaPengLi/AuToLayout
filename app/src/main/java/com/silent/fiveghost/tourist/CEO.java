package com.silent.fiveghost.tourist;

/**
 * 饿汉式
 */

public class CEO {
    private static final CEO mCEO = new CEO();

    private CEO(){}
    public static final CEO getInstance(){
        return mCEO;
    }
}
