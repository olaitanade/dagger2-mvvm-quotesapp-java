package com.vastinc.daggerquotesapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.vastinc.daggerquotesapp.BaseApplication;
import com.vastinc.daggerquotesapp.R;
import com.vastinc.daggerquotesapp.data.remote.model.Quote;
import com.vastinc.daggerquotesapp.di.main.MainComponent;
import com.vastinc.daggerquotesapp.util.Resource;
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
        observers();
        //mainActivityViewModel = ViewModelProviders.of(this,providerFactory).get(MainActivityViewModel.class);
    }

    void observers(){
        mainActivityViewModel.getRandomQuote("en").observe(this, new Observer<Resource<Quote>>() {
            @Override
            public void onChanged(Resource<Quote> quoteResource) {
                if(quoteResource!=null){
                    switch (quoteResource.status){
                        case LOADING:
                            break;
                        case SUCCESS:
                            Log.d(TAG, "onChanged: successful => "+quoteResource.data.getText());
                            break;
                        case ERROR:
                            break;
                    }
                }
            }
        });
    }
}