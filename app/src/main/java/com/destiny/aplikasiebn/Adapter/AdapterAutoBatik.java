package com.destiny.aplikasiebn.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.destiny.aplikasiebn.Model.Model;
import com.destiny.aplikasiebn.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterAutoBatik extends ArrayAdapter<Model> {
    private List<Model> dmListFull;

    public AdapterAutoBatik(@NonNull Context context, @NonNull List<Model> countryList) {
        super(context, 0, countryList);
        dmListFull = new ArrayList<>(countryList);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_auto_batik, parent, false
            );
        }

        TextView textViewBatik = convertView.findViewById(R.id.tvBatik);

        Model dm = getItem(position);

        if (dm != null) {
            textViewBatik.setText(dm.getNama());
        }

        return convertView;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<Model> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                suggestions.addAll(dmListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Model item : dmListFull) {
                    if (item.getNama().toLowerCase().contains(filterPattern)) {
                        suggestions.add(item);
                    }
                }
            }

            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((Model) resultValue).getNama();
        }
    };
}

