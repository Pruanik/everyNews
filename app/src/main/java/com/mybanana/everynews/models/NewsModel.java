package com.mybanana.everynews.models;

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

    public abstract static class ViewAction{
        public void updateNews(List<News> news){}
        public void notification(String message){}
    }
}
