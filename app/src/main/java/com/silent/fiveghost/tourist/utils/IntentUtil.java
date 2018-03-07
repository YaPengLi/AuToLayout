package com.silent.fiveghost.tourist.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

/**
 * 作者： funChen.
 */

public class IntentUtil {

    public static void startActivity(Activity activity, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
    }

    public static void startActivityForResult(Activity activity, Class<?> cls, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 只支持 string
     *
     * @param activity
     * @param cls
     * @param strap
     */
    public static void startActivity(Activity activity, Class<?> cls, Strap strap) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        for (String key : strap.keySet()) {
            if (strap.get(key) instanceof String) intent.putExtra(key, strap.getString(key));
            else if (strap.get(key) instanceof Integer) intent.putExtra(key, strap.getInteger(key));
            else if (strap.get(key) instanceof Boolean) intent.putExtra(key, strap.getBoolean(key));
        }
        activity.startActivity(intent);
    }

    public static void startActivityForResult(Activity activity, Class<?> cls, Strap strap, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        if (strap != null) {
            for (String key : strap.keySet()) {
                intent.putExtra(key, strap.getString(key));
            }
        }
        activity.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult(Fragment fragment, Class<?> cls, Strap strap, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(fragment.getActivity(), cls);
        if(strap!=null){
            for (String key : strap.keySet()) {
                if (strap.get(key) instanceof String) intent.putExtra(key, strap.getString(key));
                else if (strap.get(key) instanceof Integer) intent.putExtra(key, strap.getInteger(key));
                else if (strap.get(key) instanceof Boolean) intent.putExtra(key, strap.getBoolean(key));
            }
        }
        fragment.startActivityForResult(intent, requestCode);
    }

    /**
     * 6.0 手机系统以上 检查并请求权限
     * @param context 必须为 Activity
     */
    public static void checkAndRequestPermissionAbove23(Activity context){
        int i = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);
        if (i!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(context,
                    new String[]{Manifest.permission.CAMERA}, Constant.TAKE_PHOTO_PERMISSION
            );
        }
    }
}
