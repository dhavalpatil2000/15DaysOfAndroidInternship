package com.example.day_7tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewDemo extends AppCompatActivity {
    WebView webView;
    EditText et;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);
        webView=findViewById(R.id.wv1);
        et=findViewById(R.id.et1);
        b=findViewById(R.id.btnGo);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=et.getText().toString();
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new MyWebViewClient());
                webView.loadUrl(url);
            }
        });

    }
    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}