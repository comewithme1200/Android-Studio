package com.example.layoutconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvSinhvien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSinhvien = (ListView)findViewById(R.id.lvsinhvien);
        ArrayList<Sinhvien> arr = new ArrayList<>();
        arr.add(new Sinhvien("Nguyen Van A",2000));
        arr.add(new Sinhvien("Nguyen Thi B",1999));

        ListAdapter<Sinhvien> adapter = new ListAdapter<Sinhvien>(this,R.layout.activity_custom_view_s_v,arr);
        lvSinhvien.setAdapter(adapter);

    }
}