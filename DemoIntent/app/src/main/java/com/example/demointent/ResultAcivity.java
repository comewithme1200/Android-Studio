package com.example.demointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultAcivity extends AppCompatActivity {
    TextView txtinputname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_acivity);
        txtinputname = (TextView)findViewById(R.id.txtinputname);
        //lấy intent
        Intent MyIntent = getIntent();
        //lấy ra gói bundle
        Bundle bundle = MyIntent.getBundleExtra("data");
        if (bundle != null)
        {
            String a = bundle.getString("name");
            int b = bundle.getInt("age");
            txtinputname.setText(a+" năm nay "+ b +" tuổi");
        }
        Button btnback = (Button)findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}