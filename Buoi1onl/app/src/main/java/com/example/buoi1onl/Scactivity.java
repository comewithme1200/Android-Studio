package com.example.buoi1onl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Scactivity extends AppCompatActivity {
    TextView txtname,txtage,txthome;
    Button backbtn;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scactivity);
        txtname = (TextView)findViewById(R.id.txtnameS);
        txtage = (TextView)findViewById(R.id.txtageS);
        txthome  = (TextView)findViewById(R.id.txthome);
        image = (ImageView)findViewById(R.id.imageS);
        backbtn = (Button)findViewById(R.id.btnbacks);
        Intent Myintent = getIntent();
        Bundle bundle = Myintent.getBundleExtra("data");
        if (bundle != null)
        {
            String a = bundle.getString("name");
            int b = bundle.getInt("age");
            int c = bundle.getInt("image");
            String d = bundle.getString("home");
            txtname.setText(a);
            txtage.setText(b+"");
            image.setImageResource(c);
            txthome.setText(d);
        }
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}