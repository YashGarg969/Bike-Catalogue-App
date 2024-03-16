package com.example.bikeinformation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {
    static Context context;
    ArrayList<Bikes> bikesArrayList;
    ArrayList<Bikes> bikesArrayListFull;

    public MyAdapter(Context context, ArrayList<Bikes> bikesArrayList) {
        this.context = context;
        this.bikesArrayListFull = bikesArrayList;
        this.bikesArrayList=new ArrayList<>(bikesArrayListFull);
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
         Bikes bikes= bikesArrayList.get(position);
         holder.name.setText(bikes.name);
         holder.titleImage.setImageResource(bikes.titleImage);

    }

    @Override
    public int getItemCount() {
        return bikesArrayList.size();
    }

    @Override
    public Filter getFilter() {
        return bikefilter;
    }
    private final Filter bikefilter= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Bikes> filteredBikes= new ArrayList<>();
            if(constraint==null||constraint.length()==0){
                filteredBikes.addAll(bikesArrayListFull);
            }
            else{
                String filterpattern= constraint.toString().toLowerCase().trim();
                for(Bikes bikes:bikesArrayListFull){
                    if(bikes.name.toLowerCase().contains(filterpattern)){
                        filteredBikes.add(bikes);
                    }
                }
            }
            FilterResults results= new FilterResults();
            results.values=filteredBikes;
            results.count=filteredBikes.size();
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            bikesArrayList.clear();
            bikesArrayList.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };

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
                            Intent intent = new Intent(context,Hero_Bikes.class);
                            context.startActivity(intent);
                            break;


                        case 1:
                            Intent intent1=new Intent(context,bajaj_bikes_list.class);
                            context.startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2=new Intent(context,Yamaha_bikes_list.class);
                            context.startActivity(intent2);
                            break;
                        case 3:
                            Intent intent3=new Intent(context,Royal_bikes_list.class);
                            context.startActivity(intent3);
                            break;
                        case 4:
                            Intent intent4=new Intent(context,Suzuki_bikes_list.class);
                            context.startActivity(intent4);
                            break;
                        case 5:
                            Intent intent5=new Intent(context,Jawa_bikes_list.class);
                            context.startActivity(intent5);
                            break;
                        case 6:
                            Intent intent6=new Intent(context,Ducati_bikes_list.class);
                            context.startActivity(intent6);
                            break;
                        case 7:
                            Intent intent7=new Intent(context,Ktm_bikes_list.class);
                            context.startActivity(intent7);
                            break;
                    }

                }
            });
        }
    }
}
