package com.mybanana.everynews.app.interactors;

import java.util.List;

public interface NewsCallback<T> {
    void updateItems(List<T> items);
    void showNotification(String message);
}
