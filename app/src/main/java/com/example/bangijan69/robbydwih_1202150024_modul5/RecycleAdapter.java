package com.example.bangijan69.robbydwih_1202150024_modul5;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bangijan69 on 3/25/2018.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private List<DataModel> dataModels;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public RecycleAdapter(List<DataModel> moviesList) {
        this.dataModels = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataModel dataModel = dataModels.get(position);
        holder.title.setText(dataModel.getTodo());
        holder.genre.setText(dataModel.getDeskripsi());
        holder.year.setText(dataModel.getPioriy());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }
}
