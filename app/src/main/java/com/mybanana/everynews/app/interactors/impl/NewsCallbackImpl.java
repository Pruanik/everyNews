package com.mybanana.everynews.app.interactors.impl;

import com.mybanana.everynews.app.interactors.NewsCallback;
import com.mybanana.everynews.app.models.Category;
import com.mybanana.everynews.app.models.News;
import com.mybanana.everynews.ui.views.MainView;

import java.util.ArrayList;
import java.util.List;

public class NewsCallbackImpl implements NewsCallback<News> {
    MainView view;

    public NewsCallbackImpl(MainView view){
        this.view = view;
    }

    @Override
    public void updateItems(List<News> items) {
        view.hideProgress();
        view.setCategoriesNewsList(items);
        view.setTrendingNewsList(items);

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Бизнес", "business"));
        categories.add(new Category("Наука", "science"));
        categories.add(new Category("Здоровье", "health"));
        categories.add(new Category("Спорт", "sports"));
        categories.add(new Category("Технологии", "technology"));

        view.setCategoriesList(categories);
    }

    @Override
    public void showNotification(String message) {
        view.showNotification(message);
    }
}
