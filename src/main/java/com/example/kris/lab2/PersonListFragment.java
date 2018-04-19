package com.example.kris.lab2;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class PersonListFragment extends Fragment {

    private ListView listView;
    private PersonListAdapter personListAdapter;
    private ArrayList<Person> personList;
    private static String MESSAGE_ACTORS = "putActors";

    public PersonListFragment() {
        // Required empty public constructor
    }

    public static PersonListFragment newInstance(ArrayList<Person> actors) {
        PersonListFragment fragment = new PersonListFragment();
        Bundle args = new Bundle();
        args.putSerializable(MESSAGE_ACTORS, actors);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            personList = (ArrayList<Person>)bundle.getSerializable(MESSAGE_ACTORS);
        } else {
            personList = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_list, container, false);
        listView = view.findViewById(R.id.list_view);

        if(personList == null) personList = new ArrayList<>();
        personListAdapter = new PersonListAdapter(personList, view.getContext());
        listView.setAdapter(personListAdapter);
        return view;
    }

}
