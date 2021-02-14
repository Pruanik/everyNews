package com.mybanana.everynews.di.modules;

import com.mybanana.everynews.app.repositories.CategoriesRepository;
import com.mybanana.everynews.app.repositories.NewsRepository;
import com.mybanana.everynews.app.repositories.impl.CategoriesRepositoryImpl;
import com.mybanana.everynews.app.repositories.impl.NewsRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public NewsRepository provideNewsRepository(){
        return new NewsRepositoryImpl();
    }

    @Provides
    public CategoriesRepository provideCategoriesRepository(){
        return new CategoriesRepositoryImpl();
    }
}
