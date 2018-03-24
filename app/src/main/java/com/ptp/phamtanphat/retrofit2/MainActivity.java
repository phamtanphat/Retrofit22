package com.ptp.phamtanphat.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.ptp.phamtanphat.retrofit2.Retrofit2.APIService;
import com.ptp.phamtanphat.retrofit2.Retrofit2.Dataclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    MonanAdapter monanAdapter;
    ListView listView;
    ArrayList<Monan> mangmonan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listviewmonan);

        //Thuc hien khoi tao class va tuong tac du lieu
        Dataclient dataclient = APIService.GetData();
        //Chi ra phuong thuc muon gui trong dataclient
        Call<List<Monan>> callback = dataclient.getMonan();
        callback.enqueue(new Callback<List<Monan>>() {
            @Override
            public void onResponse(Call<List<Monan>> call, Response<List<Monan>> response) {
                //Lay du lieu tu response.body() khong dung to string
                mangmonan = (ArrayList<Monan>) response.body();
                monanAdapter = new MonanAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mangmonan);
                listView.setAdapter(monanAdapter);

            }

            @Override
            public void onFailure(Call<List<Monan>> call, Throwable t) {
                Log.d("BBB",t.getMessage());
            }
        });
    }
}
