package com.example.administrator.mircale.utils;

import android.content.Context;
import android.util.Log;

/**
 * log 日志
 * Created by 王春雪 on 2017/06/16
 */

public class LogUtils {
    private static final boolean FLAG = true;

    public static String getTag(Context context) {
        String tag = context.getClass().getCanonicalName();
        return tag;
    }

    public static void logi(Context context, String msg) {
        //log info
        if (FLAG) {
            String tag = getTag(context);
            Log.i(tag, "***" + msg);
        }
    }

    public static void loge(Context context, String msg) {
        // log error
        if (FLAG) {
            String tag = getTag(context);
            Log.e(tag, "***" + msg);
        }
    }

    public static void logi(String tag, String msg) {
        //log info
        if (FLAG) {
            Log.i(tag, "***" + msg);
        }
    }

    public static void loge(String tag, String msg) {
        // log error
        if (FLAG) {
            Log.e(tag, "***" + msg);
        }
    }
}
