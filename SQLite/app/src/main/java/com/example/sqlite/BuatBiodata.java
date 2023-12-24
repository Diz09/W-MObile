package com.example.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BuatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text5;
    AutoCompleteTextView text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata); //mendapat data layout activity_buat_biodata
        dbHelper = new DataHelper(this); // variabel untuk beriteraksi dengan database
        text1 = findViewById(R.id.editText1); //text1 merujuk pada id editText1
        text2 = findViewById(R.id.editText2); //text2 merujuk pada id editText2
        text3 = findViewById(R.id.editText3); //text3 merujuk pada id editText3
        text4 = findViewById(R.id.editText4); //text4 merujuk pada id editText4
        text5 = findViewById(R.id.editText5); //text5 merujuk pada id editText5
        String[] gender = getResources().getStringArray(R.array.gender); //mendapat array-string gender yang dibuat pada strings.xml
        //adapter yang memasang genderAdapter dengan array gender dan mengatur nya dengan simple_dropdpwn_item_1line
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, gender);
        text4.setAdapter(genderAdapter); // mengatur genderAdapter pada text4
        ton1 = findViewById(R.id.button1); //ton1 merujuk pada id button1
        ton2 = findViewById(R.id.button2); //ton2 merujuk pada id button2
        //mengatur keadaan saat ton1 di click
        ton1.setOnClickListener((arg0) -> {
            // membuka database untuk menulis
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            //menjalankan pentah sql seperti yang dilihat
            db.execSQL("INSERT INTO biodata(no, nama, tgl, jk, alamat) VALUES('"+
                    text1.getText().toString() + "','" +
                    text2.getText().toString() + "','" +
                    text3.getText().toString() + "','" +
                    text4.getText().toString() + "','" +
                    text5.getText().toString() + "')");
            //jika berhasil akan menampilkan pesan Toast "Berhasil"
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
            // memperbarui tampilan list pada MainActivity
            MainActivity.ma.RefreshList();
            //selesai
            finish();
        });
        //ton2 berupa perintah kembali/gagal/tutup,
        // sehingga ketika diclick akan kembali keaktivitas sebelumnya
        ton2.setOnClickListener((arg0) -> {
            finish();
        });
    }
}
