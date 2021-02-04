package com.mybanana.everynews.models;

import com.mybanana.everynews.adapters.items.News;
import com.mybanana.everynews.repository.BaseNewsRepository;
import com.mybanana.everynews.repository.http.HttpNews;

import java.util.List;

public class NewsModel {
    BaseNewsRepository repository;

    public NewsModel(BaseNewsRepository repository) {
        this.repository = repository;
    }

    public List<News> getNews(){
        return repository.getNews();
    }
}
