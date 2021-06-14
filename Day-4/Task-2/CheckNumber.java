package com.example.day4tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CheckNumber extends AppCompatActivity {
    Button b;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_number);
        b=findViewById(R.id.btnCheckNo);
        et=findViewById(R.id.etNO);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n=Integer.parseInt(et.getText().toString());
                if(n==0){
                    Toast.makeText(CheckNumber.this,"Entered No. is 0",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(n>1){
                        Toast.makeText(CheckNumber.this,"Entered No. is positive",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(CheckNumber.this,"Entered No. is Negative",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}