package com.example.mobile_4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyleview);

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        adapter = new MahasiswaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    void addData() {
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa ("Farhan Ariyanto", "E41221598", "123456789"));
        mahasiswaArrayList.add(new Mahasiswa ("Audrey", "E41221632", "987654321"));
        mahasiswaArrayList.add(new Mahasiswa ("Maulana", "E41221639", "987648765"));
        mahasiswaArrayList.add(new Mahasiswa ("Nico Flassy", "E41221712", "898758124"));
        mahasiswaArrayList.add(new Mahasiswa ("Restu", "E41221735", "987654321"));
        mahasiswaArrayList.add(new Mahasiswa ("hafidz", "E41221749", "987654321"));
        mahasiswaArrayList.add(new Mahasiswa ("Dimas", "E41221754", "987654321"));
        mahasiswaArrayList.add(new Mahasiswa ("Bagas", "E41221778", "987654321"));
        mahasiswaArrayList.add(new Mahasiswa ("David", "E41221857", "987654321"));
        mahasiswaArrayList.add(new Mahasiswa ("Gilang", "E41221877", "987654321"));
    }
}
