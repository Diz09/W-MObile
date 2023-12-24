package com.example.autosearch;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private ListView listView;
    private ArrayAdapter<String> autoCompleteAdapter;
    private ArrayAdapter<String> listAdapter;
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ambil referensi ke AutoCompleteTextView dan ListView dari layout XML
        autoCompleteTextView = findViewById(R.id.autoComplete);
        listView = findViewById(R.id.listView);

        // Inisialisasi ArrayList untuk sumber data AutoCompleteTextView dan ListView
        dataList = new ArrayList<>();
        dataList.add("Apple");
        dataList.add("Apen");
        dataList.add("Banana");
        dataList.add("Buah Naga");
        dataList.add("Cherry");
        dataList.add("Date");
        dataList.add("Fig");
        dataList.add("Grape");

        // Buat ArrayAdapter untuk AutoCompleteTextView dan set tampilan kustom
        autoCompleteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, dataList);
        autoCompleteTextView.setAdapter(autoCompleteAdapter);

        // Buat ArrayAdapter untuk ListView dan set ke ListView
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(listAdapter);

        // Menambahkan TextWatcher ke AutoCompleteTextView untuk mengatur pemfilteran ListView
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //karena saat sebelum text berubah tidak ada apa-apa, maka bagian ini dikosongkan
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Saat teks di AutoCompleteTextView berubah, terapkan pemfilteran ke ListView
                listAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //karena saat sebelum text berubah tidak ada apa-apa, maka bagian ini dikosongkan
            }
        });

        //menambahkan click listener pada listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Mendapatkan teks dari item yang diklik
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Menampilkan pesan Toast dengan teks yang sesuai
                String toastMessage = "Mengambil " + selectedItem;
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}