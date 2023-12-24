package com.example.intentimplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //deklarasi
    Spinner spinner;
    EditText eT;
    ListView listView;
    ArrayList<String> sH;
    ArrayAdapter<String> adapter;
    ArrayAdapter<CharSequence> sA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisiasi
        spinner = findViewById(R.id.spinner);
        eT = findViewById(R.id.edit);
        listView = findViewById(R.id.list);

        //adapter listView untuk histori
        //sH disiapkan sebagai tempat penyimpanan dari list-array (lstView) yang dibuat
        sH = new ArrayList<>();
        //adapter diatur sebagai tampilan dari listView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sH);
        //men-set adapter yang dibuat sebelumnya kepada listView
        listView.setAdapter(adapter);

        //spinner adapter untuk mengambil data array dari v yang terletak di string
        sA = ArrayAdapter.createFromResource(this, R.array.v, android.R.layout.simple_spinner_item);
        sA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(sA);
        //method untuk mengatur keadaat dari spinner ketika dipilih
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //sO akan mengambil item dalam spinner dan data nya dari object menjadi string
                String sO = spinner.getSelectedItem().toString();
                //sET akan mengambil data editText dari eT lalu mengkonfersi
                //data tersebut menjadi string agar dapat digunakan
                String seT = eT.getText().toString();

                //mendeklarasikan url sebagai string untuk digunakan pada kode selanjutnya
                String url;
                /*
                mengatur kondisi sO
                - Jika yang dipilih adalah Google maka ia akan mengatur url
                    seperti yang disiapkan lalu diteruskan dengan dari dari seT (editText)
                        sehingga aplikasi akan langsung tertuju pada mesin pencarian google dan
                        mencari data yang dituliskan pada seT
                - Jika yang dipilih adalah WestManga maka ia akan mengatur url
                    seperti yang disiapkan lalu diteruskan dengan dari dari seT (editText)
                        sehingga aplikasi akan langsung tertuju pada mesin pencarian google dan
                        mencari data yang dituliskan pada seT
                - jika Visit yang dipilih maka akan dilanjutkan kondisi
                    - jika seT diawali dengan http:// atau https://, maka url akan langsung diset
                        seperti apa adanya dalam seT
                    - selain itu maka url akan mengawali pencarian dengan memberikan http:// lalu dilanjut
                        dengan data dalam seT
                 - selain itu juga terdapat default yang diisikan selain data diatas untuk mengatur kondisi normal
                 */
                switch (sO) {
                    case "Google":
                        url = "https://www.google.com/search?q=" + seT;
                        break;
                    case "WestManga":
                        url = "https://westmanga.info/?s=" + seT;
                        break;
                    case "Visit":
                        if (seT.startsWith("http://") || seT.startsWith("https://")) {
                            url = seT;
                        } else {
                            url = "http://" + seT;
                        }
                        break;
                    default:
                        return;
                }

                // setelah spinner dipilih maka data seT akan dimasukkan kedalam sH (listView)
                sH.add(seT);
                // dilanjut dengan memberitahu adapter bahwa data pada sH telah berubah
                // sehingga adapter dapat mengatur tata letak dari list view
                adapter.notifyDataSetChanged();
                // setelah itu spinner akan diatur kembali keposisi 0 (default) untuk menghindari masalah
                spinner.setSelection(0);

                /*
                setelah itu semmua, lalu intent akan disiapkan dengan konstanta ACTION_VIEW
                yang berarti intent digunakan untuk menampilkan sesuatu dan dalam kasus ini berupa uri,
                lalu data pada url akan dikonfert menjadi object uri
                 */
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                // intent dijalankan
                startActivity(intent);

                //setelah selesai maka eT akan diset menjadi kosong ""
                eT.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //tidak dipakai
            }
        });

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            //menyiapkan sS untuk menangkap letak dari sH (history) ketika salah satu item listView di click
            String sS = sH.get(position);
            //menset eT (editText) sesuai dengan sS (histori) yang dipilih
            eT.setText(sS);
            //inisiasi currentDate untuk menangkap fungsi method getCurrentDate
            String currentDate = getCurrentDate();
            //menampilkan pesan Toast + tanggal ketika item listView disentuh/click
            Toast.makeText(
                    MainActivity.this, "Disimpan pada  " + currentDate,
                    Toast.LENGTH_SHORT).show();
        });
    }
    //method untuk menyiapkan tanggal yang akan digunakan untuk mencari tahu kapan histori dibuat
    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }
}