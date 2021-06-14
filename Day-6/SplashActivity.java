package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    ImageView iv1;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        getSupportActionBar().hide();
        iv1=findViewById(R.id.iv1);

        AlphaAnimation animation=new AlphaAnimation(0,1);
        animation.setDuration(2500);
        iv1.startAnimation(animation);

        player=MediaPlayer.create(SplashActivity.this,R.raw.jack_sparrow);
        player.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.release();
    }
}