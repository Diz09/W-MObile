package com.example.tugas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button f1Button;
    private Button f2Button;
    private Button f3Button;
    private Button f4Button;
    private Button f5Button;
    private Button f6Button;
    private Button f7Button;
    private Button f8Button;
    private TextView tanggalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanggalTextView = findViewById(R.id.textTanggal);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        String formattedDate = sdf.format(calendar.getTime());
        tanggalTextView.setText(formattedDate);

        f1Button = (Button) findViewById(R.id.f1);
        f1Button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                openActivity2();
            }
        });
        f2Button = (Button) findViewById(R.id.f2);
        f2Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openActivity3();
            }
        });
        f3Button = (Button) findViewById(R.id.f3);
        f3Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openActivity4();
            }
        });
        f4Button = (Button) findViewById(R.id.f4);
        f4Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openActivity5();
            }
        });
        f5Button = (Button) findViewById(R.id.f5);
        f5Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openActivity6();
            }
        });
        f6Button = (Button) findViewById(R.id.f6);
        f6Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openActivity7();
            }
        });
        f7Button = (Button) findViewById(R.id.f7);
        f7Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openActivity8();
            }
        });
        f8Button = (Button) findViewById(R.id.f8);
        f8Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openActivity9();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, LinearActivity.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this, RelativeActivity.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this, ConstraintActivity.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent = new Intent(this, FrameActivity.class);
        startActivity(intent);
    }
    public void openActivity6(){
        Intent intent = new Intent(this, TabelActivity.class);
        startActivity(intent);
    }
    public void openActivity7(){
        Intent intent = new Intent(this, MaterialDesignActivity.class);
        startActivity(intent);
    }
    public void openActivity8(){
        Intent intent = new Intent(this, ScrollViewActivity.class);
        startActivity(intent);
    }
    public void openActivity9(){
        Intent intent = new Intent(this, ScrollViewHorizontalActivity.class);
        startActivity(intent);
    }
}