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
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity {
    private DatabaseReference mdatabase;
    EditText Username;
    EditText vehiclenumber;
    EditText email;
    EditText phone;
    EditText policynumber;
    EditText password;
    String suusername;
    String vehivlnember;
    String email1;
    Double cwcphone;
    String policynum;
    String pass;
    TextView comp;
    int hey;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mdatabase= FirebaseDatabase.getInstance().getReference();
        Username=findViewById(R.id.username);
        vehiclenumber=findViewById(R.id.vehinumber);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        policynumber=findViewById(R.id.policy);
        password=findViewById(R.id.password);
        hey=0;
        comp=findViewById(R.id.registercomp);
        comp.setVisibility(View.INVISIBLE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        comp.setVisibility(View.INVISIBLE);
    }


    public void makenew(View view){
        suusername=Username.getText().toString();
        vehivlnember=vehiclenumber.getText().toString();
        email1=email.getText().toString();
        cwcphone=Double.parseDouble(phone.getText().toString());
        policynum=policynumber.getText().toString();
        pass=password.getText().toString();
            mdatabase.child("Entries").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.d("check","done");
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        String check=snapshot.getKey();
                        Log.d("hello","yes");
                        if(check.equals(vehivlnember)){
                            hey=1;
                            comp.setVisibility(View.VISIBLE);
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        if(hey==0){
            mdatabase.child("Entries").child(vehivlnember).child("username").setValue(suusername);
            mdatabase.child("Entries").child(vehivlnember).child("email").setValue(email1);
            mdatabase.child("Entries").child(vehivlnember).child("phone").setValue(cwcphone);
            mdatabase.child("Entries").child(vehivlnember).child("policyno").setValue(policynum);
            mdatabase.child("Entries").child(vehivlnember).child("password").setValue(pass);
            Intent intent=new Intent(SignUp.this,Parameterinfo.class);
            intent.putExtra("carnumber",vehivlnember);
            startActivity(intent);
        }
    }

    public void complaint(View view){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("carno",vehivlnember);
        startActivity(intent);

    }

}
