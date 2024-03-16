package com.example.bikeinformation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    RecyclerView recyclerView;
    ArrayList<Bikes> bikesArrayList;
    MyAdapter myAdapter;
    String[] name;
    int[] imageResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        bikesArrayList= new ArrayList<Bikes>();

        myAdapter=new MyAdapter(this,bikesArrayList);
        recyclerView.setAdapter(myAdapter);

        name=new String[]{

                "Hero","Bajaj","Yamaha","Royal Enfield","Suzuki",
                "Jawa","Ducati","KTM"
        };
        imageResourceId=new int[]{
                R.drawable.hero,R.drawable.bajaj,
                R.drawable.yamaha,R.drawable.royalenfield,R.drawable.suzuki,
                R.drawable.jawa,R.drawable.ducati,R.drawable.ktm
        };

        getData();
        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(this,LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider1));
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    private void getData() {
        for(int i=0;i<name.length;i++){
            Bikes bikes=new Bikes(name[i],imageResourceId[i]);
            bikesArrayList.add(bikes);
        }
        myAdapter.notifyDataSetChanged();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem menuItem= menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search Here!");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}