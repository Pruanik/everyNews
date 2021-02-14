package com.mybanana.everynews.app.repositories.impl;

import com.mybanana.everynews.app.interactors.ActionCallback;
import com.mybanana.everynews.app.models.Category;
import com.mybanana.everynews.app.repositories.CategoriesRepository;

import java.util.ArrayList;

public class CategoriesRepositoryImpl implements CategoriesRepository {
    @Override
    public void updateCategories(ActionCallback<Category> action) {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Business", "business"));
        categories.add(new Category("Science", "science"));
        categories.add(new Category("Health", "health"));
        categories.add(new Category("Sports", "sports"));
        categories.add(new Category("Technology", "technology"));

        action.updateItems(categories);
    }
}
