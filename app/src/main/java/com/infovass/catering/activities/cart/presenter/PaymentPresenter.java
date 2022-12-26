package com.infovass.catering.activities.cart.presenter;

public interface PaymentPresenter {
    void getPayment(String token,String order_id,String payment_id,Boolean payment_status,String transaction_number,String track_id,String invoice_id);
}
