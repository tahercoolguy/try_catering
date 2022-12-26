package com.infovass.catering.activities.fav.view;

import com.infovass.catering.activities.fav.model.FavListResponse;
import com.infovass.catering.activities.network.Loading;

public interface FavViews extends Loading {
    void onSuccessGetFavListAPi(FavListResponse favListResponse);
}
