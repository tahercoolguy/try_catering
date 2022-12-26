package com.infovass.catering.activities.order.view;

import com.infovass.catering.activities.network.Loading;
import com.infovass.catering.activities.order.model.OrderListResponse;

public interface OrderViews extends Loading {
    void onSuccessGetOrderListAPi(OrderListResponse orderListResponse);
}
