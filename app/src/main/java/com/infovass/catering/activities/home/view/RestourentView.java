package com.infovass.catering.activities.home.view;

import com.infovass.catering.activities.home.model.RestourentListResponse;
import com.infovass.catering.activities.network.Loading;

public interface RestourentView extends Loading {
    void onSuccessGetRestourentListAPi(RestourentListResponse restourentListResponse);
}
