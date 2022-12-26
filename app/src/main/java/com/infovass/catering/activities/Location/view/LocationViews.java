package com.infovass.catering.activities.Location.view;

import com.infovass.catering.activities.Location.model.AreaList;
import com.infovass.catering.activities.Location.model.CityList;
import com.infovass.catering.activities.network.Loading;

public interface LocationViews extends Loading {
    void onSuccessGetCityListAPi(CityList cityList);
    void onSuccessGetAreaListAPi(AreaList areaList);
}
