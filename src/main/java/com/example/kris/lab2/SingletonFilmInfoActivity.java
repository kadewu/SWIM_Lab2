package com.example.kris.lab2;

public class SingletonFilmInfoActivity {
    private static SingletonFilmInfoActivity instance = null;
    private boolean fragmentType = true;
    protected SingletonFilmInfoActivity(){

    }
    public static SingletonFilmInfoActivity getInstance(){
        if(instance == null){
            instance = new SingletonFilmInfoActivity();
        }
        return instance;
    }
    public Boolean getFragmentType(){
        return fragmentType;
    }
    public void setFragmentType(boolean fragmentType){
        this.fragmentType = fragmentType;
    }
    public void changeFragmentType(){
        fragmentType = !fragmentType;
    }
}
