package com.chabed.retrofit.init;

import com.chabed.retrofit.interfaces.TestApi;
import com.chabed.retrofit.url.TestWebservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TestWebserviceUtil {
    public static TestApi webserviceInitialize() {
        TestApi appointmentSystemsApi;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TestWebservice.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        appointmentSystemsApi = retrofit.create(TestApi.class);
        return appointmentSystemsApi;
    }
}
