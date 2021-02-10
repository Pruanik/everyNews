package com.mybanana.everynews.ui.views;

import com.arellomobile.mvp.MvpView;
import com.mybanana.everynews.app.models.News;

import java.util.List;

public interface MainView extends MvpView {
    void setNews(List<News> news);
    void showProgress();
    void hideProgress();
    void hideRefreshProgress();
    void showNotification(String message);
}