package com.mybanana.everynews.app.models;

import com.squareup.moshi.Json;

import java.util.List;

public class NewsPackage {
    @Json(name = "status")
    String status;
    @Json(name = "totalResults")
    Integer totalResults;
    @Json(name = "articles")
    List<News> news;

    public NewsPackage(String status, Integer totalResults, List<News> news) {
        this.status = status;
        this.totalResults = totalResults;
        this.news = news;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
