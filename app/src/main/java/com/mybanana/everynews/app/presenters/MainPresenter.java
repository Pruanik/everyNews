package com.mybanana.everynews.app.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mybanana.everynews.app.EveryNewsApp;
import com.mybanana.everynews.app.contracts.CallbackAction;
import com.mybanana.everynews.app.models.News;
import com.mybanana.everynews.app.repositories.NewsRepository;
import com.mybanana.everynews.ui.views.MainView;

import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    @Inject
    public NewsRepository repository;

    public MainPresenter(){
        EveryNewsApp.getAppComponent().inject(this);
    }

    public void onCreate(){
        getViewState().showProgress();

        repository.getNews(new CallbackAction<News>(){
            @Override
            public void updateItems(List<News> news) {
                getViewState().hideProgress();
                getViewState().setNews(news);
            }

            @Override
            public void showNotification(String message) {
                getViewState().showNotification(message);
            }
        });
    }

    public void onRefresh(){
        repository.getNews(new CallbackAction<News>(){
            @Override
            public void updateItems(List<News> news) {
                getViewState().hideRefreshProgress();
                getViewState().setNews(news);
            }

            @Override
            public void showNotification(String message) {
                getViewState().showNotification(message);
            }
        });
    }

    public void onSearch(String query){
        getViewState().showProgress();

        repository.searchNews(query, new CallbackAction<News>(){
            @Override
            public void updateItems(List<News> news) {
                getViewState().hideProgress();
                getViewState().setNews(news);
            }

            @Override
            public void showNotification(String message) {
                getViewState().showNotification(message);
            }
        });
    }
}
