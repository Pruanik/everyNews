package com.mybanana.everynews.di.modules;

import com.mybanana.everynews.app.repositories.NewsRepository;
import com.mybanana.everynews.app.repositories.impl.NewsRepositoryImpl;
import com.mybanana.everynews.app.services.NewsHttpService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RepositoryModule {

    @Provides
    public NewsRepository provideNewsRepository(NewsHttpService httpService){
        return new NewsRepositoryImpl(httpService);
    }
}
