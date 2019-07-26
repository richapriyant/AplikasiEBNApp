package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.destiny.aplikasiebn.Model.Model;
import com.destiny.aplikasiebn.R;
import com.destiny.aplikasiebn.SharedPreferance.DB_Helper;

public class DetailActivity extends AppCompatActivity {
    ImageView Kembali,Favorit,Gambar;
    TextView Nama,Deskripsi;
    DB_Helper dbHelper;
    Dialog myDialog;
    boolean onClicked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent data = getIntent();
        //Constant

        final String GAMBAR = data.getStringExtra("GAMBAR");
        final String NAMA = data.getStringExtra("NAMA");
        final String DESKRIPSI = data.getStringExtra("DESKRIPSI");
        dbHelper = new DB_Helper(DetailActivity.this);
        Kembali=(ImageView)findViewById(R.id.ivBack);
        Favorit=(ImageView)findViewById(R.id.ivFavorit);
        Gambar=(ImageView)findViewById(R.id.ivGambar);
        Nama=(TextView)findViewById(R.id.tvNama);
        Deskripsi=(TextView)findViewById(R.id.tvDeskripsi);
        Nama.setText(NAMA);
        Deskripsi.setText(DESKRIPSI);
        Glide.with(DetailActivity.this)
                .load(GAMBAR)
                .into(Gambar);
        final Drawable DrawableHapus = getResources().getDrawable(R.drawable.unfavorite);
        final Drawable DrawableFav = getResources().getDrawable(R.drawable.favorit);
        Cursor cursors = dbHelper.checkBatik(NAMA);
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
                myDialog = new Dialog(DetailActivity.this);
                Cursor cursors = dbHelper.checkBatik(NAMA);
                if (cursors.getCount()>0){
                    while (cursors.moveToNext()){
                        ID = cursors.getString(0);
                    }
                }
                if (ID != null){
                    dbHelper.deleteBatikRecord(NAMA,DetailActivity.this);
                    myDialog.dismiss();
                    Favorit.setImageDrawable(DrawableFav);
                }else{
                    Favorit.setImageDrawable(DrawableHapus);
                    Toast.makeText(DetailActivity.this," Ditambahkan Ke Favorit",Toast.LENGTH_SHORT).show();
                    Model model = new Model(GAMBAR,
                            NAMA,
                            DESKRIPSI);
                    dbHelper.FavoriteBatik(model);
                }
            }
        });
        Kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailActivity.this.onBackPressed();
            }
        });
    }
}
