package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.destiny.aplikasiebn.R;

public class HomeActivity extends AppCompatActivity {
    Button batik,cara,favorit,tentang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        batik=(Button)findViewById(R.id.btnBatik);
        cara=(Button)findViewById(R.id.btnCara);
        favorit=(Button)findViewById(R.id.btnFavorite);
        tentang=(Button)findViewById(R.id.btnTentang);
        batik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,BatikActivity.class);
                startActivity(intent);
            }
        });
    }
}
