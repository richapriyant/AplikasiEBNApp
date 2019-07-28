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

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.destiny.aplikasiebn.Activity.DetailActivity;
import com.destiny.aplikasiebn.Model.Model;
import com.destiny.aplikasiebn.R;
import com.destiny.aplikasiebn.SharedPreferance.DB_Helper;

import java.util.List;

public class FavoritAdapter extends RecyclerView.Adapter<FavoritAdapter.ViewHolder> {
    private List<Model> mBatikList;
    private Context mContext;
    private RecyclerView mRecyclerV;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView nama;
        LinearLayout list;
        ImageView gambar;


        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;

            list=(LinearLayout)v.findViewById(R.id.List);
            nama=(TextView)v.findViewById(R.id.tvNama);
            gambar=(ImageView) v.findViewById(R.id.ivBatik);
        }
    }

    public void add(int position, Model models) {
        mBatikList.add(position, models);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mBatikList.remove(position);
        notifyItemRemoved(position);
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public FavoritAdapter(List<Model> myDataset, Context context, RecyclerView recyclerView) {
        mBatikList = myDataset;
        mContext = context;
        mRecyclerV = recyclerView;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FavoritAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.list_batik, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Model models = mBatikList.get(position);
        holder.nama.setText(models.getNama());
        Glide.with(mContext)
                .load(models.getGambar())
                .into(holder.gambar);
        holder.list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goInput = new Intent(mContext, DetailActivity.class);
                goInput.putExtra("GAMBAR",models.getGambar());
                goInput.putExtra("NAMA",models.getNama());
                goInput.putExtra( "DESKRIPSI",models.getDeskripsi());
                mContext.startActivities(new Intent[]{goInput});
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mBatikList.size();
    }

}
