package com.example.kris.lab2;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Person implements Serializable{
    private String firstName, lastName, birthday;
    private int imageRes;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

    public Person(String firstName, String lastName, String birthday, int imageRes){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.imageRes = imageRes;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return  lastName;
    }
    public int getAge() {
        Date date = null;
        try{
            date = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {}

        if(date == null) return 0;
        int SECONDS_IN_YEAR = 31536000;
        Date currentTime = Calendar.getInstance().getTime();
        long ageInSeconds = currentTime.getTime()/1000 - date.getTime()/1000;
        return Math.round(ageInSeconds) / SECONDS_IN_YEAR;
    }
    public int getImageRes(){
        return imageRes;
    }
}
