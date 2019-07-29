package com.destiny.aplikasiebn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import com.destiny.aplikasiebn.Adapter.AdapterAutoBatik;
import com.destiny.aplikasiebn.Adapter.AdapterBatik;
import com.destiny.aplikasiebn.Model.DataModel;
import com.destiny.aplikasiebn.Model.Model;
import com.destiny.aplikasiebn.R;

import java.util.ArrayList;

public class BatikActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    ImageView search;
    AutoCompleteTextView Search;
    ImageView kembali;
    private ArrayList<Model> pList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batik);
        rvCategory = (RecyclerView)findViewById(R.id.recycler);
        Search = (AutoCompleteTextView)findViewById(R.id.etSearch);
        search = (ImageView)findViewById(R.id.ivSearch);
        kembali = (ImageView)findViewById(R.id.ivKembali);

        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        pList.addAll(DataModel.getListData());
        AdapterBatik cardViewAdapter = new AdapterBatik(this);
        AdapterAutoBatik auto = new AdapterAutoBatik(this,pList);
        cardViewAdapter.setListBatik(pList);
        Search.setAdapter(auto);
        rvCategory.setAdapter(cardViewAdapter);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BatikActivity.super.onBackPressed();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),pList.get(0).getJudul(),Toast.LENGTH_SHORT).show();
                for (int i=0; i <=pList.size()-1;i++){
                    if(pList.get(i).getNama().equals(Search.getText().toString())){
                        Intent goInput = new Intent(BatikActivity.this, DetailActivity.class);
                        goInput.putExtra("GAMBAR",pList.get(i).getGambar().toString());
                        goInput.putExtra("NAMA",pList.get(i).getNama().toString());
                        goInput.putExtra( "DESKRIPSI",pList.get(i).getDeskripsi().toString());
                        BatikActivity.this.startActivities(new Intent[]{goInput});
                    }
                }
            }
        });
    }
}
