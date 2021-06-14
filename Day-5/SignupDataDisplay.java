package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SignupDataDisplay extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_data_display);
        tv=findViewById(R.id.tvDisplay);
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        tv.setText(tv.getText()+"\nName:"+name);
        String email=i.getStringExtra("email");
        tv.setText(tv.getText()+"\nEmail:"+email);
        String contact=i.getStringExtra("contact");
        tv.setText(tv.getText()+"\nContact:"+contact);
        String dob=i.getStringExtra("dob");
        tv.setText(tv.getText()+"\nDOB:"+dob);
        String gender=i.getStringExtra("gender");
        tv.setText(tv.getText()+"\nGender:"+gender);
        String city=i.getStringExtra("city");
        tv.setText(tv.getText()+"\nCity:"+city);


    }
}