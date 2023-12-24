package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//class yang merupakan turunandari SQLiteOpenHelper yang berfungsi untuk mengelola database sqlite
public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodatadiri.db"; //menyimpan nama database yang dipakai
    private static final int DATABASE_VERSION = 1; //menyimpan versi database
    //inisiasi database sqlite
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //membuat tabel dalam database dengan lima kolom (no, nama, tgl, jk, alamat)
        String sql = "create table biodata(no integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
        //mencatat pesan yang birisi text "onCreate" dan string SQL untuk membuat tabel
        Log.d("Data", "onCreate: " + sql);
        //menjalankan perintah sql
        db.execSQL(sql);
        //menyisipkan data pada tabel di database yang telah dibuat
        sql = "INSERT INTO biodata (no, nama, tgl, jk, alamat) values ('1', 'DIMAS', '2003-12-14', 'PEREMPUAN', 'JEPANG');";
        //menjalankan perintah sql
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {    } //mengugrade versi database jika berubah
}
