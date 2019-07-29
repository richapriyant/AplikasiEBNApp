package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.destiny.aplikasiebn.R;

public class SukaActivity extends AppCompatActivity {
    ImageView kembali;
    LinearLayout Batik,Cara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suka);
        kembali=(ImageView)findViewById(R.id.ivKembali);
        Batik=(LinearLayout)findViewById(R.id.lineBatik);
        Cara=(LinearLayout)findViewById(R.id.lineCara);
        Batik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SukaActivity.this,FavoritActivity.class);
                startActivity(intent);
            }
        });
        Cara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SukaActivity.this,ListSukaCaraBatikActivity.class);
                startActivity(intent);
            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
