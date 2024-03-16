package com.example.bikeinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bikeinformation.Bikes;
import com.example.bikeinformation.HeroAdapter;
import com.example.bikeinformation.R;

import java.util.ArrayList;

public class Ducati_bikes_list extends AppCompatActivity {
    RecyclerView recyclerView1;
    ArrayList<Bikes> bikesArrayList;
    DucatiAdapter ducatiAdapter;
    String[] name;
    int[] imageResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ducati_bikes_list);

        recyclerView1=findViewById(R.id.recylerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);

        bikesArrayList= new ArrayList<Bikes>();

        ducatiAdapter=new DucatiAdapter(this,bikesArrayList);
        recyclerView1.setAdapter(ducatiAdapter);

        name=new String[]{

                "Panigale V4","Scrambler 800","Panigale V2","Monster"

        };
        imageResourceId=new int[]{
                R.drawable.panigalev2, R.drawable.scrambler800,R.drawable.panigalev4,R.drawable.monster

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
        ducatiAdapter.notifyDataSetChanged();
    }
}