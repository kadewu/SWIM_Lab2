package com.example.kris.lab2;


import java.util.ArrayList;

public class HardcodeData {
    private ArrayList<Film> films;
    public HardcodeData(){
        films = new ArrayList<>(5);
        films.add(kapitanBomba());
        films.add(generalItalia());
        films.add(konRafal());
        films.add(egzorcysta());
        films.add(piesekLeszek());
    }
    public static Film kapitanBomba(){
        Person[] actors = {new Person("Tytus", "Bomba", "02-03-1970", R.drawable.screen2),
                new Person("Sebastian", "Bąk", "05-07-1980", R.mipmap.ic_test),
                new Person("J.J.", "Torpeda", "07-07-1972", R.drawable.screen3 ),
                new Person("Andżela", "", "05-05-1982", R.mipmap.ic_face),
                new Person("Domino", "Jachaś", "02-03-1972", R.mipmap.ic_launcher)};

        Film film = new Film(R.drawable.kapitan_bomba, "Kapitan Bomba", "science-fiction", actors);
        int[] screens_res = {R.drawable.screen1, R.drawable.screen2, R.drawable.screen3, R.drawable.screen4
                , R.drawable.screen5, R.drawable.screen6};
        film.setFilmScreens(screens_res);

        return film;
    }
    public static Film generalItalia(){
        Person[] actors = {new Person("Bogdan", "Italia", "20-03-1920", R.drawable.screen4),
        new Person("Szeregowy", "Kłyś", "10-05-1943", R.mipmap.ic_test),
        new Person("Szeregowy", "Szeregowy", "12-20-1945", R.mipmap.ic_for_person)};

        Film film = new Film(R.drawable.general_italia, "Generał Italia", "historyczny", actors);
        int[] screens_res = {R.drawable.screen7, R.drawable.screen2, R.drawable.screen3, R.drawable.screen4
                , R.drawable.screen5, R.drawable.screen6};
        film.setFilmScreens(screens_res);

        return film;
    }
    public static Film konRafal(){
        Person[] actors = {new Person("Koń", "Rafał", "", R.mipmap.ic_pets)};

        Film film = new Film(R.drawable.kon_rafal, "Koń Rafał", "dramat", actors);
        int[] screens_res = {R.drawable.screen1, R.drawable.screen7, R.drawable.screen3, R.drawable.screen4
                , R.drawable.screen5, R.drawable.screen6};
        film.setFilmScreens(screens_res);

        return film;
    }

    public static Film egzorcysta(){
        Person[] actors = {new Person("Egzorcysta", "", "01-01-1800", R.mipmap.ic_for_person)};

        Film film = new Film(R.drawable.egzorcysta, "Egzorcysta", "horror", actors);
        int[] screens_res = {R.drawable.screen1, R.drawable.screen2, R.drawable.screen7, R.drawable.screen4
                , R.drawable.screen5, R.drawable.screen6};
        film.setFilmScreens(screens_res);

        return film;
    }

    public static Film piesekLeszek(){
        Person[] actors = {new Person("Piesek", "Leszek", "", R.mipmap.ic_pets)};

        Film film = new Film(R.drawable.piesek_leszek, "Piesek Leszek", "przyrodniczy", actors);
        int[] screens_res = {R.drawable.screen1, R.drawable.screen2, R.drawable.screen3, R.drawable.screen4
                , R.drawable.screen5, R.drawable.screen7};
        film.setFilmScreens(screens_res);

        return film;
    }
    public ArrayList<Film> getFilms(){ return films;}
}
