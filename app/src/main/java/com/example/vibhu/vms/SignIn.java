package com.example.vibhu.vms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    EditText carno;
    EditText pass;
    private DatabaseReference mdatabase;
    String carnocheck;
    String passwordcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        carno = findViewById(R.id.num);
        pass = findViewById(R.id.pa);
        mdatabase = FirebaseDatabase.getInstance().getReference();
    }
    public void checksign(View view){
        carnocheck=carno.getText().toString();
        passwordcheck=pass.getText().toString();
        mdatabase.child("Entries").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String hello=snapshot.getKey();
                    Log.d("vibs3",hello);
                    if(hello.equals(carnocheck)){
                        String hey=snapshot.child("password").getValue(String.class);
                        Log.d("vibs4",hey);
                        if(hey.equals(passwordcheck)){
                            Intent intent=new Intent(SignIn.this,Parameterinfo.class);
                            intent.putExtra("carnumber",carnocheck);
                            startActivity(intent);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
