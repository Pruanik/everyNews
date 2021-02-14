package com.mybanana.everynews.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mybanana.everynews.R;
import com.mybanana.everynews.app.models.Category;
import com.mybanana.everynews.app.models.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainNewsRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private TrendingNewsRecycleAdapter trendingAdapter;
    private CategoriesRecycleAdapter categoriesAdapter;
    private List<News> newsList;
    private Context context;

    private static final int LAYOUT_ONE = 0; //первый тип отображения на позиции 0
    private static final int LAYOUT_TWO = 1; //второй тип отображений на позиции 1
    private static final int LAYOUT_THREE = 2; //третий тип отображений на позиции 2
    private static final int LAYOUT_FOUR = 3; //четвертый тип отображений на позиции 3

    public MainNewsRecycleAdapter(Context context) {
        this.context = context;
        newsList = new ArrayList<>();
        trendingAdapter = new TrendingNewsRecycleAdapter();
        categoriesAdapter = new CategoriesRecycleAdapter();
    }

    public void addCategoriesNews(List<News> news){
        newsList.clear();
        for(News newsItem: news){
            if(!newsList.contains(newsItem)){
                newsList.add(newsItem);
            }
        }
        notifyDataSetChanged();
    }

    public void addCategories(List<Category> categories){
        categoriesAdapter.add(categories);
    }

    public void addTrendingNews(List<News> news){
        trendingAdapter.add(news);
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case LAYOUT_ONE:
                return LAYOUT_ONE;
            case LAYOUT_TWO:
                return LAYOUT_TWO;
            case LAYOUT_THREE:
                return LAYOUT_THREE;
            default:
                return LAYOUT_FOUR;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;

        if(viewType == LAYOUT_ONE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_categories, parent, false);
            holder = new ViewHolderCategories(view);
        }

        if(viewType == LAYOUT_TWO){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_trending_news, parent, false);
            holder = new ViewHolderTrendingNews(view);
        }

        if(viewType == LAYOUT_THREE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_recent_news, parent, false);
            holder = new ViewHolderTitle(view);
        }

        if(viewType == LAYOUT_FOUR){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_news, parent, false);
            holder = new ViewHolderCategoryNews(view);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder.getItemViewType() == LAYOUT_ONE){
            ViewHolderCategories viewHolder = (ViewHolderCategories) holder;

            viewHolder.categoriesRecycler.setAdapter(categoriesAdapter);
            viewHolder.categoriesRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            viewHolder.categoriesRecycler.setHasFixedSize(true);
        }

        if(holder.getItemViewType() == LAYOUT_TWO){
            ViewHolderTrendingNews viewHolder = (ViewHolderTrendingNews) holder;

            viewHolder.trendingNewsRecycler.setAdapter(trendingAdapter);
            viewHolder.trendingNewsRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            viewHolder.trendingNewsRecycler.setHasFixedSize(true);
        }

        if(holder.getItemViewType() == LAYOUT_THREE){
            ViewHolderTitle viewHolder = (ViewHolderTitle) holder;
        }

        if(holder.getItemViewType() == LAYOUT_FOUR){
            ViewHolderCategoryNews viewHolder = (ViewHolderCategoryNews) holder;

            News item = newsList.get(position - 3);

            Picasso.get()
                    .load(item.getUrlToImage())
                    .placeholder(R.drawable.default_image)
                    .error(R.drawable.default_image)
                    .into(viewHolder.image);

            viewHolder.title.setText(item.getTitle());
            viewHolder.description.setText(item.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return newsList.size() + 3;
    }


    //Холдеры на каждый тип элементов
    public class ViewHolderCategories extends RecyclerView.ViewHolder{
        public RecyclerView categoriesRecycler;

        public ViewHolderCategories(@NonNull View itemView) {
            super(itemView);

            categoriesRecycler = (RecyclerView) itemView.findViewById(R.id.recycler_categories);
        }
    }

    public class ViewHolderTitle extends RecyclerView.ViewHolder{
        public TextView title;

        public ViewHolderTitle(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class ViewHolderTrendingNews extends RecyclerView.ViewHolder{
        public RecyclerView trendingNewsRecycler;

        public ViewHolderTrendingNews(@NonNull View itemView) {
            super(itemView);

            trendingNewsRecycler = (RecyclerView) itemView.findViewById(R.id.recycler_trending_news);
        }
    }

    public class ViewHolderCategoryNews extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView title;
        public TextView description;

        public ViewHolderCategoryNews(@NonNull View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.item_news_img);
            title = (TextView) itemView.findViewById(R.id.item_news_title);
            description = (TextView) itemView.findViewById(R.id.item_news_description);
        }
    }
}
