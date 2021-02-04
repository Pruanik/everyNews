package com.mybanana.everynews.repository.http;

import com.mybanana.everynews.adapters.items.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<HttpNews.NewsPackage> getTopHeadlineNews(
            @Query("country") String country,
            @Query("category") String category
    );

    @GET("everything")
    Call<HttpNews.NewsPackage> searchNews(
            @Query("q") String question
    );

    Call<Void> getNews(@Body HttpNews.NewsPackage news);
}
