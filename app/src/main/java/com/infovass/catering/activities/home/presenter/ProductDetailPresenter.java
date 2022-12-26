package com.infovass.catering.activities.home.presenter;

import com.google.gson.JsonArray;

public interface ProductDetailPresenter {
    void addToFevItemApi(String token, String item_id);

        void getProductDetailApi(String token, String item_id , String mode_type);
   // void getProductDetailApi(String item_id);

    void productAddToCartApi(String token, String item_id, String quantity,String remove_old, String special_request, String mode_id, JsonArray jsonArray, JsonArray meals, String value);

    void productAddToCartApi(String token, String item_id, String female_service, String remove_old, String special_request, String addon_items, String meals, String mode_id);
}
