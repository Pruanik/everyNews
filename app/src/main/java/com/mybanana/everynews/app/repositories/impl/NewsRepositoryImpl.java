package com.mybanana.everynews.app.repositories.impl;

import com.mybanana.everynews.app.contracts.CallbackAction;
import com.mybanana.everynews.app.repositories.NewsRepository;
import com.mybanana.everynews.app.services.NewsHttpService;

public class NewsRepositoryImpl implements NewsRepository {
    private final NewsHttpService httpService;

    public NewsRepositoryImpl(NewsHttpService httpService){
        this.httpService = httpService;
    }

    @Override
    public void getNews(CallbackAction action) {
        httpService.updateNews(action);
    }

    @Override
    public void searchNews(String query, CallbackAction action) {

    }
}
