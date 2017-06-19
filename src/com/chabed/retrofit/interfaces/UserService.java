package com.chabed.retrofit.interfaces;

import com.chabed.retrofit.collections.ColorCollection;

import retrofit2.Call;
import retrofit2.http.GET;


public interface UserService {
    @GET("rufaida/color")
    Call<ColorCollection> getColor();
}
