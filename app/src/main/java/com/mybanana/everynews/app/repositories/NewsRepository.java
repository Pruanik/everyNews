package com.mybanana.everynews.app.repositories;

import com.mybanana.everynews.app.interactors.ActionCallback;
import com.mybanana.everynews.app.models.News;

public interface NewsRepository {
    void updateTrendsNews(ActionCallback<News> action);
    void updateCategoryNews(String category, ActionCallback<News> action);
    void searchNews(String query, ActionCallback<News> action);
}
