package com.example.taobaounion.utils;

import android.util.Log;
//设置LogUtil类便于后面进行的操作
public class LogUtils {
    private static int currentLev=4;
    private static int DEBUG_LEV=4;
    private static int INFO_LEV=3;
    private static int WARNING_LEV=2;
    private static int ERROR_LEV=1;

    public static void d(Object object,String log){
        if (currentLev>=DEBUG_LEV){
            Log.d(object.getClass().getSimpleName(),log);
        }
    }
    public static void i(Object object,String log){
        if (currentLev>=INFO_LEV){
            Log.d(object.getClass().getSimpleName(),log);
        }
    }
    public static void w(Object object,String log){
        if (currentLev>=WARNING_LEV){
            Log.d(object.getClass().getSimpleName(),log);
        }
    }
    public static void e(Object object,String log){
        if (currentLev>=ERROR_LEV){
            Log.d(object.getClass().getSimpleName(),log);
        }
    }













}
