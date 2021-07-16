package com.alibi.api_handler;

import com.alibi.squareoff.model.TransResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataMethods {

    @GET("config.json")
    Call<TransResponse> getData();
}
