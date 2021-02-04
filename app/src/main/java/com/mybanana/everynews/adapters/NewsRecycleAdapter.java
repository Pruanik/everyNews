package com.mybanana.everynews.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mybanana.everynews.R;
import com.mybanana.everynews.adapters.items.News;

import java.util.ArrayList;
import java.util.List;

public class NewsRecycleAdapter extends RecyclerView.Adapter<NewsRecycleAdapter.ViewHolder> {
    private List<News> newsList;

    public NewsRecycleAdapter() {
        newsList = new ArrayList<>();
    }

    public NewsRecycleAdapter(List<News> news){
        this.newsList = news;
    }

    @NonNull
    @Override
    public NewsRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecycleAdapter.ViewHolder holder, int position) {
        News item = newsList.get(position);

        //holder.image.setImageResource();
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.publishedAt.setText(item.getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView title;
        public TextView description;
        public TextView publishedAt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.item_news_img);
            title = (TextView) itemView.findViewById(R.id.item_news_title);
            description = (TextView) itemView.findViewById(R.id.item_news_description);
            publishedAt = (TextView) itemView.findViewById(R.id.item_news_published_at);
        }
    }

    public void add(List<News> news){
        for(News newsItem: news){
            if(!newsList.contains(newsItem)){
                newsList.add(newsItem);
            }
        }
    }
}
