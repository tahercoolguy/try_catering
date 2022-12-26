package com.infovass.catering.activities.network;

/**
 * All API names, base urls, headers
 */

public @interface WebUrl {

//  =======================base url==========================https://try-catering.com/

    String BASE_URL = "https://try-catering.com/index.php/";
    // String BASE_URL = "http://try-catering.com/";
    // String BASE_URL = "https://mastersofphp.com/tryCatering/public/";

    //  =======================auth apis==========================
    String GET_API_LOGIN = "api/login";
    String GET_API_FORGOT_PASSWORD = "api/forgot-password";
    String GET_USER_PROFILE = "api/user_detail";
    String GET_API_SIGNUP = "api/signup";
    String GET_CITY_LIST = "api/cities";
    String GET_PAGES = "api/pages";
    String PLACE_ORDER_API = "api/place-order";
    String SET_DEFAULT_ADDRESS = "api/set-default-address";
    String GET_CART = "api/user-cart";
    String GET_ADDRESSES = "api/user-addresses";
    String GET_ORDER_LIST = "api/orders";
    String GET_FAVOURITE_LIST = "api/favourite-caterer-list";
    String GET_API_AREA = "api/areas";
    String SET_DEF_ADDRESS = "api/set-default-address";
    String ADD_ADDRESS_API = "api/add-user-address";
    //    String GET_RESTOURENT_LISTS = "api/caterers";
    String GET_RESTOURENT_LISTS = "api/random-caterers";
    String FEV_RESTOURENT = "api/add-favourite-caterer";
    String FEV_ITEM = "api/add-favourite-item";
    String PRODUCT_ADD_TO_CART = "api/add-to-cart";
    String ADD_TO_FEB_RST = "api/add-favourite-caterer";
    String GET_RESTOURENT_DETAIL = "api/caterer-details/{id}";
    String updatePayment = "api/update-payment";
    String promocode = "api/apply-coupon";
}
