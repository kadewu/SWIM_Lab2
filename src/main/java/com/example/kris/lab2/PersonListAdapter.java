package com.example.kris.lab2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonListAdapter extends ArrayAdapter<Person>{
    public PersonListAdapter(ArrayList<Person> personData, Context context){
        super(context, R.layout.list_view_row, personData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mV = convertView;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            mV = inflater.inflate(R.layout.list_view_row, null);
        }

        final Person person = getItem(position);

        initRow(mV, person);

        return mV;
    }

    private void initRow(View view, final Person person){
        if(person != null) {
            TextView tFullName = view.findViewById(R.id.textOnListViewFullName);
            TextView tAge = view.findViewById(R.id.textOnListViewAge);
            ImageView iPersonImage = view.findViewById(R.id.imageOnListViewPerson);
            if(tFullName != null){
                tFullName.setText(person.getFirstName() + " " + person.getLastName());
            }
            if(tAge != null){
                tAge.setText(person.getAge()+"");
            }
            if(iPersonImage != null){
                iPersonImage.setImageResource(person.getImageRes());
            }
        }
    }
}
