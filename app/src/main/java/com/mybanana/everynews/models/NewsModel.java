package com.mybanana.everynews.models;

import android.util.Log;

import com.mybanana.everynews.adapters.items.News;
import com.mybanana.everynews.repository.BaseNewsRepository;

import java.util.List;

public class NewsModel {
    BaseNewsRepository repository;

    public NewsModel(BaseNewsRepository repository) {
        this.repository = repository;
    }

    public void getNews(ViewAction action) {
        repository.updateNews(action);
    }
    public void searchNews(String query, ViewAction action) {
        Log.d("MODELNEWS", query);
        repository.searchNews(query, action);
    }

    public abstract static class ViewAction{
        public abstract void updateNews(List<News> news);
        public abstract void notification(String message);
    }
}
