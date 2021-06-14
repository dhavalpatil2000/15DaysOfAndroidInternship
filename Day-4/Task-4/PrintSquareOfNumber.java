package com.example.day4tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrintSquareOfNumber extends AppCompatActivity {
    Button b;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_square_of_number);
        b=findViewById(R.id.btnCalculate);
        et1=findViewById(R.id.etNo);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n=Integer.parseInt(et1.getText().toString());
                if(n<10){
                    String s=Integer.toString(n*n);
                    Toast.makeText(PrintSquareOfNumber.this,s, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(PrintSquareOfNumber.this,"Number is >= 10", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}