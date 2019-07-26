package com.destiny.aplikasiebn.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.destiny.aplikasiebn.Activity.DetailActivity;
import com.destiny.aplikasiebn.Model.Model;
import com.destiny.aplikasiebn.R;
import com.destiny.aplikasiebn.SharedPreferance.DB_Helper;

import java.util.ArrayList;

public class AdapterBatik extends RecyclerView.Adapter<AdapterBatik.CardViewViewHolder>{
    private Context context;
    private ArrayList<Model> listBatik;


    private ArrayList<Model> getListBatik() {
        return listBatik;
    }
    public void setListBatik(ArrayList<Model> listBatik) {
        this.listBatik= listBatik;
    }
    public AdapterBatik(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_batik, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder cardViewViewHolder, int i) {
        final Model p = getListBatik().get(i);
        cardViewViewHolder.nama.setText(p.getNama());
        Glide.with(context)
                .load(p.getGambar())
                .into(cardViewViewHolder.gambar);
        cardViewViewHolder.list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goInput = new Intent(context, DetailActivity.class);
                goInput.putExtra("GAMBAR",p.getGambar());
                goInput.putExtra("NAMA",p.getNama());
                goInput.putExtra( "DESKRIPSI",p.getDeskripsi());
                context.startActivities(new Intent[]{goInput});
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListBatik().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder{
        TextView nama;
        LinearLayout list;
        ImageView gambar;
        CardViewViewHolder(View itemView) {
            super(itemView);
            list = itemView.findViewById(R.id.List);
            nama = itemView.findViewById(R.id.tvNama);
            gambar = itemView.findViewById(R.id.ivBatik);
        }
    }
}
