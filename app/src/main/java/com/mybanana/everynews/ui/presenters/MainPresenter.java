package com.mybanana.everynews.ui.presenters;

import com.mybanana.everynews.adapters.items.News;
import com.mybanana.everynews.models.NewsModel;
import com.mybanana.everynews.ui.activities.MainActivity;

import java.util.List;

public class MainPresenter {

    private MainActivity view;
    private NewsModel model;

    public MainPresenter(MainActivity view, NewsModel model){
        this.view = view;
        this.model = model;
    }

    public void onCreate(){
        loadNews();
    }

    private void loadNews(){
        view.showProgress();

        model.getNews(new NewsModel.ViewAction(){
            public void updateNews(List<News> news){
                view.hideProgress();
                view.showNews(news);
            }
            public void notification(String message){
                view.showNotification(message);
            }
        });
    }
}
