package com.vastinc.daggerquotesapp.ui;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.vastinc.daggerquotesapp.data.remote.main.MainApi;
import com.vastinc.daggerquotesapp.data.remote.model.Quote;
import com.vastinc.daggerquotesapp.di.scope.ActivityScope;
import com.vastinc.daggerquotesapp.util.Resource;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

@ActivityScope
public class MainActivityViewModel extends ViewModel {
    private static final String TAG = "MainActivityViewModel";
    private final MainApi mainApi;

    @Inject
    public MainActivityViewModel(MainApi mainApi){
        Log.d(TAG, "MainActivityViewModel: created");
        this.mainApi = mainApi;
    }
}
