package com.infovass.catering.activities.network;

public @interface Constants {
    //Phone Local storage folder name where reports will be saved.

    String KEY_LOGGED_IN = "key_logged_in";
    String PREFERENCE_NAME = "IMC";
    String KEY_LANGUAGE = "key_language";
    String KEY_LOGIN_LANGUAGE = "key_login_language";
    String CHANNEL_SIREN_NAME = "cateringname";
    String CHANNEL_SIREN_ID = "cateringappId";
    String CHANNEL_SIREN_DESCRIPTION = "cateringappdesc";


    String ENGLISH = "en";
    String ARABIC = "ar";

    String KEY_PRODUCT_ID = "productid";
    String KEY_SERVICE_ID = "serviceid";
    String KEY_SINGLE_CATEGORIE_ID = "catIId";
    String KEY_SINGLE_SERVICE_ID = "ServiceId";
    String KEY_SINGLE_SUB_CATEGORIE_ID = "subcatID";
    String KEY_SINGLE_SUB_SERVICE_ID = "serviceID";
    String KEY_AUTH_TOKEN = "token";
    String KEY_USER_NAME = "name";
    String KEY_USER_PHONENO = "phoneNO";
    String KEY_CATEGORIE_ID = "categorie_id";
    String KEY_ACTIVITY = "activity";
    String KEY_TIME = "time";
    String KEY_DATE = "date";
    String KEY_DATE1 = "date";
    String mode_id = "mode_id";

    String KEY_CITY_ID = "city_id";
    String KEY_AREA_NAME = "area_name";
    String KEY_ARABIC_AREA_NAME = "arabic_area_name";
    String KEY_AREA_ID = "area_id";
    String KEY_RESTOURENT_ID = "restourent_id";
    String ITEM_ID = "item_id";
    String INFO = "info";
    String MODE_ID = "mode_id";
    String TOKEN = "token";
    String UserName = "username";
    String UserID = "userID";
    String ClassName = "className";
    String Language = "language";
    String URL = "url";
    String order_id="order_id";
    String invoice_id="invoice_id";

    String address = "address";
    String addressID = "addressID";

    String phone = "phone";
    String email = "email";
    String name = "name";
    String surname = "surname";

    @interface StatusMessage {
        String TIMEOUT = "timeout";
        String INVALID_USER = "401";
        String UNKNOWN = "unknown";
        String CANCEL = "3";
        String NO_SHOW = "5";
    }

    @interface Filter {
        String REFRESH_CONSULTS = "refresh_consults";
        String REFRESH_MAIN = "Refresh_Main";
        String REFRESH_MAIN_NOTIFICATION = "Refresh_notification";
    }

}
