package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvSinhvien;
    EditText txtFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSinhvien = (ListView) findViewById(R.id.lvsinhvien);
        txtFilter = (EditText) findViewById(R.id.txtFilter);
        ArrayList<Sinhvien> arr = new ArrayList<>();
        arr.add(new Sinhvien("Cristiano Ronaldo", R.drawable.cr7));
        arr.add(new Sinhvien("Lionel Messi",R.drawable.m10));
        arr.add(new Sinhvien("Mohamad Sal", R.drawable.s11));
        CustomAdapter adapter = new CustomAdapter(this, arr);
        lvSinhvien.setAdapter(adapter);
        txtFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}