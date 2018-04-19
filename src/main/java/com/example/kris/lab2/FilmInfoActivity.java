package com.example.kris.lab2;

import android.content.Context;
import android.content.Intent;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class FilmInfoActivity extends AppCompatActivity {
    public final static String MESSAGE_FILM="film";
    private Film myFilm;
    private TextView tFilmName, tFilmCategory;
    private ImageButton iFilmImageButton;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private PersonListFragment personListFragment;
    private FilmScreensFragment filmScreensFragment;
    private SingletonFilmInfoActivity singletonFilmInfoActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public static void start(Context context, Film film) {
        Intent starter = new Intent(context, FilmInfoActivity.class);
        starter.putExtra(MESSAGE_FILM, film);
        context.startActivity(starter);
    }

    private void init(){
        setContentView(R.layout.activity_film_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        singletonFilmInfoActivity = SingletonFilmInfoActivity.getInstance();

        Intent intent = getIntent();
        myFilm = (Film)intent.getSerializableExtra(MESSAGE_FILM);

        tFilmName = findViewById(R.id.textViewFilmName);
        tFilmCategory = findViewById(R.id.textViewFilmCategory);
        iFilmImageButton = findViewById(R.id.imageButtonFilm);

        setValues();
        initFragments();
        runListeners();
    }
    private void setValues(){
        if(myFilm != null){
            tFilmName.setText(myFilm.getFilmName());
            tFilmCategory.setText(myFilm.getFilmCategory());
            iFilmImageButton.setImageResource(myFilm.getImageRes());
        }
    }

    private void initFragments() {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        personListFragment = PersonListFragment.newInstance(myFilm.getActors());
        filmScreensFragment = FilmScreensFragment.newInstance(myFilm.getFilmScreens());

        if (singletonFilmInfoActivity.getFragmentType() == true)
            fragmentTransaction.replace(R.id.filmInfoFragmentContainer, personListFragment);
        else
            fragmentTransaction.replace(R.id.filmInfoFragmentContainer, filmScreensFragment);
        fragmentTransaction.commit();
    }

    private void runListeners(){
        iFilmImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                changeFragment();
            }
        });
    }

    private void changeFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        if(singletonFilmInfoActivity.getFragmentType()){
            fragmentTransaction.replace(R.id.filmInfoFragmentContainer,filmScreensFragment);
        } else {
            fragmentTransaction.replace(R.id.filmInfoFragmentContainer, personListFragment);
        }
        fragmentTransaction.commit();
        singletonFilmInfoActivity.changeFragmentType();
    }
}
