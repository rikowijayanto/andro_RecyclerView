package com.example.myrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter <GridHeroAdapter.GridHeroView> {

    private ArrayList <Hero> listHero;

    public GridHeroAdapter (ArrayList <Hero> list) {
        this.listHero =  list;
    }

    @NonNull
    @Override
    public GridHeroView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hero, parent, false);
        return new GridHeroView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridHeroView holder, int position) {

        Hero hero = listHero.get(position);


        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 350))
                .into(holder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    class GridHeroView extends RecyclerView.ViewHolder {

        ImageView imgPhoto;

        public GridHeroView(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
