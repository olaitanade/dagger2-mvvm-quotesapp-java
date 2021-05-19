package com.vastinc.daggerquotesapp.data.remote.main;

import com.vastinc.daggerquotesapp.data.remote.model.Author;
import com.vastinc.daggerquotesapp.data.remote.model.Quote;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MainApi {
    @GET("quotes")
    Flowable<Quote> getRandomQuote(@Query("l") String l);

    @GET("quotes/{id}")
    Flowable<Quote> getQuoteById(@Path("id") String id);

    @GET("quotes/authors")
    Flowable<List<Author>> getAuthors(@Query("q") String q);

    @GET("quotes/author/{id}")
    Flowable<List<Quote>> getQuotesByAuthor(@Path("id") String id);
}
