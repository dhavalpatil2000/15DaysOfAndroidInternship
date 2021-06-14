package com.example.useofintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailHandler extends AppCompatActivity {

    EditText etTo,etsubject,etMsg;
    Button btnEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_handler);

        etTo=findViewById(R.id.etTo);
        etsubject=findViewById(R.id.etSubject);
        etMsg=findViewById(R.id.etMsg);
        btnEmail=findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=etTo.getText().toString();
                String subject=etsubject.getText().toString();
                String msg=etMsg.getText().toString();

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,msg);
                intent.setType("message/rfc822");
                startActivity(intent.createChooser(intent,"Send email :"));


            }
        });

    }
}