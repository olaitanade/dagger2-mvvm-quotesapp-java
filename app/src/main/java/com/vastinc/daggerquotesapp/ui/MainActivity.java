package com.vastinc.daggerquotesapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.vastinc.daggerquotesapp.R;
import com.vastinc.daggerquotesapp.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    private static final String TAG = "MainActivity";

    private MainActivityViewModel mainActivityViewModel;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this,providerFactory).get(MainActivityViewModel.class);
    }
}