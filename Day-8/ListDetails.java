package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDetails extends AppCompatActivity {
    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);
        iv=findViewById(R.id.iv1);
        tv=findViewById(R.id.tv1);
        Intent i=getIntent();
        int image=i.getIntExtra("image",R.drawable.apple);
        String name=i.getStringExtra("name");
        iv.setImageResource(image);
        tv.setText(name);


    }
}