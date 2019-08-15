package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.destiny.aplikasiebn.Model.Model;
import com.destiny.aplikasiebn.R;
import com.destiny.aplikasiebn.SharedPreferance.DB_Helper;

public class CaraBatikActivity extends AppCompatActivity {
    ImageView kembali,gambar,Favorit;
    TextView deskripsi,nama;
    DB_Helper dbHelper;
    Dialog myDialog;
    boolean onClicked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_batik);
        Intent data = getIntent();
        final String NO = data.getStringExtra("NO");
        final String GAMBAR = data.getStringExtra("GAMBAR");
        final String NAMA = data.getStringExtra("NAMA");
        final String DESKRIPSI = data.getStringExtra("DESKRIPSI");
        kembali=(ImageView)findViewById(R.id.ivBack);
        gambar=(ImageView)findViewById(R.id.ivGambar);
        nama=(TextView)findViewById(R.id.tvNama);
        deskripsi=(TextView)findViewById(R.id.tvDeskripsi);
        Favorit=(ImageView)findViewById(R.id.ivFavorit);
        dbHelper = new DB_Helper(CaraBatikActivity.this);
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
        final Drawable DrawableHapus = getResources().getDrawable(R.drawable.binfav);
        final Drawable DrawableFav = getResources().getDrawable(R.drawable.favorit);
        Cursor cursors = dbHelper.checkCara(NAMA);
        String ID2 = null;
        if (cursors.getCount()>0){
            while (cursors.moveToNext()){
                ID2 = cursors.getString(0);
            }
        }
        if (ID2 != null){
            Favorit.setImageDrawable(DrawableHapus);
        }else if(ID2 == null){
            Favorit.setImageDrawable(DrawableFav);
        }
        Favorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = null;
                myDialog = new Dialog(CaraBatikActivity.this);
                Cursor cursors = dbHelper.checkCara(NAMA);
                if (cursors.getCount()>0){
                    while (cursors.moveToNext()){
                        ID = cursors.getString(0);
                    }
                }
                if (ID != null){
                    dbHelper.deleteCaraRecord(NAMA,CaraBatikActivity.this);
                    myDialog.dismiss();
                    Favorit.setImageDrawable(DrawableFav);
                }else{
                    Favorit.setImageDrawable(DrawableHapus);
                    Toast.makeText(CaraBatikActivity.this," Ditambahkan Ke Favorit",Toast.LENGTH_SHORT).show();
                    Model model = new Model("1",
                            GAMBAR,
                            NAMA,
                            DESKRIPSI);
                    dbHelper.FavoriteCara(model);
                }
            }
        });
    }
}
