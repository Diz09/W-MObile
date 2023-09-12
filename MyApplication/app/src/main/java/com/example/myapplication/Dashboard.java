package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    private Button btn_linear;
    private Button btn_relative;
    private Button btn_constraint;
    private Button btn_frame;
    private Button btn_tabel;
    private Button btn_design;
    private Button btn_svertical;
    private Button btn_shorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        btn_linear = (Button) findViewById(R.id.f1);
        btn_linear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dashboard.this, Linear.class);
                startActivity(intent);
            }
        });

        btn_relative = (Button) findViewById(R.id.f2);
        btn_relative.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dashboard.this, Relative.class);
                startActivity(intent);            }
        });

        btn_constraint = (Button) findViewById(R.id.f3);
        btn_constraint.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dashboard.this, Constraint.class);
                startActivity(intent);            }
        });

        btn_frame = (Button) findViewById(R.id.f4);
        btn_frame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dashboard.this, FrameLayout.class);
                startActivity(intent);            }
        });
        btn_tabel = (Button) findViewById(R.id.f5);
        btn_tabel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dashboard.this, TableLayout.class);
                startActivity(intent);            }
        });

        btn_design = (Button) findViewById(R.id.f6);
        btn_design.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dashboard.this, MaterialDesign.class);
                startActivity(intent);
            }
        });

        btn_svertical = (Button) findViewById(R.id.f7);
        btn_svertical.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dashboard.this, ScrollVertikal.class);
                startActivity(intent);            }
        });

        btn_shorizontal = (Button) findViewById(R.id.f8);
        btn_shorizontal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dashboard.this, ScrollHorizontal.class);
                startActivity(intent);            }
        });
    }
}