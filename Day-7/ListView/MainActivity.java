package com.example.day_7tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*ListView lv1;*/
    GridView gv1;
    String[] data={"C","C++","Java","NodeJS","PHP","CSS","JavaScript","AngularJS","ReactJS","Android","Flutter","VueJS","Bootstrap","Swift","Kotlin","Tensorflow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv1=findViewById(R.id.gv1);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        gv1.setAdapter(adapter);
        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, data[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}