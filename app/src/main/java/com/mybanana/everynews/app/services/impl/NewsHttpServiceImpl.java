package com.mybanana.everynews.app.services.impl;

import com.mybanana.everynews.app.contracts.CallbackAction;
import com.mybanana.everynews.app.models.News;
import com.mybanana.everynews.app.models.NewsPackage;
import com.mybanana.everynews.api.NewsApi;
import com.mybanana.everynews.app.services.NewsHttpService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsHttpServiceImpl implements NewsHttpService {
    @Inject
    public NewsApi newsClient;

    @Override
    public void updateNews(CallbackAction<News> action) {

        Call<NewsPackage> call = newsClient.getTopHeadlineNews("us", "business");

        call.enqueue(new Callback<NewsPackage>() {
            @Override
            public void onResponse(Call<NewsPackage> call, Response<NewsPackage> response) {
                if (response.isSuccessful()) {
                    action.showNotification("Всего загружено " + response.body().getTotalResults() + "шт. статей");
                    action.updateItems(response.body().getNews());
                } else {
                    action.showNotification("Ошибка, код: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<NewsPackage> call, Throwable t) {
                action.showNotification("Ошибка соединения, попробуйте позже");
            }
        });
    }

    @Override
    public void searchNews(String query, CallbackAction<News> action) {
        Call<NewsPackage> call = newsClient.searchNews(query);

        call.enqueue(new Callback<NewsPackage>() {
            @Override
            public void onResponse(Call<NewsPackage> call, Response<NewsPackage> response) {
                if (response.isSuccessful()) {
                    action.showNotification("Всего загружено " + response.body().getTotalResults() + "шт. статей");
                    action.updateItems(response.body().getNews());
                } else {
                    action.showNotification("Ошибка, код: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<NewsPackage> call, Throwable t) {
                action.showNotification("Ошибка соединения, попробуйте позже");
            }
        });
    }
}