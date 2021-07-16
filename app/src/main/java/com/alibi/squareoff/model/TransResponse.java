package com.alibi.squareoff.model;

import java.util.List;

public class TransResponse {

    private List<TransResponseData> trns = null;

    public List<TransResponseData> getTrns() {
        return trns;
    }

    public void setTrns(List<TransResponseData> trns) {
        this.trns = trns;
    }

}
