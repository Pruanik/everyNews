package com.mybanana.everynews.app.repositories.impl;

import com.mybanana.everynews.app.EveryNewsApp;
import com.mybanana.everynews.app.interactors.NewsCallback;
import com.mybanana.everynews.app.models.News;
import com.mybanana.everynews.app.repositories.NewsRepository;
import com.mybanana.everynews.app.services.NewsHttpService;

import javax.inject.Inject;

public class NewsRepositoryImpl implements NewsRepository {
    @Inject
    public NewsHttpService httpService;

    public NewsRepositoryImpl(){
        EveryNewsApp.getAppComponent().inject(this);
    }

    @Override
    public void updateTrendsNews(NewsCallback<News> action) {
        httpService.updateTrendsNews(action);
    }

    @Override
    public void updateCategoryNews(String category, NewsCallback<News> action) {
        httpService.updateCategoryNews(category, action);
    }

    @Override
    public void searchNews(String query, NewsCallback<News> action) {
        httpService.searchNews(query, action);
    }
}
