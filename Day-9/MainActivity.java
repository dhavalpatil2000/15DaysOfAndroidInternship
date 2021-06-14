package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName,etEmail,etPassword,etMobile;
    Button btnRegister;

    public static final String main_key="my_pref";
    public static final String name_key="nameKey";
    public static final String email_key="emailKey";
    public static final String password_key="passwordKey";
    public static final String contact_key="contactKey";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etMobile=findViewById(R.id.etMobile);

        btnRegister=findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences(main_key,MODE_PRIVATE);

                String userName=etName.getText().toString();

                String userPassword =etPassword.getText().toString();
                String userEmail=etEmail.getText().toString();

                String userMobile= etMobile.getText().toString();

                SharedPreferences.Editor editor=preferences.edit();


                editor.putString(name_key, userName);
                editor.putString(email_key, userEmail);
                editor.putString (password_key, userPassword);
                editor.putString (contact_key, userMobile);
                editor.commit();

                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}