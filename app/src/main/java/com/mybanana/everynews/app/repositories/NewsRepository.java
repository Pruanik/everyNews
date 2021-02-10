package com.mybanana.everynews.app.repositories;

import com.mybanana.everynews.app.contracts.CallbackAction;

public interface NewsRepository<News> {
    void getNews(CallbackAction<News> action);
    void searchNews(String query, CallbackAction<News> action);
}
