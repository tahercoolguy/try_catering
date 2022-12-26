package com.infovass.catering.activities.cart.view;

import com.infovass.catering.activities.cart.model.PaymentResponse;
import com.infovass.catering.activities.network.Loading;

public interface PaymentView extends Loading {
    void onSuccessGetPayment(PaymentResponse cartResponse);
}
