package com.example.day4tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class CheckTwoNumber extends AppCompatActivity {
    EditText et1,et2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_two_number);
        b=findViewById(R.id.bt1);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(et1.getText().toString());
                int b=Integer.parseInt(et2.getText().toString());
                if(a==b){
                    Snackbar.make(view,"Entered Numbers are same",Snackbar.LENGTH_SHORT).show();
                }
                else if(a>b){
                    Snackbar.make(view,""+a+" is greater then "+b,Snackbar.LENGTH_SHORT).show();
                }
                else{
                    Snackbar.make(view,""+a+" is less then "+b,Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}