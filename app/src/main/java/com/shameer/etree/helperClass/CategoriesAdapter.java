package com.shameer.etree.helperClass;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shameer.etree.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    ArrayList<CategoriesHelperClass> categoriesLocation;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categoriesLocation) {
        this.categoriesLocation = categoriesLocation;
    }

    @NonNull

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriesAdapter.CategoriesViewHolder holder, int position) {
        CategoriesHelperClass categoriesHelperClass = categoriesLocation.get(position);
        holder.image.setImageResource(categoriesHelperClass.getImage());
        holder.title.setText(categoriesHelperClass.getTitle());
    }

    @Override
    public int getItemCount() {
        return categoriesLocation.size();
    }


    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public CategoriesViewHolder(View itemView) {
            super(itemView);


            image = itemView.findViewById(R.id.categories_image);
            title = itemView.findViewById(R.id.categories_title);
        }

    }
}