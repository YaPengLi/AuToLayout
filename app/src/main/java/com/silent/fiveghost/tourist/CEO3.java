package com.silent.fiveghost.tourist;

/**
 * DCL
 */

public class CEO3 {
    private static CEO3 mCEO = null;
    private CEO3(){

    }
    public static final  CEO3 getInstance(){
        if(mCEO==null){
            synchronized(CEO3.class){
                if(mCEO==null){
                    mCEO = new CEO3();
                }
            }
        }
        return mCEO;
    }
}
