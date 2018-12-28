package com.demo.sdk.common_base.utils;

import android.util.Log;

public class LogUtil {
    private static boolean isLogEnable = true;

    private static String tag = "LogUtil";

    public static void debug(boolean isEnable) {
        debug(tag, isEnable);
    }

    public static void debug(String logTag, boolean isEnable) {
        tag = logTag;
        isLogEnable = isEnable;
    }

    public static void v(String msg) {
        v(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isLogEnable) Log.v(tag, msg);
    }

    public static void d(String msg) {
        d(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isLogEnable) Log.d(tag, msg);
    }

    public static void i(String msg) {
        i(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (isLogEnable) Log.i(tag, msg);
    }

    public static void w(String msg) {
        w(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (isLogEnable) Log.w(tag, msg);
    }

    public static void e(String msg) {
        e(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isLogEnable) Log.e(tag, msg);
    }

    public static void printStackTrace(Throwable t) {
        if (isLogEnable && t != null) t.printStackTrace();
    }


    public static void e(Throwable e) {
        if (!isLogEnable) {
            return;
        }
        if (e != null && e.getStackTrace() != null) {
            if (e.getCause() != null) {
                LogUtil.e("cause:" + e.getCause().toString());
            }
            LogUtil.e("message:" + e.getMessage());
            for (StackTraceElement item :
                    e.getStackTrace()) {
                LogUtil.e(item.toString());
            }
        }
    }
}
