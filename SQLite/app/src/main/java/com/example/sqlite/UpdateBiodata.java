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

public class UpdateBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text5;
    AutoCompleteTextView text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata); //mendapat pengaturan layout dari activity_update_biodata
        dbHelper = new DataHelper(this); // variabel untuk beriteraksi dengan database
        text1 = findViewById(R.id.editText1); //text1 merujuk pada id editText 1
        text2 = findViewById(R.id.editText2); //text2 merujuk pada id editText 2
        text3 = findViewById(R.id.editText3); //text3 merujuk pada id editText 3
        text4 = findViewById(R.id.editText4); //text4 merujuk pada id editText 4
        text5 = findViewById(R.id.editText5); //text5 merujuk pada id editText 5
        String[] gender = getResources().getStringArray(R.array.gender); //mendapat array-string gender yang dibuat pada strings.xml
        //adapter yang memasang genderAdapter dengan array gender dan mengatur nya dengan simple_dropdpwn_item_1line
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, gender);
        text4.setAdapter(genderAdapter); // mengatur genderAdapter pada text4
        SQLiteDatabase db = dbHelper.getReadableDatabase(); // membuka database untuk menulis
        //menjalankan perintah sql lalu mendapatkan data extra (string) dengan nilai "nama"
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        //cursor pindah ke posisi pertama
        cursor.moveToFirst();
        //pengkondisian untk mengaturletak dari cursor setelahnya akan mendapada data dari text (editText)
        //setelahnya data akan dikonfersi menjadi data string
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        ton1 = findViewById(R.id.button1); // ton1 merujuk pada id button 1
        ton2 = findViewById(R.id.button2); // ton2 merujuk pada id button 2
        //kondisi saat ton1 dipilih
        ton1.setOnClickListener((arg0) -> {
            SQLiteDatabase db1 = dbHelper.getWritableDatabase(); // membuka database untuk menulis
            //menjalankan perintah sql seperi dibawah (update data)
            db1.execSQL("UPDATE biodata SET nama = '" +
                    text2.getText().toString() + "', tgl = '" +
                    text3.getText().toString() + "', jk = '" +
                    text4.getText().toString() + "', alamat = '" +
                    text5.getText().toString() + "' WHERE no = '" +
                    text1.getText().toString() + "'");
            //ketika berhasil akan manampilkan pesan Toast "berhasil"
            Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_LONG).show();
            // memperbarui tampilan list pada MainActivity
            MainActivity.ma.RefreshList();
            //menutup aktifitas
            finish();
        });
        //ton2 berupa perintah kembali/gagal/tutup,
        // sehingga ketika diclick akan kembali keaktivitas sebelumnya
        ton2.setOnClickListener((arg0) -> {
            finish();
        });
    }
}
