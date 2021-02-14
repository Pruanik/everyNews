package com.mybanana.everynews.app.interactors.impl;

import com.mybanana.everynews.app.interactors.ActionCallback;
import com.mybanana.everynews.app.models.Category;
import com.mybanana.everynews.ui.views.MainView;

import java.util.List;

public class CategoriesCallbackImpl implements ActionCallback<Category> {
    MainView view;

    public CategoriesCallbackImpl(MainView view){
        this.view = view;
    }

    @Override
    public void updateItems(List<Category> items) {
        view.setCategoriesList(items);
    }

    @Override
    public void showNotification(String message) {
        view.showNotification(message);
    }
}
