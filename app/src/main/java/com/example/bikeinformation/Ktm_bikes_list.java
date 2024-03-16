package com.example.bikeinformation;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bikeinformation.Bikes;
import com.example.bikeinformation.HeroAdapter;
import com.example.bikeinformation.KtmAdapter;
import com.example.bikeinformation.R;

import java.util.ArrayList;

public class Ktm_bikes_list extends AppCompatActivity {
    RecyclerView recyclerView1;
    ArrayList<Bikes> bikesArrayList;
    KtmAdapter ktmAdapter;
    String[] name;
    int[] imageResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_bikes);

        recyclerView1=findViewById(R.id.recylerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);

        bikesArrayList= new ArrayList<Bikes>();

        ktmAdapter=new KtmAdapter(this,bikesArrayList);
        recyclerView1.setAdapter(ktmAdapter);

        name=new String[]{

                "RC 200","200 Duke","RC 390","125 Duke"

        };
        imageResourceId=new int[]{
                R.drawable.rc200, R.drawable.duke200,R.drawable.rc390,R.drawable.duke125,

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
        ktmAdapter.notifyDataSetChanged();
    }
}