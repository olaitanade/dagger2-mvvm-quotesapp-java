package com.vastinc.daggerquotesapp.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.vastinc.daggerquotesapp.data.remote.main.MainApi;
import com.vastinc.daggerquotesapp.data.remote.model.Quote;
import com.vastinc.daggerquotesapp.di.scope.FragmentScope;
import com.vastinc.daggerquotesapp.util.Resource;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class HomeViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private static final String TAG = "HomeViewModel";
    private final MainApi mainApi;
    private MediatorLiveData<Resource<Quote>> randomQuote;
    @Inject
    public HomeViewModel(MainApi mainApi){
        Log.d(TAG, "HomeViewModel: created");
        this.mainApi = mainApi;
        this.randomQuote = new MediatorLiveData<>();
    }

    public LiveData<Resource<Quote>> observeRandomQuote(){
        return randomQuote;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: true");
    }

    public void getRandomQuote(String language){
        randomQuote.setValue(Resource.loading((Quote) null));

        final LiveData<Resource<Quote>> source = LiveDataReactiveStreams.fromPublisher(

                mainApi.getRandomQuote(language)

                        .onErrorReturn(new Function<Throwable, Quote>() {
                            @Override
                            public Quote apply(Throwable throwable) throws Exception {
                                Log.e(TAG, "apply: ", throwable);
                                Quote quoteError = new Quote();
                                quoteError.setUuid("-1");
                                return quoteError;
                            }
                        })

                        .map(new Function<Quote, Resource<Quote>>() {
                            @Override
                            public Resource<Quote> apply(Quote q) throws Exception {

                                if(q.getUuid().equals("-1")){
                                    return Resource.error("Something went wrong", null);
                                }


                                return Resource.success(q);
                            }
                        })

                        .subscribeOn(Schedulers.io())
        );

        randomQuote.addSource(source, new Observer<Resource<Quote>>() {
            @Override
            public void onChanged(Resource<Quote> quoteResource) {
                randomQuote.setValue(quoteResource);
                randomQuote.removeSource(source);
            }
        });
    }
}