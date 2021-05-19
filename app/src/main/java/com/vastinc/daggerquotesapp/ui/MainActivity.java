package com.vastinc.daggerquotesapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.vastinc.daggerquotesapp.BaseApplication;
import com.vastinc.daggerquotesapp.R;
import com.vastinc.daggerquotesapp.di.main.MainComponent;
import com.vastinc.daggerquotesapp.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    MainComponent mainComponent;

    @Inject
    MainActivityViewModel mainActivityViewModel;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainComponent = ((BaseApplication)getApplicationContext()).getAppComponent().mainComponent().create();
        mainComponent.inject(this);

        setContentView(R.layout.activity_main);

        //mainActivityViewModel = ViewModelProviders.of(this,providerFactory).get(MainActivityViewModel.class);
    }
}