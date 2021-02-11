package com.mybanana.everynews.app.services;

import com.mybanana.everynews.app.interactors.NewsCallback;
import com.mybanana.everynews.app.models.News;

public interface NewsHttpService {
    void updateTrendsNews(NewsCallback<News> action);
    void updateCategoryNews(String category, NewsCallback<News> action);
    void searchNews(String query, NewsCallback<News> action);
}
