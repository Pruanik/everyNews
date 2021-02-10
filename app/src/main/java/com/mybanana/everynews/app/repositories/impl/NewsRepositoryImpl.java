package com.mybanana.everynews.app.repositories.impl;

import com.mybanana.everynews.app.EveryNewsApp;
import com.mybanana.everynews.app.contracts.CallbackAction;
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
    public void getNews(CallbackAction<News> action) {
        httpService.updateNews(action);
    }

    @Override
    public void searchNews(String query, CallbackAction<News> action) {
        httpService.searchNews(query, action);
    }
}
