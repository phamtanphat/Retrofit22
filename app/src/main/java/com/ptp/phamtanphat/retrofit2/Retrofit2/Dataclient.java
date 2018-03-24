package com.ptp.phamtanphat.retrofit2.Retrofit2;

import com.ptp.phamtanphat.retrofit2.Monan;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by KhoaPhamPC on 24/3/2018.
 */

public interface Dataclient {
    //Chua nhung phuc thuc tuong tac voi server
    //Chua du lieu sau khi server tra ve

    //Muon gui tham so len cho url
//    @GET("users/list") =>@GET("users/list?sort=desc")
//    sort , internet , facebook =>@QueryMap su dung cho nhiu du lieu noi duoi voi nhau

//    @GET("users/list")
//    Call<Monan> getdata(@Query("sort") String desc)
    //Thay doi gia trong url
//    @GET("group/{id}/users")
//    Call<Monan> getdata(@Path("id") String id);

    @GET("getdata.php")
    Call<List<Monan>> getMonan();
}
