package com.infovass.catering.activities.profile.view;

import com.infovass.catering.activities.Location.model.AreaList;
import com.infovass.catering.activities.Location.model.CityList;
import com.infovass.catering.activities.network.Loading;
import com.infovass.catering.activities.profile.model.AddAddressResponse;
import com.infovass.catering.activities.profile.model.AddressResponse;
import com.infovass.catering.activities.profile.model.DefaultAddressResponse;

public interface AddressViews extends Loading {
    void onSuccessGetAddressAPi(AddressResponse addressResponse);
    void onSuccessSetDefaultAddressAPi(DefaultAddressResponse defaultAddressResponse);
    void onSuccessGetCityListAPi(CityList cityList);
    void onSuccessGetAreaListAPi(AreaList areaList);
    void onSuccessAddAddressAPi(AddAddressResponse addressResponse);
}
