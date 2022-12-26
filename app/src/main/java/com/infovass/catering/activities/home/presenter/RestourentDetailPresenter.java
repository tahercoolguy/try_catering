package com.infovass.catering.activities.home.presenter;

public interface RestourentDetailPresenter {
    void getRestourentDetailApi(String token,String id);
    void getRestourentAddToFavApi(String caterer_id);
    void getRestourentDetailApi(String token,String id , String mode_type);
    void addToFevCatererApi(String token , String caterer_id);
}

