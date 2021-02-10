package com.mybanana.everynews.app.contracts;

import java.util.List;

public interface CallbackAction<Object> {
    void updateItems(List<Object> items);
    void showNotification(String message);
}
