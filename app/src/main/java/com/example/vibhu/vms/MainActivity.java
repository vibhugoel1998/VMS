package com.example.vibhu.vms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<obj> arrayList;
    customAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView=findViewById(R.id.listview);
        arrayList=new ArrayList<>();
        arrayList.add(new obj("Pressure"));
        arrayList.add(new obj("Temperature"));
        arrayList.add(new obj("Vibration"));
        arrayList.add(new obj("Gas Leakage"));
        arrayList.add(new obj("OBD Analysis"));
        arrayAdapter=new customAdapter(arrayList,MainActivity.this);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                obj item= (obj) adapterView.getItemAtPosition(i);
                Log.d("check",item.getName());
                if(item.getName().equals("Pressure")){
                    Intent intent=new Intent(MainActivity.this,Pressure.class);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mechanics) {
            Intent intent=new Intent(MainActivity.this,Mechanics.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
