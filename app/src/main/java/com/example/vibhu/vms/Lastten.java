package com.example.vibhu.vms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Lastten extends AppCompatActivity {
    String parameter;
    String regino;
    ListView listView;
    ArrayList<obj> arrayList;
    customAdapter cust;
    String pass1;
    String pass2;
    String pass3;
    String pass4;
    String pass5;
    String pass6;
    String pass7;
    String pass8;
    String pass9;
    String pass10;
    String pass11;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastten);
        listView=findViewById(R.id.lastlist);
        count=0;
        arrayList=new ArrayList<>();
        cust=new customAdapter(arrayList,this);
        listView.setAdapter(cust);
        Intent intent=getIntent();
        Log.d("air20","yes");
        pass1=intent.getStringExtra("pass1");
        pass2=intent.getStringExtra("pass2");
        pass3=intent.getStringExtra("pass3");
        pass4=intent.getStringExtra("pass4");
        pass5=intent.getStringExtra("pass5");
        pass6=intent.getStringExtra("pass6");
        pass7=intent.getStringExtra("pass7");
        pass8=intent.getStringExtra("pass8");
        pass9=intent.getStringExtra("pass9");
        pass10=intent.getStringExtra("pass10");
        pass11=intent.getStringExtra("pass11");
        parameter=intent.getStringExtra("check");
        regino=intent.getStringExtra("regino");
        Log.d("air11",parameter);
        Log.d("air12",pass1);
        fetchData();


    }

    private void fetchData() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://ec2-13-234-38-156.ap-south-1.compute.amazonaws.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        customapi customApi=retrofit.create(customapi.class);
        Call<List<paramobj>> call=customApi.fetchdata();
        call.enqueue(new Callback<List<paramobj>>() {
            @Override
            public void onResponse(Call<List<paramobj>> call, Response<List<paramobj>> response) {
                List<paramobj> hell=response.body();
                for(int i=0;i<hell.size();i++){
                    if(count<=10){
                        paramobj hey=hell.get(i);
                        Log.d("air14","yes");
                        Log.d("air15",hey.getCar_id());
                        if(hey.getCar_id().equals(regino)){
                            Log.d("air16","yes");
                            Log.d("air21",pass1);
                            Log.d("air22",parameter);
                            if(parameter.equals(pass1)){
                                Log.d("air13",pass1);
                                arrayList.add(new obj(hey.getEng_cool_temp()+""));
                                cust.notifyDataSetChanged();
                            }
                            else if(parameter.equals(pass2)){
                                arrayList.add(new obj(hey.getEng_rpm()+""));
                                cust.notifyDataSetChanged();
                            }
                            else if(parameter.equals(pass3)){
                                arrayList.add(new obj(hey.getMaf()+""));
                                cust.notifyDataSetChanged();
                            }
                            else if(parameter.equals(pass4)){
                                arrayList.add(new obj(hey.getAbso_throt()+""));
                                cust.notifyDataSetChanged();
                            }
                            else if(parameter.equals(pass5)){
                                arrayList.add(new obj(hey.getIntake_air()+""));
                                cust.notifyDataSetChanged();
                            }
                            else if(parameter.equals(pass6)){
                                arrayList.add(new obj(hey.getComp_ratio()+""));
                                cust.notifyDataSetChanged();
                            }
                            else if(parameter.equals(pass7)){
                                arrayList.add(new obj(hey.getCar_load_val()+""));
                                cust.notifyDataSetChanged();
                            }
                            else if(parameter.equals(pass8)){
                                arrayList.add(new obj(hey.getVeh_speed()+""));
                                cust.notifyDataSetChanged();
                            }
                            else if(parameter.equals(pass9)){
                                arrayList.add(new obj(hey.getBaro_press()+""));
                                cust.notifyDataSetChanged();
                            }
                            else if(parameter.equals(pass10)){
                                arrayList.add(new obj(hey.getTiming_advance()+""));
                                cust.notifyDataSetChanged();
                            }
                            else if(parameter.equals(pass11)){
                                arrayList.add(new obj(hey.getAc_status()+""));
                                cust.notifyDataSetChanged();
                            }

                        }
                    }
                    else{
                        break;
                    }
                }

            }

            @Override
            public void onFailure(Call<List<paramobj>> call, Throwable t) {

            }
        });
    }

}
