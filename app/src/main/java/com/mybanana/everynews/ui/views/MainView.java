package com.mybanana.everynews.ui.views;

import com.arellomobile.mvp.MvpView;
import com.mybanana.everynews.app.models.Category;
import com.mybanana.everynews.app.models.News;

import java.util.List;

public interface MainView extends MvpView {
    //работа с контентом
    void setCategoriesNewsList(List<News> news);
    void setCategoriesList(List<Category> news);
    void setTrendingNewsList(List<News> news);

    //прогрессбар
    void showProgress();
    void hideProgress();
    void hideRefreshProgress();

    //нотификации
    void showNotification(String message);
}
