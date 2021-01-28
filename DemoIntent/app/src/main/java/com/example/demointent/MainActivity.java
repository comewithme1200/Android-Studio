package com.example.demointent;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Messenger;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameinput;
    Button btnsend;
    EditText ageput;
    int age;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameinput = (EditText) findViewById(R.id.nameput);
        ageput = (EditText) findViewById(R.id.ageput);
        btnsend = (Button) findViewById(R.id.sendbtn);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo intent
                Intent MyFintent = new Intent(MainActivity.this, ResultAcivity.class);
                //hoặc
                // Intent MyFintent = new Intent(getApplicationContext(), ResultActivity.class);
                //Lấy dữ liệu từ EditText
                Bundle Mybundle = new Bundle();
                try {
                    age = Integer.parseInt(ageput.getText().toString());
                    name = nameinput.getText().toString();
                } catch (Exception e) {

                }
                //đưa vào bundle
                Mybundle.putInt("age", age);
                Mybundle.putString("name", name);
                //đưa bundle vào intent
                MyFintent.putExtra("data", Mybundle);
                startActivity(MyFintent);


            }
        });

    }
}