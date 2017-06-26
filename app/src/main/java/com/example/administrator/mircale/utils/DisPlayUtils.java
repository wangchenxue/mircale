package com.example.administrator.mircale.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by 王春雪 on 2017/6/21.
 * 获取屏幕宽高以及dp,px转换
 */

public class DisPlayUtils {
    /**
     * @param context
     * @return 屏幕宽度的像素值
     */
    public static int getDisplayWidth(Context context) {
        //在Activity中可以直接通过 getWindowManager()获取WindowManager

        return getDisplayMetrics(context).widthPixels;
    }

    /**
     * @param context
     * @return 获取DisplayMetrics
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        return metrics;
    }

    /**
     * @param context
     * @return 返回屏幕高度
     */
    public static int getDisplayHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    /**
     * @param context
     * @param pix     像素
     * @return 返回dp
     */
    public static int px2dp(Context context, int pix) {
        int desityDip = getDisplayMetrics(context).densityDpi;
        return pix * 160 / desityDip;
    }

    /**
     * @param context
     * @param dp      dp
     * @return 返回像素
     */
    public static int dp2px(Context context, int dp) {
        int desityDip = getDisplayMetrics(context).densityDpi;
        return dp * desityDip / 160;
    }
}
