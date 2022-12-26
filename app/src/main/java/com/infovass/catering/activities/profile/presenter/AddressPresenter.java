package com.infovass.catering.activities.profile.presenter;

public interface AddressPresenter {
    void addressListApi(String token);
    void getArealistApi(String city_id);
    void setDefaultAddressApi(String token , String address_id);
    void getCityListApi();
    void AddAddressApi(String token ,String first_name ,String last_name ,String house_no ,String contact_no
            , String appartment ,String landmark, String pincode , String address_type ,String address
            , String lat , String lng , String city_id , String area_id , String piece , String avenue  , String street);
}
