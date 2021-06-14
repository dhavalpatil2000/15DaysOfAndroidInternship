package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    int[] image={R.drawable.apple,R.drawable.banana,R.drawable.berries,R.drawable.grapes};
    String[] name={"This is Apple","This is Banana","This is Berries","This is Grapes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1=findViewById(R.id.lv1);
        MyAdapter adapter=new MyAdapter(MainActivity.this,image,name);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,ListDetails.class);
                intent.putExtra("image",image[i]);
                intent.putExtra("name",name[i]);
                startActivity(intent);
            }
        });

    }
}