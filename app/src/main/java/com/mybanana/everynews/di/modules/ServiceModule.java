package com.mybanana.everynews.di.modules;

import com.mybanana.everynews.app.services.NewsHttpService;
import com.mybanana.everynews.app.services.impl.NewsHttpServiceImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {
    @Provides
    public NewsHttpService provideNewsHttpService(){
        return new NewsHttpServiceImpl();
    }
}
