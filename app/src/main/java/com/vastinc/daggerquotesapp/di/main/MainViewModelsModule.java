package com.vastinc.daggerquotesapp.di.main;

import androidx.lifecycle.ViewModel;

import com.vastinc.daggerquotesapp.di.ViewModelKey;
import com.vastinc.daggerquotesapp.ui.MainActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    public abstract ViewModel bindMainViewModel(MainActivityViewModel mainActivityViewModel);
}
