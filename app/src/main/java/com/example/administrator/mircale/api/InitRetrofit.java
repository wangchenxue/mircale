package com.example.administrator.mircale.api;

import android.util.Log;

import com.example.administrator.mircale.config.IPAdress;
import com.example.administrator.mircale.utils.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 王春雪 on 2017/6/16.
 */

public class InitRetrofit {
    private static OkHttpClient client = new OkHttpClient
            .Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(IPAdress.BASE_URL)
            .client(client)
            //和Rxjava结合
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            //可以返回gson解析的实体类
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //自定义的拦截器，这里是用的系统的HttpLoggingInterceptor
    static class LoggingIntercepter implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long startTime = System.nanoTime();
            LogUtils.logi("main", String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
            Response response = chain.proceed(request);
            long endtime = System.nanoTime();
            LogUtils.logi("main", String.format("Reciverd response for %s in %.lfms%n%s",
                    response.request().url(), (endtime - startTime) / 1e6d, response.headers()));

            return response;

        }
    }

    private InitRetrofit() {

    }

    public static <T> T createApi(Class<T> mClass) {
        return retrofit.create(mClass);
    }
}
