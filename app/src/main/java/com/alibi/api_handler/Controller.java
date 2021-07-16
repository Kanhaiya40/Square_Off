package com.alibi.api_handler;

import android.content.Context;
import android.widget.Toast;

import com.alibi.squareoff.model.TransResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Controller {

    private final Context context;
    private final DataMethods apiService;
    private final UserDetailsPrefrennce userDetailsPrefrennce;

    public Controller(Context context) {
        this.context = context;
        apiService = NetworkHandler.getInterface();
        userDetailsPrefrennce = UserDetailsPrefrennce.getInstance(context);
    }

    public void getUpdatedLocations(ApiListener.OnGettingData onGettingDataListener) {

        apiService.getData()
                .enqueue(new Callback<TransResponse>() {
                    @Override
                    public void onResponse(Call<TransResponse> call, Response<TransResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                onGettingDataListener.onSuccess(response.body());
                            } else {
                                Toast.makeText(context, "Not able to hit api", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            onGettingDataListener.onFailure("Not Data is There");
                        }
                    }

                    @Override
                    public void onFailure(Call<TransResponse> call, Throwable t) {
                        onGettingDataListener.onFailure(t.getMessage());
                    }
                });
    }


}
