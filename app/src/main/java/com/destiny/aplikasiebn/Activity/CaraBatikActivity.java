package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.destiny.aplikasiebn.R;

public class CaraBatikActivity extends AppCompatActivity {
    ImageView kembali,gambar;
    TextView deskripsi,nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_batik);
        kembali=(ImageView)findViewById(R.id.ivKembali);
        Intent data = getIntent();
        final String GAMBAR = data.getStringExtra("GAMBAR");
        final String NAMA = data.getStringExtra("NAMA");
        final String DESKRIPSI = data.getStringExtra("DESKRIPSI");
        gambar=(ImageView)findViewById(R.id.ivGambar);
        nama=(TextView)findViewById(R.id.tvCara);
        deskripsi=(TextView)findViewById(R.id.tvDeskripsi);
        nama.setText(NAMA);
        deskripsi.setText(DESKRIPSI);
        Glide.with(CaraBatikActivity.this)
                .load(GAMBAR)
                .into(gambar);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CaraBatikActivity.super.onBackPressed();
            }
        });
    }
}
