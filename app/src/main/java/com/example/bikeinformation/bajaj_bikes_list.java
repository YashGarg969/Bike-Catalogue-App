package com.example.bikeinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class bajaj_bikes_list extends AppCompatActivity {
    RecyclerView recyclerView1;
    ArrayList<Bikes> bikesArrayList;
    BajajAdapter bajajAdapter;
    String[] name;
    int[] imageResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajaj_bikes_list);

        recyclerView1=findViewById(R.id.recylerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);

        bikesArrayList= new ArrayList<Bikes>();

        bajajAdapter=new BajajAdapter(this,bikesArrayList);
        recyclerView1.setAdapter(bajajAdapter);

        name=new String[]{

                "Pulsar 150","CT 100","Dominar 400","Platina 100","Avenger"

        };
        imageResourceId=new int[]{
                R.drawable.pulsar, R.drawable.ct100,R.drawable.dominar,R.drawable.platina,
                R.drawable.avenger
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
        bajajAdapter.notifyDataSetChanged();
    }
}