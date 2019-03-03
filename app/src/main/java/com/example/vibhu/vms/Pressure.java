package com.example.vibhu.vms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Pressure extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    ArcProgress arcProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        showdata();
        listView=findViewById(R.id.press);
        arrayList=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        arcProgress=findViewById(R.id.arc_progress);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String val= (String) adapterView.getItemAtPosition(i);
                int val1=Integer.parseInt(val);
                arcProgress.setProgress(val1);
            }
        });


    }
    public void showdata(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://alok760.ml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        customapi customApi=retrofit.create(customapi.class);
        Call<List<heirarchynew>>call=customApi.checkapi();
        Log.d("hello1","yes");
        call.enqueue(new Callback<List<heirarchynew>>() {
            @Override
            public void onResponse(Call<List<heirarchynew>> call, Response<List<heirarchynew>> response) {
                List<heirarchynew> obj=response.body();
                String check=obj.get(0).getValue();
                Log.d("hello",check);
                arrayList.add(check);
                arrayList.add(obj.get(1).getValue());
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<heirarchynew>> call, Throwable t) {

            }
        });


    }

}
