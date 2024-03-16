package com.example.bikeinformation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class HarleyAdapter extends RecyclerView.Adapter<HarleyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Bikes> bikesArrayList;

    public HarleyAdapter(Context context, ArrayList<Bikes> bikesArrayList) {
        this.context = context;
        this.bikesArrayList = bikesArrayList;
    }

    @NonNull
    @Override
    public HarleyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);

        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull HarleyAdapter.MyViewHolder holder, int position) {
        Bikes bikes= bikesArrayList.get(position);
        holder.name.setText(bikes.name);
        holder.titleImage.setImageResource(bikes.titleImage);

    }

    @Override
    public int getItemCount() {
        return bikesArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ShapeableImageView titleImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            titleImage=itemView.findViewById(R.id.title_image);
        }
    }
}
