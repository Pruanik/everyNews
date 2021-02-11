package com.mybanana.everynews.app.repositories;

import com.mybanana.everynews.app.interactors.NewsCallback;
import com.mybanana.everynews.app.models.News;

public interface NewsRepository {
    void getNews(NewsCallback<News> action);
    void searchNews(String query, NewsCallback<News> action);
}
