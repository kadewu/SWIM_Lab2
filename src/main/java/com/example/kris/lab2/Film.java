package com.example.kris.lab2;

import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable {
    private int imageRes;
    private String name, category;
    private ArrayList<Person> actors;
    private int[] filmScreens;
    public static int NUMBER_OF_SCREENS = 6;
    public Film(int imageRes, String name, String category){
        this(imageRes, name, category, null);
    }
    public Film(int imageRes, String name, String category, Person[] actors){
        this.imageRes = imageRes;
        this.name = name;
        this.category = category;
        this.actors = new ArrayList<>();
        if(actors != null){
            for(int i=0; i<actors.length; i++) this.actors.add(actors[i]);
        }
        filmScreens = null;
    }
    public int getImageRes(){
        return imageRes;
    }
    public String getFilmName(){
        return name;
    }
    public String getFilmCategory(){
        return category;
    }
    public ArrayList<Person> getActors(){return actors;}
    public void setFilmScreens(int[] filmScreens){
        if(filmScreens != null && filmScreens.length == NUMBER_OF_SCREENS) {
            this.filmScreens = filmScreens;
        }
    }
    public int[] getFilmScreens(){
        return filmScreens;
    }
}
