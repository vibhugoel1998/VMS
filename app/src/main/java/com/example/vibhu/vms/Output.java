package com.example.vibhu.vms;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        final Intent intent=getIntent();
        Log.d("goel",intent.getStringExtra("Hello"));
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

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(Output.this);
                    builder1.setMessage("Analysis Result:\n"+obreak+"\n"+oengine+"\n"+ofuel+"\n Created at: "+createdat+"\n Updated at: "+updatedat);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    finish();
                                }
                            });

                    builder1.setNegativeButton(
                            "Contact Mechanic",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    finish();
                                    Intent intent1=new Intent(Output.this,Mechanics.class);
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

}
