package com.example.kris.lab2;


import java.util.ArrayList;

public class SingletonMainActivity {
    private static SingletonMainActivity instance = null;
    private ArrayList<Film> films = null;
    protected SingletonMainActivity(){

    }
    public static SingletonMainActivity getInstance(){
        if(instance == null){
            instance = new SingletonMainActivity();
        }
        return instance;
    }
    public ArrayList<Film> getFilms(){ return films;}
    public void setFilms(ArrayList<Film> films){
        this.films = films;
    }
}
