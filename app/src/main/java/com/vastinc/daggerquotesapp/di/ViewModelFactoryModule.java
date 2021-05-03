package com.vastinc.daggerquotesapp.di;

import androidx.lifecycle.ViewModelProvider;

import com.vastinc.daggerquotesapp.viewmodel.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);
}
