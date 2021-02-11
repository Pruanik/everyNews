package com.mybanana.everynews.api;

import com.mybanana.everynews.app.models.NewsPackage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<NewsPackage> getTrendsNews(
            @Query("country") String country
    );

    @GET("top-headlines")
    Call<NewsPackage> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category
    );

    @GET("everything")
    Call<NewsPackage> searchNews(
            @Query("q") String question
    );

    Call<Void> getNews(@Body NewsPackage news);
}
