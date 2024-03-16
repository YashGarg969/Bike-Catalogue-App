package com.example.bikeinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Royal_bikes_list extends AppCompatActivity {
    RecyclerView recyclerView1;
    ArrayList<Bikes> bikesArrayList;
    RoyalAdapter royalAdapter;
    String[] name;
    int[] imageResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_royal_bikes_list);

        recyclerView1=findViewById(R.id.recylerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);

        bikesArrayList= new ArrayList<Bikes>();

        royalAdapter=new RoyalAdapter(this,bikesArrayList);
        recyclerView1.setAdapter(royalAdapter);

        name=new String[]{

               "Classic 350","Himalayan","Continental","Interceptor","Meteor"

        };
        imageResourceId=new int[]{
                R.drawable.classic350, R.drawable.himalayan,R.drawable.continental,R.drawable.interceptor,R.drawable.meteor

        };

        getData();
        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(this,LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider1));
        recyclerView1.addItemDecoration(dividerItemDecoration);

    }

    private void getData() {
        for(int i=0;i<name.length;i++){
            Bikes bikes=new Bikes(name[i],imageResourceId[i]);
            bikesArrayList.add(bikes);
        }
        royalAdapter.notifyDataSetChanged();
    }
}