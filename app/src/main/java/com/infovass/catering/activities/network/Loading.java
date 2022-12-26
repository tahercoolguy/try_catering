package com.infovass.catering.activities.network;

public interface Loading {

    void showLoading();

    void hideLoading();

    void onFail(String msg);

    void onNoInternet();

}
