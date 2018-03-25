package com.example.bangijan69.robbydwih_1202150024_modul5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by bangijan69 on 3/25/2018.
 */

public class ListAdapter extends  BaseAdapter{

    ArrayList <String> Todo;
    Context context;
    ArrayList<String> Deskripsi;
    ArrayList<String> piority;

    private static LayoutInflater inflater=null;
    public ListAdapter(MainActivity mainActivity, ArrayList Todo, ArrayList prgmImages,ArrayList piority) {
        // TODO Auto-generated constructor stub
        this.Todo =Todo;
        context=mainActivity;
        Deskripsi=prgmImages;
        this.piority=piority;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Todo.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView Todo_nama;
        TextView diskripsi_text;
        TextView piority;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.row_item, null);
        holder.Todo_nama =(TextView) rowView.findViewById(R.id.name);
        holder.piority=(TextView)rowView.findViewById(R.id.piority_list);
        holder.diskripsi_text =(TextView) rowView.findViewById(R.id.type);
        holder.Todo_nama.setText(Todo.get(position));
        holder.diskripsi_text.setText(Deskripsi.get(position));
        holder.piority.setText(piority.get(position));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+ Todo.get(position), Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }
}
