package com.example.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LihatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2;
    TextView text1, text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata); //mendapat data layout activity_lihat_biodata
        dbHelper = new DataHelper(this); // variabel untuk beriteraksi dengan database
        text1 = findViewById(R.id.textView1); //text1 merujuk pada id textView1
        text2 = findViewById(R.id.textView2); //text2 merujuk pada id textView2
        text3 = findViewById(R.id.textView3); //text3 merujuk pada id textView3
        text4 = findViewById(R.id.textView4); //text4 merujuk pada id textView4
        text5 = findViewById(R.id.textView5); //text5 merujuk pada id textView5
        SQLiteDatabase db = dbHelper.getReadableDatabase(); //membuka database untuk mebaca data
        //menjalankan perintah sql
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        //memindah cursor pada posisi/baris pertama
        cursor.moveToFirst();
        //kondisi untuk mengatur letak cursor lalu men-set text didalamnya
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        ton2 = findViewById(R.id.button1); // ton2 merujuk pada id button1
        //ton2 berupa perintah kembali/gagal/tutup,
        // sehingga ketika diclick akan kembali keaktivitas sebelumnya
        ton2.setOnClickListener((arg0) -> {
            finish();
        });
    }
}
