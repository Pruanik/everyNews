package com.mybanana.everynews.app.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mybanana.everynews.app.EveryNewsApp;
import com.mybanana.everynews.app.interactors.ActionCallback;
import com.mybanana.everynews.app.interactors.impl.CategoriesCallbackImpl;
import com.mybanana.everynews.app.interactors.impl.NewsCallbackImpl;
import com.mybanana.everynews.app.models.News;
import com.mybanana.everynews.app.repositories.CategoriesRepository;
import com.mybanana.everynews.app.repositories.NewsRepository;
import com.mybanana.everynews.ui.views.MainView;

import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    @Inject
    public NewsRepository newsRepository;
    @Inject
    public CategoriesRepository categoriesRepository;

    public MainPresenter(){
        EveryNewsApp.getAppComponent().inject(this);
    }

    public void onCreate(){
        getViewState().showProgress();

        categoriesRepository.updateCategories(
                new CategoriesCallbackImpl(getViewState())
        );
        newsRepository.updateTrendsNews(
                new NewsCallbackImpl(getViewState())
        );


    }

    public void onRefresh(){
        newsRepository.updateTrendsNews(new ActionCallback<News>(){
            @Override
            public void updateItems(List<News> news) {
                getViewState().hideRefreshProgress();
                getViewState().setCategoriesNewsList(news);
                getViewState().setTrendingNewsList(news);
            }

            @Override
            public void showNotification(String message) {
                getViewState().showNotification(message);
            }
        });
    }

    public void onSearch(String query){
        getViewState().showProgress();

        newsRepository.searchNews(
                query,
                new NewsCallbackImpl(getViewState())
        );
    }
}
