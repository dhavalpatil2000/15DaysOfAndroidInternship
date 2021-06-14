package com.example.useofintents;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonStart,buttonStop,buttonPause;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart=findViewById(R.id.start);
        buttonStop=findViewById(R.id.stop);
        buttonPause=findViewById(R.id.pause);

        mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.jack_sparrow);
        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonPause.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.start:
                mediaPlayer.start();
                Toast.makeText(this, "Music Start!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stop:
                mediaPlayer.pause();
                Toast.makeText(this, "Music Stop!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pause:
                mediaPlayer.stop();
                Toast.makeText(this, "Music Pause!!!", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}