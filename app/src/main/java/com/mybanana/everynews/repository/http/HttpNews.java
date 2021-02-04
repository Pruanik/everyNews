package com.mybanana.everynews.repository.http;

import android.util.Log;

import com.mybanana.everynews.adapters.items.News;
import com.mybanana.everynews.lib.retrofit.RetrofitClient;
import com.mybanana.everynews.models.NewsModel;
import com.mybanana.everynews.repository.BaseNewsRepository;
import com.squareup.moshi.Json;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HttpNews implements BaseNewsRepository {
    private Retrofit retrofit;
    private NewsApi newsClient;

    public HttpNews(){
        retrofit = RetrofitClient.getClient();
        newsClient = retrofit.create(NewsApi.class);
    }

    @Override
    public void updateNews(NewsModel.ViewAction action) {

        Call<NewsPackage> call = newsClient.getTopHeadlineNews("us", "business");

        call.enqueue(new Callback<NewsPackage>() {
            @Override
            public void onResponse(Call<NewsPackage> call, Response<NewsPackage> response) {
                if (response.isSuccessful()) {
                    Log.d("RETR", String.valueOf(response.body().totalResults));
                    action.updateNews(response.body().news);
                } else {
                    Log.d("RETR", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<NewsPackage> call, Throwable t) {
                Log.d("RETR","failure " + t);
            }
        });
    }

    static class NewsPackage {
        @Json(name = "status") String status;
        @Json(name = "totalResults") Integer totalResults;
        @Json(name = "articles") List<News> news;
    }
}
