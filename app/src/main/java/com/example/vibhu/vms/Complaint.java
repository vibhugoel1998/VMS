package com.example.vibhu.vms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Complaint extends AppCompatActivity {
    String carno;
    EditText phn;
    EditText compn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        Intent intent=getIntent();
        carno=intent.getStringExtra("carno");
        compn=findViewById(R.id.actualcomplaint);
        phn=findViewById(R.id.actualphone);
    }
    public void comp(View view){
        String sender=compn.getText().toString();
        String on=phn.getText().toString();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"goelvibhu1998@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, carno);
        i.putExtra(Intent.EXTRA_TEXT   , sender+"\n Phone-"+on);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Complaint.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }

}
