package com.example.vibhu.vms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Mechanics extends AppCompatActivity {
    RecyclerView allmech;
    RecyclerAdapter recyclerAdapter;
    ArrayList<fireobj> arrayList;
    private DatabaseReference mdatabase;
    RecyclerView nearmech;
    ArrayList<fireobj> near;
    RecyclerAdapter nearadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanics);
        mdatabase= FirebaseDatabase.getInstance().getReference();
        allmech=findViewById(R.id.allmech);
        arrayList=new ArrayList<>();
        recyclerAdapter=new RecyclerAdapter(arrayList, this, new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        allmech.setAdapter(recyclerAdapter);
        allmech.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        allmech.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        allmech.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        fetchallmech();


    }

    private void fetchallmech() {
        mdatabase.child("Mechanics").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String name=snapshot.getKey();
                    String address=snapshot.child("Address").getValue(String.class);
                    String image=snapshot.child("Image").getValue(String.class);
                    Long phone=snapshot.child("Phone").getValue(Long.class);
                    Double lat=snapshot.child("Lat").getValue(Double.class);
                    Double lon=snapshot.child("Lon").getValue(Double.class);
                    fireobj hello=new fireobj(name,address,image,lat,lon,phone);
                    arrayList.add(hello);

                }
               // nearadapter.notifyDataSetChanged();
                recyclerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void Distance(){

    }

}
