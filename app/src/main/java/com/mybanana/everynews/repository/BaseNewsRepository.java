package com.mybanana.everynews.repository;

import com.mybanana.everynews.adapters.items.News;

import java.util.List;

public interface BaseNewsRepository {
    public List<News> getNews();
}
