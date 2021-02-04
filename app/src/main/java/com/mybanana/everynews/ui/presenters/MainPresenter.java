package com.mybanana.everynews.ui.presenters;

import android.util.Log;

import com.mybanana.everynews.adapters.items.News;
import com.mybanana.everynews.models.NewsModel;
import com.mybanana.everynews.ui.activities.MainActivity;

import java.util.List;

public class MainPresenter {

    private MainActivity view;
    private NewsModel model;

    public MainPresenter(MainActivity view, NewsModel model){
        this.view = view;
        this.model = model;
    }

    public void onCreate(){
        loadNews();
    }

    private void loadNews(){
        List<News> news = model.getNews();
        view.showNews(news);
    }
}
