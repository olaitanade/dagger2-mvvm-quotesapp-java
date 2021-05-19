package com.vastinc.daggerquotesapp.di.main;

import com.vastinc.daggerquotesapp.ui.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {MainViewModelsModule.class, MainModule.class})
public interface MainComponent {
    @Subcomponent.Factory
    interface Factory {
        MainComponent create();
    }
    void inject(MainActivity mainActivity);
}