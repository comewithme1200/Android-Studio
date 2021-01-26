package com.example.listview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewSinhvien;
    private Spinner SpinnerSV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewSinhvien = (ListView)findViewById(R.id.listViewSV);
        SpinnerSV = (Spinner)findViewById(R.id.combobox1);

        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Nguyen Van A");
        arr.add("Nguyen Tuan B");
        arr.add("Nguyen Quang C");
        arr.add("Nguyen Thi D");



        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arr);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arr);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        listViewSinhvien.setAdapter(adapter);
        SpinnerSV.setAdapter(adapter1);
        listViewSinhvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,arr.get(position),Toast.LENGTH_LONG).show();
            }
        });
        /*
        listViewSinhvien.setOnItemClickListener((adapterView,view,position,l) -> {
            Toast.makeText(this, arr.get(position),Toast.LENGTH_LONG).show();
        });*/

    }


}