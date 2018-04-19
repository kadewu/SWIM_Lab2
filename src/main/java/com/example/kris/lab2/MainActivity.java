package com.example.kris.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FilmRecyclerViewAdapter myAdapter;
    private ArrayList<Film> films;
    private SingletonMainActivity singletonMainActivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void onStop(){
        super.onStop();
        singletonMainActivity.setFilms(films);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void init(){
        setContentView(R.layout.activity_main);
        singletonMainActivity = SingletonMainActivity.getInstance();

        recyclerView = findViewById(R.id.film_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(singletonMainActivity.getFilms() == null) {
            HardcodeData hardcodeData = new HardcodeData();
            films = hardcodeData.getFilms();
        } else {
            films = singletonMainActivity.getFilms();
        }

        recyclerView.setAdapter(myAdapter = new FilmRecyclerViewAdapter(films, R.layout.film_recycler_view));

        setItemTouchHelper();
    }

    private void setItemTouchHelper(){
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                if(direction == ItemTouchHelper.RIGHT) {
                    myAdapter.remove(position);
                }
            }

        };

        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
    }
}
