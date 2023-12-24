package com.example.sqlnewdatebase;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    TextView showText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); //mendapatkan data layout activitymain2
        showText = findViewById(R.id.getText); //inisiasi showtext dengan id getText dari layout
        //tidak diatur clickListener karena telah di atur onClick pada setiap button di layout
    }
    //method yang akan berjalan saat button5 diclick ("back")
    //dan akan beralih menuju MainActivity/activity_main
    public void back(View view) {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
    //mendapatkan data yang tersimpan secara public
    public void getPublic(View view) {
        //mendapat direktori unduhan pada penyimpanan external (merujuk pada myData1.txt)
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        //pembuatan objek file yang merujuk pada folder
        File myFile = new File(folder, "myData1.txt");
        //string text memanggil method getData dengan file (myFile) sebagai acuan
        String text = getData(myFile);
        //kondisi jika isinya tidak kosong maka showText akan mendapatkan text tersebut lalu menampilkannya
        if (text != null) {
            showText.setText(text);
        //jika tidak maka showText akan menampilkan "No Data"
        } else {
            showText.setText("No Data");
        }
    }
    //mendapatkan data yang tersimpan secara private
    public void getPrivate(View view) {
        //mengakses direktori eksternal dengan "dimas" sebagai parameter
        File folder = getExternalFilesDir("dimas");
        //membuat objek file yang merujuk pada myData2.txt dalam direktori "dimas"
        //file yang dimaksud merupakan tempat penyimanan data sebelumnya
        File myFile = new File(folder, "myData2.txt");
        //string text memanggil method getData dengan file (myFile) sebagai acuan
        String text = getData(myFile);
        //kondisi jika text tidak kosong maka akan menampilkannya pada showText
        if (text != null) {
            showText.setText(text);
        //jika tidak maka showText akan menuliskan "No Data"
        } else {
            showText.setText("No Data");
        }
    }
    //method untuk mendapatkan data folder yang telah tersimpan
    private String getData(File myFile) {
        //deklarasi fileInputStream = null
        FileInputStream fileInputStream = null;
        try {
            //inisiasi FileInputStream dengan objek myFile
            fileInputStream = new FileInputStream(myFile);
            //deklarasi i = -1
            int i = -1;
            //deklarasi StringBuffer
            StringBuffer buffer = new StringBuffer();
            //pelulangan untuk membaca file bite per bite
            while ((i = fileInputStream.read()) != -1) {
                buffer.append((char) i);
            }
            //setelah selesai membaca file, data akan dikembalikan dalam bentuk string
            return buffer.toString();
        //menangkap kondisi lain/eror dan memunculkan pesan eror
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Error reading file: " + e.getMessage());
        //menutup method
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //setelah membaca jika berhasil data akan dikembalkan dalambentuk string
        //dan jika gagal maka akan menangkap kegegalan yang terjadi dan mengembalikkan nilai berupa null
        return null;
    }
}
