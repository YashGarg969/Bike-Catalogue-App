package com.example.bikeinformation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class SuzukiAdapter extends RecyclerView.Adapter<SuzukiAdapter.MyViewHolder> {
    static Context context;
    ArrayList<Bikes> bikesArrayList;

    public SuzukiAdapter(Context context, ArrayList<Bikes> bikesArrayList) {
        this.context = context;
        this.bikesArrayList = bikesArrayList;
    }

    @NonNull
    @Override
    public SuzukiAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);

        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull SuzukiAdapter.MyViewHolder holder, int position) {
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (getAdapterPosition()) {
                        case 0:
                            Intent intent = new Intent(context, hayabusa.class);
                            context.startActivity(intent);
                            break;

                        case 1:
                            Intent intent1 = new Intent(context, gixxersf.class);
                            context.startActivity(intent1);
                            break;

                        case 2:
                            Intent intent2 = new Intent(context, intruder.class);
                            context.startActivity(intent2);
                            break;

                        case 3:
                            Intent intent3 = new Intent(context, rmz250.class);
                            context.startActivity(intent3);
                            break;

                    }    }

            });
        }
    }
}
