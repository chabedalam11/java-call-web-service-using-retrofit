package com.chabed.retrofit.interfaces;

import com.chabed.retrofit.collections.AnalyserCollection;

import retrofit2.Call;
import retrofit2.http.GET;



public interface TestApi {
    @GET("analyser")
    Call<AnalyserCollection> getAnalyser();
}
