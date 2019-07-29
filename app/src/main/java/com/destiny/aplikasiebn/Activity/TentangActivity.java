package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.destiny.aplikasiebn.R;

public class TentangActivity extends AppCompatActivity {
    ImageView kembali,play;
    boolean onClicked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        kembali=(ImageView) findViewById(R.id.ivKembali);
        play=(ImageView)findViewById(R.id.ivPlay);
        final MediaPlayer SuaraLagu = MediaPlayer.create(TentangActivity.this,R.raw.supriyadi);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TentangActivity.super.onBackPressed();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Drawable DrawableHapus = getResources().getDrawable(R.drawable.pause);
                final Drawable DrawablePlay = getResources().getDrawable(R.drawable.play);
                if (onClicked){
                    play.setImageDrawable(DrawableHapus);
                    onClicked=false;
                    SuaraLagu.start();
                }else{
                    play.setImageDrawable(DrawablePlay);
                    onClicked=true;
                    SuaraLagu.pause();
                }
            }
        });

    }
}
