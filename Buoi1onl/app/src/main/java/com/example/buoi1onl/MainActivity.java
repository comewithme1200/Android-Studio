package com.example.buoi1onl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView image,image1,image2,image3;
    EditText txtname;
    EditText txtage;
    Spinner spinnerhome;
    Button sendbtn;
    int age;
    String name;
    String spinner;
    int id;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView)findViewById(R.id.imageF);
        txtname = (EditText)findViewById(R.id.txtname);
        txtage = (EditText)findViewById(R.id.txtage);
        spinnerhome = (Spinner)findViewById(R.id.spinnerhome);
        sendbtn = (Button)findViewById(R.id.Btnsend);
        image.setImageResource(R.drawable.profile);
        image1 = (ImageView)findViewById(R.id.imageView3);
        image2 = (ImageView)findViewById(R.id.imageView4);
        image3 = (ImageView)findViewById(R.id.imageView5);
        ArrayList<String> dsque = new ArrayList<>();
        dsque.add("Ha Noi");
        dsque.add("TPHCM");
        dsque.add("Hải Phòng");
        dsque.add("Đà Nẵng");
        dsque.add("Cần Thơ");
        final ArrayList<Integer> dsanh = new ArrayList<>();
        dsanh.add(R.drawable.profile1);
        dsanh.add(R.drawable.profile2);
        dsanh.add(R.drawable.profile3);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = dsanh.get(0);
                image.setImageResource(id);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = dsanh.get(1);
                image.setImageResource(id);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = dsanh.get(2);
                image.setImageResource(id);
            }
        });
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item,dsque);
        spinnerhome.setAdapter(adapter);
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo intent
                Intent MyFintent = new Intent(MainActivity.this, Scactivity.class);
                //hoặc
                // Intent MyFintent = new Intent(getApplicationContext(), ResultActivity.class);
                //Lấy dữ liệu từ EditText
                Bundle Mybundle = new Bundle();
                try {
                    age = Integer.parseInt(txtage.getText().toString());
                    name = txtname.getText().toString();
                    spinner = spinnerhome.getSelectedItem().toString();
                    id = id;
                } catch (Exception e) {

                }
                //đưa vào bundle
                Mybundle.putInt("age", age);
                Mybundle.putString("name", name);
                Mybundle.putString("home",spinner);
                Mybundle.putInt("image",id);

                //đưa bundle vào intent
                MyFintent.putExtra("data", Mybundle);
                startActivity(MyFintent);
            }
        });
    }
}
