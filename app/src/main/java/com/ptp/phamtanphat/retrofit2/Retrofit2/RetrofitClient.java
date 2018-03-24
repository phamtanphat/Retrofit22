package com.ptp.phamtanphat.retrofit2.Retrofit2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KhoaPhamPC on 24/3/2018.
 */

public class RetrofitClient {
//    Cap phat gia tri truoc khi su dung
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseurl){
//        OkHttpClient thu vien quan ly cac ket noi
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                                .readTimeout(10000, TimeUnit.MILLISECONDS)
                                .retryOnConnectionFailure(true)
                                .build();
//        Bo chuyen doi json ve gson
        Gson gson = new GsonBuilder().setLenient().create();

//        cau hinh cho retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }
}
