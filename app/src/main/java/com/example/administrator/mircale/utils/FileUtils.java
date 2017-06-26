package com.example.administrator.mircale.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 王春雪 on 2017/6/26.
 */

public class FileUtils {
    public static String getAsset(Context context, String fileName) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            AssetManager manager = context.getAssets();
            InputStream inputStream = manager.open(fileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte [] buffer = new byte[1024];
            int len ;
            while ((len=bufferedInputStream.read(buffer))!=-1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.logi("main", "文件打开错误");
        }
        return byteArrayOutputStream.toString();
    }

}
