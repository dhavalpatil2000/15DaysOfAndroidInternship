package com.example.day4tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    EditText et1,et2;
    Button btnAdd,btnSub,btnMul,btnDiv;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnMul=findViewById(R.id.btnMul);
        btnDiv=findViewById(R.id.btnDiv);
        tvResult=findViewById(R.id.tvResult);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                int a=Integer.parseInt(et1.getText().toString());
                int b=Integer.parseInt(et2.getText().toString());
                tvResult.setText((tvResult.getText().toString())+(a+b));
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                int a=Integer.parseInt(et1.getText().toString());
                int b=Integer.parseInt(et2.getText().toString());
                tvResult.setText((tvResult.getText().toString())+(a-b));
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                int a=Integer.parseInt(et1.getText().toString());
                int b=Integer.parseInt(et2.getText().toString());
                tvResult.setText((tvResult.getText().toString())+(a*b));
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                int a=Integer.parseInt(et1.getText().toString());
                int b=Integer.parseInt(et2.getText().toString());
                tvResult.setText((tvResult.getText().toString())+(a/b));
            }
        });

    }
}