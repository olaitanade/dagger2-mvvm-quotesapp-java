package com.vastinc.daggerquotesapp.di;

import android.app.Application;

import com.vastinc.daggerquotesapp.BaseApplication;
import com.vastinc.daggerquotesapp.di.main.MainComponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(
        modules = {
                SubComponentsModule.class,
                AppModule.class,
                ViewModelFactoryModule.class,
        }
    )
public interface AppComponent {

    MainComponent.Factory mainComponent();

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}
