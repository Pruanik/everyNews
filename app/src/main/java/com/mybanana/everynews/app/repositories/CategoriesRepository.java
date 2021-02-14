package com.mybanana.everynews.app.repositories;

import com.mybanana.everynews.app.interactors.ActionCallback;
import com.mybanana.everynews.app.models.Category;

public interface CategoriesRepository {
    void updateCategories(ActionCallback<Category> action);
}
