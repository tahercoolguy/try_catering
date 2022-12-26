package com.infovass.catering.activities.cart.presenter;

public interface CartPresenter {
    void getUserCartApi(String token);
    void deleteCartItemApi(String token , String itemID);
    void plaseOrderApi(String token , String address_id , String request_date_time,String payment_type,String time);
    void getUserPromoCode(String token,String code,String address_id);
}
