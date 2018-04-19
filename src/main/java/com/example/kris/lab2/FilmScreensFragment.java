package com.example.kris.lab2;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FilmScreensFragment extends Fragment {

    private static String MESSAGE_SCREENS ="putScreens";

    private int[] screens;
    private ImageView[] imageViews;

    public FilmScreensFragment() {
        // Required empty public constructor
    }

    public static FilmScreensFragment newInstance(int[] screens) {
        FilmScreensFragment fragment = new FilmScreensFragment();
        Bundle args = new Bundle();
        args.putIntArray(MESSAGE_SCREENS, screens);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            screens = bundle.getIntArray(MESSAGE_SCREENS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film_screens, container, false);
        imageViews = new ImageView[Film.NUMBER_OF_SCREENS];
        imageViews[0] = view.findViewById(R.id.filmScreensImageView1);
        imageViews[1] = view.findViewById(R.id.filmScreensImageView2);
        imageViews[2] = view.findViewById(R.id.filmScreensImageView3);
        imageViews[3] = view.findViewById(R.id.filmScreensImageView4);
        imageViews[4] = view.findViewById(R.id.filmScreensImageView5);
        imageViews[5] = view.findViewById(R.id.filmScreensImageView6);

        if(screens != null) {
            for (int i = 0; i < 6; i++) {
                imageViews[i].setImageResource(screens[i]);
            }
        }
        return view;
    }

}
