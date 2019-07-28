package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;

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
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TentangActivity.super.onBackPressed();
            }
        });
    }
}
