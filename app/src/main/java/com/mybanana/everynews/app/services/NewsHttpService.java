package com.mybanana.everynews.app.services;

import com.mybanana.everynews.app.contracts.CallbackAction;
import com.mybanana.everynews.app.models.News;

public interface NewsHttpService {
    void updateNews(CallbackAction<News> action);
    void searchNews(String query, CallbackAction<News> action);
}
