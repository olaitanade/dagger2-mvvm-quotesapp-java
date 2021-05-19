package com.vastinc.daggerquotesapp.data.remote.main;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MainApi {
    @GET
    Call<ResponseBody> getFakeStuff();
}
