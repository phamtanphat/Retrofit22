package com.ptp.phamtanphat.retrofit2.Retrofit2;

/**
 * Created by KhoaPhamPC on 24/3/2018.
 */

public class APIService {
    //Duong dan url ket thuc bang dau /
    //Duong dan url la folder co the truy cap den tat ca cac file
    private static String Base_Url = "http://10.0.0.11/Monan/";

    public static Dataclient GetData(){
        //Phuong thuc dung de khoi tao retrofit va gui phuong thuc tu dataclient len cho server
        return RetrofitClient.getClient(Base_Url).create(Dataclient.class);
    }
}
