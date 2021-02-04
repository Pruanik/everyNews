package com.mybanana.everynews.repository;

import com.mybanana.everynews.adapters.items.News;
import com.mybanana.everynews.models.NewsModel;

import java.util.List;

public interface BaseNewsRepository {
    public void updateNews(NewsModel.ViewAction action);
}
