package com.mybanana.everynews.drivers.http.api;

import com.mybanana.everynews.app.models.NewsPackage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<NewsPackage> getTopHeadlineNews(
            @Query("country") String country,
            @Query("category") String category
    );

    @GET("everything")
    Call<NewsPackage> searchNews(
            @Query("q") String question
    );

    Call<Void> getNews(@Body NewsPackage news);
}
