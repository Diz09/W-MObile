package com.example.dropdown;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private String[] items;
    private Map<String, Integer> flagMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        // daftar item
        items = getResources().getStringArray(R.array.countryArray);

        // bendera
        flagMap = new HashMap<>();
        flagMap.put("America", R.drawable.amerika);
        flagMap.put("Argentina", R.drawable.argentina);
        flagMap.put("Australia", R.drawable.australia);
        flagMap.put("Brazil", R.drawable.brazil);
        flagMap.put("Canada", R.drawable.canada);
        flagMap.put("China", R.drawable.china);
        flagMap.put("Francis", R.drawable.francis);
        flagMap.put("German", R.drawable.german);
        flagMap.put("GreenLand", R.drawable.greenland);
        flagMap.put("India", R.drawable.india);
        flagMap.put("Indonesia", R.drawable.indonesia);
        flagMap.put("Italia", R.drawable.italia);
        flagMap.put("Jepang", R.drawable.jepang);
        flagMap.put("Korea", R.drawable.korea);
        flagMap.put("Mesir", R.drawable.mesir);
        flagMap.put("Mexico", R.drawable.mexico);
        flagMap.put("Russia", R.drawable.russia);
        flagMap.put("Swiss", R.drawable.swiss);
        flagMap.put("Ukraine", R.drawable.ukraine);
        // sesuaikan sesuai kebutuhan

        // Adapter untuk mengisi Spinner dengan item dari string-array
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        // Listener untuk menangani item yang dipilih
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = items[position];
                Toast.makeText(MainActivity.this,
                        "Anda memilih: " + selectedItem, Toast.LENGTH_SHORT).show();

                // Mengambil ID gambar bendera dari peta (Map) berdasarkan item yang dipilih
                Integer flagResourceId = flagMap.get(selectedItem);

                // Mengatur gambar bendera sesuai dengan item yang dipilih
                if (flagResourceId != null) {
                    ImageView flagImageView = findViewById(R.id.flagImageView);
                    flagImageView.setImageResource(flagResourceId);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Tidak melakukan apa-apa saat tidak ada item yang dipilih
            }
        });
    }
}
