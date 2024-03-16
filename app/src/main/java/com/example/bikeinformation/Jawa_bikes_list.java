package com.example.bikeinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Jawa_bikes_list extends AppCompatActivity {
    RecyclerView recyclerView1;
    ArrayList<Bikes> bikesArrayList;
    JawaAdapter jawaAdapter;
    String[] name;
    int[] imageResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jawa_bikes_list);

        recyclerView1=findViewById(R.id.recylerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);

        bikesArrayList= new ArrayList<Bikes>();

       jawaAdapter=new JawaAdapter(this,bikesArrayList);
        recyclerView1.setAdapter(jawaAdapter);

        name=new String[]{

               "Jawa 42","Jawa Perak"

        };
        imageResourceId=new int[]{
                R.drawable.jawa42, R.drawable.perak
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
        jawaAdapter.notifyDataSetChanged();
    }
}