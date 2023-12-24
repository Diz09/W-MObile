package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button btnSend;
    private String KEY_NAME = "NAMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //mendapatkan data layout dari activity_main
        //inisiasi data name dari id edt_nama dan btnSend dari id btn_send
        name = findViewById(R.id.edt_nama);
        btnSend = findViewById(R.id.btn_send);
        //mengatur keadaan saat btnSend di click
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //menyiapkan data string nama yang akan menangkap text dari data name
                    // lalu mengkonfersinya menjadi data string
                    String nama = name.getText().toString();
                    /*
                    kondisi jika nama tidak kosong maka
                        disiapakan Intent i dengan konstruktor pertama yaitu MainActivity sebagai context
                            dan konstruktor kedua yaitu SecondActivity sebagai class yang akan dijalankan
                        lalu Intent i akan menambahkan data extra dengan KEY_NAME sebagai key dan nama sebagai value
                        setelahnya i dijalankan
                    selain itu (jika nama kosong) akan memunculkan pesan Toast
                     */
                    if (!TextUtils.isEmpty(nama)) {
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplication(), "YOU NEED TO FILL YOUR NAME", Toast.LENGTH_SHORT).show();
                    }
                //kondisi untuk menangkap eror
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERROR, TRY AGAIN !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}