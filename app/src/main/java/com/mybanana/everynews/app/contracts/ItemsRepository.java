package com.mybanana.everynews.app.contracts;

public interface ItemsRepository<Object> {
    void getNews(CallbackAction<Object> action);
    void searchNews(String query, CallbackAction<Object> action);
}
