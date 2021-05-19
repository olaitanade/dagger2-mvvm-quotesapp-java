package com.vastinc.daggerquotesapp;

import android.app.Application;

import com.vastinc.daggerquotesapp.di.AppComponent;
import com.vastinc.daggerquotesapp.di.DaggerAppComponent;


public class BaseApplication extends Application {
    AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().application(this).build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
