package com.infovass.catering.activities.cart.view;

import com.infovass.catering.activities.cart.model.CartResponse;
import com.infovass.catering.activities.cart.model.PlaceOrderResponse;
import com.infovass.catering.activities.cart.model.PromoCodeResponse;
import com.infovass.catering.activities.cart.model.RemoveItemFromCart;
import com.infovass.catering.activities.network.Loading;

public interface CartView extends Loading {
    void onSuccessGetCartAPi(CartResponse cartResponse);
    void onSuccessDeleteItemCartAPi(RemoveItemFromCart removeItemFromCart);
    void onSuccessPlaseOrderAPi(PlaceOrderResponse placeOrderResponse);
    void onSuccessPromoCodeAPi(PromoCodeResponse promoCodeResponse);
}
