package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.destiny.aplikasiebn.Adapter.FavoritAdapter;
import com.destiny.aplikasiebn.Model.Model;
import com.destiny.aplikasiebn.R;
import com.destiny.aplikasiebn.SharedPreferance.DB_Helper;

import java.util.ArrayList;

public class FavoritActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Model> pList = new ArrayList<>();
    DB_Helper dbHelper;
    ImageView kembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);
        //Variable
        kembali = (ImageView)findViewById(R.id.ivKembali);
        rvCategory = (RecyclerView)findViewById(R.id.recycler);
        //Done


        dbHelper = new DB_Helper(FavoritActivity.this);
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        FavoritAdapter favoritAdapter = new FavoritAdapter(dbHelper.modelList(),FavoritActivity.this,rvCategory);
        rvCategory.setAdapter(favoritAdapter);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoritActivity.super.onBackPressed();
            }
        });
    }
}
