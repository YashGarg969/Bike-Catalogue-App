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

public class BajajAdapter extends RecyclerView.Adapter<BajajAdapter.MyViewHolder> {
    Context context;
    ArrayList<Bikes> bikesArrayList;

    public BajajAdapter(Context context, ArrayList<Bikes> bikesArrayList) {
        this.context = context;
        this.bikesArrayList = bikesArrayList;
    }

    @NonNull
    @Override
    public BajajAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);

        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull BajajAdapter.MyViewHolder holder, int position) {
        Bikes bikes= bikesArrayList.get(position);
        holder.name.setText(bikes.name);
        holder.titleImage.setImageResource(bikes.titleImage);

    }

    @Override
    public int getItemCount() {
        return bikesArrayList.size();
    }
    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ShapeableImageView titleImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            titleImage=itemView.findViewById(R.id.title_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(getAdapterPosition()){

                        case 0:
                            Intent intent= new Intent(context,pulsar150.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            Intent intent2= new Intent(context,ct100.class);
                            context.startActivity(intent2);
                            break;
                        case 2:
                            Intent intent3= new Intent(context,dominar.class);
                            context.startActivity(intent3);
                            break;
                        case 3:
                            Intent intent4= new Intent(context,platina100.class);
                            context.startActivity(intent4);
                            break;
                        case 4:
                            Intent intent5= new Intent(context,avenger.class);
                            context.startActivity(intent5);
                            break;
                    }
                }
            });
        }
    }
}
