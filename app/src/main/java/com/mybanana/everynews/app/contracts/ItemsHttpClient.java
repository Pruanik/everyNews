package com.mybanana.everynews.app.contracts;

import com.mybanana.everynews.app.models.News;

public interface ItemsHttpClient {
    void updateNews(CallbackAction<News> action);
    void searchNews(String query, CallbackAction<News> action);
}
