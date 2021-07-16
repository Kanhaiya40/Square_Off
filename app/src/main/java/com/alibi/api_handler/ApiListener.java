package com.alibi.api_handler;

import com.alibi.squareoff.model.TransResponse;

public class ApiListener {

    public interface OnGettingData {
        void onSuccess(TransResponse transResponseListener);

        void onFailure(String message);
    }
}
