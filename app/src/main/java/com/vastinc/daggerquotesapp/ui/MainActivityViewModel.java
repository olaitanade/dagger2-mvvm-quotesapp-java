package com.vastinc.daggerquotesapp.ui;

import androidx.lifecycle.ViewModel;

import com.vastinc.daggerquotesapp.data.remote.main.MainApi;

import javax.inject.Inject;

public class MainActivityViewModel extends ViewModel {

    @Inject
    public MainActivityViewModel(MainApi mainApi){

    }
}
