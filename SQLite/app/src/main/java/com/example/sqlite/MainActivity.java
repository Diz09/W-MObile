package com.example.sqlite;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
public class MainActivity extends AppCompatActivity {
    String[] daftar;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static  MainActivity ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //mendapat data layout activity_main
        Button btn = findViewById(R.id.button2); //men-set btn dengan id button2
        //keadaan saat btn ditekan
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //membuat Intent inte dengan MainActivity sebagai conten
                // dan BuatBiodata sebagai class yang dijalankan
                Intent inte = new Intent(MainActivity.this, BuatBiodata.class);
                startActivity(inte);
            }
        });
        ma = this;
        //dbcenter berupa variable yang merujuk pada DataHelper untuk berinteraksi dengan database
        dbcenter = new DataHelper(this);
        //memperbarui tampilan list data
        RefreshList();
    }
    public void RefreshList() {
        //mendapat data yang dapat dibaca dari database (dbcenter)
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        //eksekusi queri untuk menampilkan semua data dari biodata dan disimpan pada cursor
        cursor = db.rawQuery("SELECT * FROM biodata", null);
        //membuat array daftar untuk menyimpan data yang diambil dari database
        daftar = new String[cursor.getCount()];
        //memindahkan cursor ke posisi/baris pertama dalam queri data base
        cursor.moveToFirst();
        //perulangan for untuk menyimpan data dari setiap baris queri lalu menyimpannya dalam array daftar
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListView01 = findViewById(R.id.listView1); //men-set ListView01 dengan id listview1
        //mengatur adapter untuk mengatur ArrayAdapter dengan daftar dan menampilkannya secara simple_list_item_1
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        //membuat ListView01 dapat dipilih
        ListView01.setSelected(true);
        //method untuk mengatur keadaan saat ListView01 dipilih
        ListView01.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //mengatur index yang diklik pada list
                final String selection = daftar[arg2];
                //memnampilkan opsi saat list dipilih
                final CharSequence[] dialogitem = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};
                //pembuatan objek AlertDialog.Builder yang digunakan untuk membuat dialog.
                // yang akan dipakai dalam pengkondisian opsi
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //mengatur judul dari opsi yang ditampilkan
                builder.setTitle("Pilihat");
                //pengaturan saat salah satu opsi dipilih
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        //pengkondisian switch - case
                        switch (item) {
                            /*
                            case 0 (Lihat Biodata)
                                akan memulai aktivitas pada LihatBiodata (berpindah ke class LihatBiodata)
                                akan mengirim extras "nama" berdasarkan index yang dipilih (selection)
                                intent diluncurkan
                             */
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), LihatBiodata.class);
                                i.putExtra("nama", selection);
                                startActivity(i);
                                break;
                            /*
                            case 1 (Update Biodata)
                                akan memulai aktivitas pada UpdateBiodata (berpindah ke class UpdateBiodata)
                                akan mengirim extras "nama" berdasarkan index yang dipilih (selection)
                                intent diluncurkan
                             */
                            case 1 :
                                Intent in = new Intent(getApplicationContext(), UpdateBiodata.class);
                                in.putExtra("nama", selection);
                                startActivity(in);
                                break;
                            /*
                            case 2 (Hapus Biodata)
                                akan memulai aktivitas pada HapusBiodata (berpindah ke class HapusBiodata)
                                akan mengirim extras "nama" berdasarkan index yang dipilih (selection)
                                intent diluncurkan
                             */
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("DELETE FROM biodata WHERE nama = '" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show(); //metode untuk membuat dan menampilkan dialog yang telah dikonfigurasi.
            }
        });
        //memberi tahu adapter bahwa data dalam ListView01 telah berubah
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}