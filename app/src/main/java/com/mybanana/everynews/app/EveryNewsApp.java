package com.mybanana.everynews.app;

import android.app.Application;

import com.mybanana.everynews.di.AppComponent;
import com.mybanana.everynews.di.DaggerAppComponent;

public class EveryNewsApp extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
