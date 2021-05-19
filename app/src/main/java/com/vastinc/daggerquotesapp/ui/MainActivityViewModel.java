package com.vastinc.daggerquotesapp.ui;

import androidx.lifecycle.ViewModel;

import com.vastinc.daggerquotesapp.data.remote.main.MainApi;
import com.vastinc.daggerquotesapp.di.scope.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class MainActivityViewModel extends ViewModel {

    @Inject
    public MainActivityViewModel(MainApi mainApi){

    }
}
