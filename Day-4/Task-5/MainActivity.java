package com.example.day4tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText etCpp,etOS,etCN,etDBMS,etCG;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCpp=findViewById(R.id.etCpp);
        etOS=findViewById(R.id.etOS);
        etCN=findViewById(R.id.etCN);
        etDBMS=findViewById(R.id.etDBMS);
        etCG=findViewById(R.id.etCG);
        b=findViewById(R.id.btnPercentage);
        tvResult=findViewById(R.id.tvResult);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a,b,c,d,e;
                a=Integer.parseInt(etCpp.getText().toString());
                b=Integer.parseInt(etOS.getText().toString());
                c=Integer.parseInt(etCN.getText().toString());
                d=Integer.parseInt(etDBMS.getText().toString());
                e=Integer.parseInt(etCG.getText().toString());
                int total=a+b+c+d+e;
                int avg=total/5;
                String result="You got "+avg+"%";
                tvResult.setText(result);
                String msg;
                int gr=avg;
                if(gr>=85 && gr<=100){
                    msg="AA Grade";
                }
                else if(gr>=75 && gr<=84){
                    msg="AB Grade";
                }
                else if(gr>=65 && gr<=74){
                    msg="BB Grade";
                }
                else if(gr>=55 && gr<=64){
                    msg="BC Grade";
                }
                else if(gr>=45 && gr<=54){
                    msg="CC Grade";
                }
                else if(gr>=40 && gr<=44){
                    msg="CD Grade";
                }
                else if(gr>=35 && gr<=39){
                    msg="DD Grade";
                }
                else {
                    msg="You are failed!";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

            }
        });
    }
}