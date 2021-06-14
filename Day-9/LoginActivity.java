package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail,etPassword;
    Button btnLogin,btnSignup;

    public static final String main_key="my_pref";
    public static final String email_key="emailKey";
    public static final String password_key="passwordKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnSignup=findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail=etEmail.getText().toString();
                String userPassword=etPassword.getText().toString();

                SharedPreferences preferences=getSharedPreferences(main_key,MODE_PRIVATE);

                String userEmail1=preferences.getString(email_key,"");
                String userPassword1=preferences.getString(password_key,"");
                if (userEmail.equals(userEmail1) && userPassword.equals(userPassword1)){
                    Intent intent=new Intent(LoginActivity.this,DisplayActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid Login Details", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}