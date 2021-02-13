package com.mybanana.everynews.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mybanana.everynews.R;
import com.mybanana.everynews.app.models.Category;
import com.mybanana.everynews.app.models.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoriesRecycleAdapter extends RecyclerView.Adapter<CategoriesRecycleAdapter.ViewHolder> {
    private List<Category> categoriesList;

    public CategoriesRecycleAdapter() {
        categoriesList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CategoriesRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cateory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category item = categoriesList.get(position);

        holder.name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.item_category_name);
        }
    }

    public void add(List<Category> categories){
        categoriesList.clear();
        for(Category categoryItem: categories){
            if(!categoriesList.contains(categoryItem)){
                categoriesList.add(categoryItem);
            }
        }
        notifyDataSetChanged();
    }
}
