package com.infovass.catering.activities.home.view;

import com.infovass.catering.activities.home.model.AddtoFebRestourentResponse;
import com.infovass.catering.activities.home.model.RestourentAddToFevResponse;
import com.infovass.catering.activities.home.model.RestourentDetailResponse;
import com.infovass.catering.activities.home.model.RestourentModeResponse;
import com.infovass.catering.activities.network.Loading;

public interface RestourentDetailView extends Loading {
    void onSuccessGetRestourentDetailAPi(RestourentDetailResponse restourentDetailResponse);
    void onSuccessGetRestourentModeAPi(RestourentModeResponse restourentModeResponse);
    void onSuccessAddToFevRestourentAPi(RestourentAddToFevResponse restourentAddToFevResponse);
    void onSuccessAddToFevRestourentModeAPi(AddtoFebRestourentResponse addtoFebRestourentResponse);
}
