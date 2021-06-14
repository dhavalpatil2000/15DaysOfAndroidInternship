package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView name,email,contact;

    public static final String main_key="my_pref";
    public static final String name_key="nameKey";
    public static final String email_key="emailKey";
    public static final String contact_key="contactKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        name=findViewById(R.id.tvName);
        email=findViewById(R.id.tvEmail);
        contact=findViewById(R.id.tvContat);


        SharedPreferences preferences=getSharedPreferences(main_key,MODE_PRIVATE);

        String userEmail1=preferences.getString(email_key,"");
        String userName=preferences.getString(name_key,"");
        String userContact=preferences.getString(contact_key,"");

        name.setText("Name = "+userName);
        email.setText("Email = "+userEmail1);
        contact.setText("Contact = "+userContact);

    }
}