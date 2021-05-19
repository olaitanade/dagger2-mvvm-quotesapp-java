package com.vastinc.daggerquotesapp.ui;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.vastinc.daggerquotesapp.data.remote.main.MainApi;
import com.vastinc.daggerquotesapp.di.scope.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class MainActivityViewModel extends ViewModel {
    private static final String TAG = "MainActivityViewModel";
    @Inject
    public MainActivityViewModel(MainApi mainApi){
        Log.d(TAG, "MainActivityViewModel: created");
    }
}
