package com.mybanana.everynews.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mybanana.everynews.R;
import com.mybanana.everynews.app.models.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainNewsRecycleAdapter extends RecyclerView.Adapter<MainNewsRecycleAdapter.ViewHolder> {
    private List<News> newsList;

    public MainNewsRecycleAdapter() {
        newsList = new ArrayList<>();
    }

    public MainNewsRecycleAdapter(List<News> news){
        this.newsList = news;
    }

    @NonNull
    @Override
    public MainNewsRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //TODO: первые две позиции должны биндиться отдельно
        News item = newsList.get(position);

        Picasso.get().load(item.getUrlToImage()).into(holder.image);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView title;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.item_news_img);
            title = (TextView) itemView.findViewById(R.id.item_news_title);
            description = (TextView) itemView.findViewById(R.id.item_news_description);
        }
    }

    public void add(List<News> news){
        newsList.clear();
        for(News newsItem: news){
            if(!newsList.contains(newsItem)){
                newsList.add(newsItem);
            }
        }
        notifyDataSetChanged();
    }
}
