package com.example.intent_implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Deklarasi variabel
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = editText.getText().toString();

                // Pastikan "http://" ada dalam teks yang dimasukkan oleh pengguna
                if (!enteredText.startsWith("http://") && !enteredText.startsWith("https://")) {
                    enteredText = "http://" + enteredText;
                }

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(enteredText));
                startActivity(intent);
            }
        });
    }
}