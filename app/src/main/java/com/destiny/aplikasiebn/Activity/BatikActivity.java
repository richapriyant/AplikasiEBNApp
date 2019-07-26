package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import com.destiny.aplikasiebn.Adapter.AdapterBatik;
import com.destiny.aplikasiebn.Model.DataModel;
import com.destiny.aplikasiebn.Model.Model;
import com.destiny.aplikasiebn.R;

import java.util.ArrayList;

public class BatikActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    ImageView search;
    AutoCompleteTextView SearchLagu;
    ImageView kembali;
    private ArrayList<Model> pList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batik);
        rvCategory = (RecyclerView)findViewById(R.id.recycler);
        SearchLagu = (AutoCompleteTextView)findViewById(R.id.etSearchLagu);
        search = (ImageView)findViewById(R.id.ivSearch);
        kembali = (ImageView)findViewById(R.id.ivKembali);

        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        pList.addAll(DataModel.getListData());
        AdapterBatik cardViewAdapter = new AdapterBatik(this);
        cardViewAdapter.setListBatik(pList);
        rvCategory.setAdapter(cardViewAdapter);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BatikActivity.super.onBackPressed();
            }
        });
    }
}
