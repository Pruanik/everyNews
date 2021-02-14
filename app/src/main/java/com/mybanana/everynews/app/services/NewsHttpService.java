package com.mybanana.everynews.app.services;

import com.mybanana.everynews.app.interactors.ActionCallback;
import com.mybanana.everynews.app.models.News;

public interface NewsHttpService {
    void updateTrendsNews(ActionCallback<News> action);
    void updateCategoryNews(String category, ActionCallback<News> action);
    void searchNews(String query, ActionCallback<News> action);
}
