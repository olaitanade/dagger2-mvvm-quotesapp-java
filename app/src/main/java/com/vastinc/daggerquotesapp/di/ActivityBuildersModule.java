package com.vastinc.daggerquotesapp.di;

import com.vastinc.daggerquotesapp.di.main.MainModule;
import com.vastinc.daggerquotesapp.di.main.MainViewModelsModule;
import com.vastinc.daggerquotesapp.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class, MainModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
