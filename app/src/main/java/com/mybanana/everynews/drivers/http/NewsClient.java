package com.mybanana.everynews.drivers.http;

import android.util.Log;

import com.mybanana.everynews.app.contracts.CallbackAction;
import com.mybanana.everynews.app.contracts.ItemsHttpClient;
import com.mybanana.everynews.app.models.News;
import com.mybanana.everynews.app.models.NewsPackage;
import com.mybanana.everynews.drivers.http.api.NewsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsClient implements ItemsHttpClient {
    private Retrofit retrofit;
    private NewsApi newsClient;

    public NewsClient(){
        retrofit = Client.getClient();
        newsClient = retrofit.create(NewsApi.class);
    }

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
        Log.d("REPHTTPAPI", query);
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
