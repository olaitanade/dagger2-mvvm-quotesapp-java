package com.vastinc.daggerquotesapp.data.remote.main;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MainApi {
    @GET("quotes")
    Flowable<ResponseBody> getRandomQuote(@Query("l") String l);

    @GET("quotes/{id}")
    Flowable<ResponseBody> getQuoteById(@Path("id") String id);

    @GET("quotes/authors")
    Flowable<ResponseBody> getAuthors(@Query("q") String q);

    @GET("quotes/author/{id}")
    Flowable<ResponseBody> getQuotesByAuthor(@Path("id") String id);
}
