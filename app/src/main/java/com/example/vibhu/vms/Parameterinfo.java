package com.example.vibhu.vms;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Parameterinfo extends AppCompatActivity {

    ArrayList<paramobj> arrayList;
    paramAdapter adapter;
    ArrayList<showobj> alist;
    String hello;
    ListView listView;
    ArrayList<obj> stringArrayList;
    dataAdapter sadapter;
    paramobj itc;
    Intent intent2;
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
    String pass12;
    private final Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameterinfo);
        final Intent intent=getIntent();
        hello=intent.getStringExtra("carnumber");
        itc=new paramobj();
        arrayList=new ArrayList<>();
        alist=new ArrayList<>();
        listView=findViewById(R.id.listview1);
        stringArrayList=new ArrayList<>();
        sadapter=new dataAdapter(stringArrayList,this);
        listView.setAdapter(sadapter);
        adapter=new paramAdapter(alist,this);
        final Handler handler = new Handler();
        fetchData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                obj item= (obj) adapterView.getItemAtPosition(i);
                String ob=item.getName();
                intent2=new Intent(Parameterinfo.this,Lastten.class);
                intent2.putExtra("check",ob);
                intent2.putExtra("regino",hello);
                intent2.putExtra("pass1",pass1);
                intent2.putExtra("pass2",pass2);
                intent2.putExtra("pass3",pass3);
                intent2.putExtra("pass4",pass4);
                intent2.putExtra("pass5",pass5);
                intent2.putExtra("pass6",pass6);
                intent2.putExtra("pass7",pass7);
                intent2.putExtra("pass8",pass8);
                intent2.putExtra("pass9",pass9);
                intent2.putExtra("pass10",pass10);
                intent2.putExtra("pass11",pass11);
                startActivity(intent2);
            }
        });



    }



    private void fetchData() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://ec2-13-234-38-156.ap-south-1.compute.amazonaws.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        customapi customApi=retrofit.create(customapi.class);
        Call<List<paramobj>> call=customApi.fetchdata();
        Log.d("sih3","yes");
        call.enqueue(new Callback<List<paramobj>>() {
            @Override
            public void onResponse(Call<List<paramobj>> call, Response<List<paramobj>> response) {
                List<paramobj> help=response.body();
                if(help!=null){
                    Log.d("air1","yes");
                    for(int i=0;i<help.size();i++){
                        paramobj show=help.get(i);
                        Log.d("air2","yes");
                        Log.d("air4",show.getCar_id());
                        Log.d("air5",show.getSno()+"");
                        Log.d("air6",show.getCar_id()+"");

                        if(show!=null) {
                            if (show.getCar_id().equals(hello)) {
                                Log.d("air10",show.getEng_cool_temp().toString());
                                obj heuy1=new obj("Engine Coolant Temperature: "+show.getEng_cool_temp().toString());
                                pass1="Engine Coolant Temperature: "+show.getEng_cool_temp().toString();
                                stringArrayList.add(heuy1);
                                obj heuy2=new obj("Engine RPM: "+show.getEng_rpm().toString());
                                pass2="Engine RPM: "+show.getEng_rpm().toString();
                                stringArrayList.add(heuy2);
                                obj heuy4=new obj("Mass Air Flow: "+show.getMaf().toString());
                                pass3="Mass Air Flow: "+show.getMaf().toString();
                                stringArrayList.add(heuy4);
                                obj heuy5=new obj("Throttle Pressure: "+show.getAbso_throt().toString());
                                pass4="Throttle Pressure: "+show.getAbso_throt().toString();
                                stringArrayList.add(heuy5);
                                obj heuy6=new obj("Air Intake: "+show.getIntake_air().toString());
                                pass5="Air Intake: "+show.getIntake_air().toString();
                                stringArrayList.add(heuy6);
                                obj heuy7=new obj("Compression Ratio: "+show.getComp_ratio().toString());
                                pass6="Compression Ratio: "+show.getComp_ratio().toString();
                                stringArrayList.add(heuy7);
                                obj heuy8=new obj("Vehicle Load: "+show.getCar_load_val().toString());
                                pass7="Vehicle Load: "+show.getCar_load_val().toString();
                                stringArrayList.add(heuy8);
                                obj heuy9=new obj("Vehicle Speed: "+show.getVeh_speed());
                                pass8="Vehicle Speed: "+show.getVeh_speed();
                                stringArrayList.add(heuy9);
                                obj heuy10=new obj("Barometer Pressure: "+show.getBaro_press());
                                pass9="Barometer Pressure: "+show.getBaro_press();
                                stringArrayList.add(heuy10);
                                obj heuy11=new obj("Timing Advance: "+show.getTiming_advance());
                                pass10="Timing Advance: "+show.getTiming_advance();
                                stringArrayList.add(heuy11);
                                obj heuy12=new obj("AC Status: "+show.getAc_status());
                                pass11="Ac Status: "+show.getAc_status();
                                stringArrayList.add(heuy12);
                                sadapter.notifyDataSetChanged();
                                break;


                            }
                        }

                    }
                }
            }


            @Override
            public void onFailure(Call<List<paramobj>> call, Throwable t) {

            }
        });

    }
    public void Refr(View view){
        fetchData();
    }
    public void openM(View view){
        Intent intent=new Intent(Parameterinfo.this,Mechanics.class);
        startActivity(intent);
    }

    public void myClickHandler(View view){
        LinearLayout vwParentRow = (LinearLayout)view.getParent();
        final TextView child = (TextView)vwParentRow.getChildAt(1);
        Button btnChild = (Button)vwParentRow.getChildAt(2);
        btnChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ch=child.getText().toString();
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("http://ec2-13-234-38-156.ap-south-1.compute.amazonaws.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                customapi customApi=retrofit.create(customapi.class);
                Call<List<outobj>> call=customApi.fetchout();
                call.enqueue(new Callback<List<outobj>>() {
                    @Override
                    public void onResponse(Call<List<outobj>> call, Response<List<outobj>> response) {
                        List<outobj> newobj=response.body();
                        outobj hello=newobj.get(0);
                        String obreak=hello.getOutput_break();
                        String oengine=hello.getOutput_engine();
                        String ofuel=hello.getOutput_fuel();
                        String createdat=hello.getCreated_at();
                        String updatedat=hello.getUpdated_at();

                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Parameterinfo.this);
                        builder1.setMessage("Analysis Result:\n"+obreak+"\n"+oengine+"\n"+ofuel+"\n Created at: "+createdat+"\n Updated at: "+updatedat);
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        builder1.setNegativeButton(
                                "Contact Mechanic",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        finish();
                                        Intent intent1=new Intent(Parameterinfo.this,Mechanics.class);
                                        startActivity(intent1);
                                    }
                                });

                        AlertDialog alert11 = builder1.create();
                        alert11.show();



                    }

                    @Override
                    public void onFailure(Call<List<outobj>> call, Throwable t) {

                    }
                });
            }
        });
    }

}
