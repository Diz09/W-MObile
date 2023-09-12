package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Linear extends AppCompatActivity {
    EditText to, subject, message;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);

        to = findViewById(R.id.to);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);
    }
}