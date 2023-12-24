package com.example.recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.mobile_4.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Panggil metode addData() untuk menambahkan data ke ArrayList mahasiswaArrayList
        addData();

        // Inisialisasi RecyclerView dari tampilan XML
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Inisialisasi adapter dan berikan ArrayList mahasiswaArrayList sebagai data
        adapter = new Adapter(mahasiswaArrayList);

        // Buat dan atur LayoutManager untuk RecyclerView sebagai LinearLayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        // Set adapter ke RecyclerView
        recyclerView.setAdapter(adapter);
    }

    // Metode untuk menambahkan data ke ArrayList mahasiswaArrayList
    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("David","E41221857", "12342364760"));
        mahasiswaArrayList.add(new Mahasiswa("Ranggi Kai","E76521632", "1239877890"));
        mahasiswaArrayList.add(new Mahasiswa("Aiman","E41221613", "1234567890"));
        mahasiswaArrayList.add(new Mahasiswa("Fahma Khoiri","E41221456", "1234567890"));
        mahasiswaArrayList.add(new Mahasiswa("Adi Hendra","E41221279", "1234567890"));
        return;
    }
}