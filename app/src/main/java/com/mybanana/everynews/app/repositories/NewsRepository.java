package com.mybanana.everynews.app.repositories;

import com.mybanana.everynews.app.contracts.CallbackAction;
import com.mybanana.everynews.app.models.News;

public interface NewsRepository {
    void getNews(CallbackAction<News> action);
    void searchNews(String query, CallbackAction<News> action);
}
