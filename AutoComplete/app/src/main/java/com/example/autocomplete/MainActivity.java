package com.example.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.autocomplete.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    android.widget.ListView listView;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        listView = (android.widget.ListView) findViewById(R.id.list1);
        adapter = ArrayAdapter.createFromResource(
                this, R.array.countries_arry, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,adapter.getItem(position),Toast.LENGTH_SHORT).show();
    }
}