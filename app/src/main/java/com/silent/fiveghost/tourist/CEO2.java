package com.silent.fiveghost.tourist;

/**
 * 懒汉式
 */

public class CEO2 {
    private static CEO2 mCEO = null;
    private CEO2(){

    }
    public static final synchronized CEO2 getInstance(){
        if(mCEO==null){
            mCEO = new CEO2();
        }
        return mCEO;
    }
}
