package com.example.nyoba_login;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.emaillogin1);
        editTextPassword = findViewById(R.id.password1);
        btnLogin = findViewById(R.id.buttonlogin1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                new LoginTask().execute(email, password);
            }
        });
    }

    private class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String email = params[0];
            String password = params[1];

            try {
                URL url = new URL("http://localhost/a/project/API/api_users.php?action=login");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setDoOutput(true);

                Map<String, String> postData = new HashMap<>();
                postData.put("user_email", email);
                postData.put("user_password", password);

                StringBuilder postDataString = new StringBuilder();
                for (Map.Entry<String, String> entry : postData.entrySet()) {
                    if (postDataString.length() != 0) {
                        postDataString.append('&');
                    }
                    postDataString.append(entry.getKey()).append('=').append(entry.getValue());
                }

                try (OutputStream os = connection.getOutputStream()) {
                    byte[] postDataBytes = postDataString.toString().getBytes("UTF-8");
                    os.write(postDataBytes);
                }

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    in.close();

                    return response.toString();
                } else {
                    return "Error: " + responseCode;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject jsonResponse = new JSONObject(result);
                int code = jsonResponse.getInt("code");

                if (code == 200) {
                    // Login sukses
                    JSONObject data = jsonResponse.getJSONObject("data");
                    // Handle data sesuai kebutuhan

                    // Contoh: Mendapatkan ID pengguna
                    int userId = data.getInt("user_id");

                    // Lanjutkan ke halaman index1 atau lakukan tindakan lain
                } else {
                    // Login gagal
                    // Handle pesan kesalahan atau tindakan lain sesuai kebutuhan
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
