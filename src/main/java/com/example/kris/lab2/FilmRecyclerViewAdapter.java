package com.example.kris.lab2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmRecyclerViewAdapter extends RecyclerView.Adapter<FilmRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Film> items;
    private int itemLayout;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tFilmName, tFilmCategory;
        public ImageView iFilmImage;
        public ViewHolder(View view){
            super(view);

            init(view);
            setListeners();
        }
        private void init(View view){
            tFilmName = view.findViewById(R.id.textOnFilmRecyclerViewFilmName);
            tFilmCategory = view.findViewById(R.id.textOnFilmRecyclerViewFilmCategory);
            iFilmImage = view.findViewById(R.id.imageOnFilmRecyclerView);
        }
        private void setListeners(){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Film film = (Film)view.getTag();
                    FilmInfoActivity.start(view.getContext(), film);
                }
            });
        }
    }

    public FilmRecyclerViewAdapter(ArrayList<Film> items, int itemLayout){
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Film item = items.get(position);
        holder.itemView.setTag(item);
        holder.tFilmName.setText(item.getFilmName());
        holder.tFilmCategory.setText(item.getFilmCategory());
        holder.iFilmImage.setImageResource(item.getImageRes());
    }

    public void remove(int position){
        notifyItemRemoved(position);
        items.remove(position);
    }
}
