package com.mybanana.everynews.app.interactors.impl;

import com.mybanana.everynews.app.interactors.NewsCallback;
import com.mybanana.everynews.app.models.News;
import com.mybanana.everynews.ui.views.MainView;

import java.util.List;

public class NewsCallbackImpl implements NewsCallback<News> {
    MainView view;

    public NewsCallbackImpl(MainView view){
        this.view = view;
    }

    @Override
    public void updateItems(List<News> items) {
        view.hideProgress();
        view.setNewsList(items);
    }

    @Override
    public void showNotification(String message) {
        view.showNotification(message);
    }
}
