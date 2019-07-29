package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import com.destiny.aplikasiebn.Adapter.AdapterBatik;
import com.destiny.aplikasiebn.Adapter.AdapterCara;
import com.destiny.aplikasiebn.Model.CaraModel;
import com.destiny.aplikasiebn.Model.DataModel;
import com.destiny.aplikasiebn.Model.Model;
import com.destiny.aplikasiebn.R;

import java.util.ArrayList;

public class ListCaraBatikActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    ImageView kembali;
    private ArrayList<Model> pList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cara_batik);
        rvCategory = (RecyclerView)findViewById(R.id.recycler);
        kembali = (ImageView)findViewById(R.id.ivKembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListCaraBatikActivity.super.onBackPressed();
            }
        });
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        pList.addAll(CaraModel.getListData());
        AdapterCara cardViewAdapter = new AdapterCara(this);
        cardViewAdapter.setListCara(pList);
        rvCategory.setAdapter(cardViewAdapter);
    }
}
