package com.mybanana.everynews.di;

import com.mybanana.everynews.app.presenters.MainPresenter;
import com.mybanana.everynews.app.repositories.impl.NewsRepositoryImpl;
import com.mybanana.everynews.app.services.impl.NewsHttpServiceImpl;
import com.mybanana.everynews.di.modules.RepositoryModule;
import com.mybanana.everynews.di.modules.ServiceModule;
import com.mybanana.everynews.di.modules.RemoteModule;
import com.mybanana.everynews.di.modules.StorageModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ServiceModule.class, RemoteModule.class, StorageModule.class, RepositoryModule.class})
public interface AppComponent {
    void inject(MainPresenter mainPresenter);
    void inject(NewsRepositoryImpl newsRepository);
    void inject(NewsHttpServiceImpl newsClient);
}
