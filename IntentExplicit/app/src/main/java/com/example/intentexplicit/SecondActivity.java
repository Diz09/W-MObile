package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity{
    TextView txt1, txt2;
    private String nama;
    private String KEY_NAME = "NAMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); //mendapatkan data layout dari activity_second
        //inisiasi txt1 dan txt2 berdasarkan id pada layout
        txt1 = findViewById(R.id.extView3);
        txt2 = findViewById(R.id.txtHello);
        //mengabil informasi tambahan(bundle) melalui intent
        Bundle extras = getIntent().getExtras();
        //mengatur kondisi jika extras tidak kosong (memiliki data)
        if (extras != null) {
            //nama mengambil dari string dari bundle extras yang disiapkan sebelumnya
            nama = extras.getString(KEY_NAME);
            /*
            konsidi jika nama berisi tulisan You maka akan mengatur
                txt2 menset text "then ''You are me"
                    juga mengatur size dari text tersebut menjadi 25 px
                txt1 akan diset kosong -> ""
             */
            if (nama != null && (nama.equalsIgnoreCase("You"))) {
                txt2.setText("then 'You' are 'Me'");
                txt2.setTextSize(25);
                txt1.setText("");
            //selain itu txt1 akan diset dengan data dari nama + " !"
            } else {
                txt1.setText(nama + " !");
            }
        }
    }
}
