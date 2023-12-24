package com.example.sqlnewdatebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //mendapat data layout activity_main
        editText = findViewById(R.id.editText2); //inisiasi editText dengan id editText2 dari layout
        //tidak diatur clickListener karena telah di atur onClick pada setiap button di layout
    }
    //method yang akan berjalan saat button4 diclick ("click to view")
    //dan akan beralih menuju Main2Activity/activity_main2
    public void next(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
    //method untuk menyimpan data di public
    public void savePublic(View view) {
        //deklarasi variabel untuk permintaan akses penyimpanan external
        int STORAGE_PERMISSION_CODE = 23;
        //meminta izin mengases penyimpanan eksternal
        ActivityCompat.requestPermissions(
                this,
                /*berisi izin yang diminta = READ_EXTERNAL_STROGE(membaca penyimpanan external)*/
                new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE },
                /*mengidentifikasi permintaan izin ketika hasilnya diterima*/
                STORAGE_PERMISSION_CODE);
        //info akan mengambil text yang ditulisakan pada editText lalu mengkonfersinya menjadi data string
        String info = editText.getText().toString();
        //mendapatkan direktori unduhan pada penyimpanan eksterna
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        //pembuatann object file (myData1.txt) dalam direktori unduhan
        //akan menjadi tempat untuk menyimpan data yang dituliskan akan disimpan
        File myFile = new File(folder, "myData1.txt");
        //memanggil method writeData untuk menuliskan data (info) kedalam file yang ditentukan (myFile)
        writeData(myFile, info);
        //merubah editText yang sebelumnya telah dituliskan sesuatu kembali menjadi kosong ""
        editText.setText("");
    }
    //method untuk menyimpan data pada private
    public void savePrivate(View view) {
        //mengambil text yang ditulisakn pada editText
        // lalu merubahnya menjadi data string dan disimpan pada string info
        String info = editText.getText().toString();
        //mendapatkan direktori external yang akan menyimpan file myData2.txt
        File folder = getExternalFilesDir("dimas");
        //membuat file object file letak akan disimpannya data yang dituliskan
        File myFile = new File(folder, "myData2.txt");
        //memanggil method writeData untuk menuliskan data (info) kedalam file yang ditentukan (myFile)
        writeData(myFile, info);
        //merubah editText yang sebelumnya telah dituliskan sesuatu kembali menjadi kosong ""
        editText.setText("");
    }
    //method untuk menuliskan data kepada file
    private void writeData(File myFile, String data) {
        //deklarasi awal fileOutputStream = null (kosong)
        FileOutputStream fileOutputStream = null;
        //kondisi try - catch - finally
        try {
            System.out.println("TES");
            // menginisiasi FileOutputStream dengan object myFile
            // untuk menyiapkan FileOutputStream untuk menuliskan data
            fileOutputStream = new FileOutputStream(myFile);
            //mengubah data menjadi bytes lalu ditulis dengan write
            fileOutputStream.write(data.getBytes());
            //menampilkan pesan done + letak penyimpanan file
            Toast.makeText(this, "Done" + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        //menangkap dan menangani pengucualian/eror/lainnya
        } catch (Exception e) {
            e.printStackTrace();
        //memastikan bahwa FileOutputStream ditutup setelah penulisan selesai
        } finally {
            //kondisi jika fileOutputStream tidak kosong
            if (fileOutputStream != null) {
                try {
                    //memastikan bahwa sumber daya sitem terikat dengan fileOutputStream menjadi bebas
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}