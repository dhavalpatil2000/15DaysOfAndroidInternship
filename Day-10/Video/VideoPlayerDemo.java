package com.example.useofintents;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoPlayerDemo extends AppCompatActivity {


    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_demo);

        videoView=findViewById(R.id.videoview);

        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);

        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.short_video);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        videoView.requestFocus();
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(VideoPlayerDemo.this, "Thank You!!!", Toast.LENGTH_SHORT).show();
            }
        });
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(VideoPlayerDemo.this, "Error", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}