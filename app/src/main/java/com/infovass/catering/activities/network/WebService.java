package com.infovass.catering.activities.network;

import com.infovass.catering.activities.Location.model.AreaList;
import com.infovass.catering.activities.Location.model.CityList;
import com.infovass.catering.activities.cart.model.CartResponse;
import com.infovass.catering.activities.cart.model.PaymentResponse;
import com.infovass.catering.activities.cart.model.PlaceOrderResponse;
import com.infovass.catering.activities.cart.model.PromoCodeResponse;
import com.infovass.catering.activities.cart.model.RemoveItemFromCart;
import com.infovass.catering.activities.fav.model.FavListResponse;
import com.infovass.catering.activities.home.model.AddtoFebRestourentResponse;
import com.infovass.catering.activities.home.model.CateringServiceATCResponse;
import com.infovass.catering.activities.home.model.ProductAddToCartResponse;
import com.infovass.catering.activities.home.model.ProductDetailResponse;
import com.infovass.catering.activities.home.model.RestourentAddToFevResponse;
import com.infovass.catering.activities.home.model.RestourentDetailResponse;
import com.infovass.catering.activities.home.model.RestourentListResponse;
import com.infovass.catering.activities.home.model.RestourentModeResponse;
import com.infovass.catering.activities.login.model.ForGotPasswordResponse;
import com.infovass.catering.activities.login.model.LoginResponse;
import com.infovass.catering.activities.login.model.SignUPResponse;
import com.infovass.catering.activities.order.model.OrderListResponse;
import com.infovass.catering.activities.profile.model.AddAddressResponse;
import com.infovass.catering.activities.profile.model.AddressResponse;
import com.infovass.catering.activities.profile.model.DefaultAddressResponse;
import com.infovass.catering.activities.profile.model.PagesResponse;
import com.infovass.catering.activities.profile.model.ProfileResponse;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit.mime.TypedInput;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Interface for all API call
 */

public interface WebService {

//========================Auth APIs====================================


    @FormUrlEncoded
    @POST(WebUrl.GET_API_AREA)
    Observable<AreaList> areaAPI(
            @Field("city_id") String city_id
    );

    @FormUrlEncoded
    @POST(WebUrl.ADD_ADDRESS_API)
    Observable<AddAddressResponse> addAddressAPI(
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("house_no") String house_no,
            @Field("contact_no") String contact_no,
            @Field("appartment") String appartment,
            @Field("landmark") String landmark,
            @Field("pincode") String pincode,
            @Field("address_type") String address_type,
            @Field("address") String address,
            @Field("lat") String lat,
            @Field("lng") String lng,
            @Field("city_id") String city_id,
            @Field("area_id") String area_id,
            @Field("piece") String piece,
            @Field("avenue") String avenue,
            @Field("street") String street
    );

    @FormUrlEncoded
    @POST(WebUrl.GET_RESTOURENT_LISTS)
    Observable<RestourentListResponse> restourentList(
            @Field("mode_type") String phone,
            @Field("area_id") String password,//date..yy-mm-dd
            @Field("date") String date

    );
    @FormUrlEncoded
    @POST(WebUrl.GET_RESTOURENT_LISTS)
    Observable<RestourentListResponse> restouren_tList(
            @Field("date") String date

    );

    @POST("api/caterer-details/{id}")
    Observable<RestourentDetailResponse> restourentDetailApi(
            @Path("id") String id
    );

    @FormUrlEncoded
    @POST(WebUrl.FEV_RESTOURENT)
    Observable<RestourentAddToFevResponse> addToFevCatererApi(
            @FieldMap HashMap<String, String> fields
    );

    @FormUrlEncoded
    @POST(WebUrl.FEV_ITEM)
    Observable<RestourentAddToFevResponse> addToFevItemApi(
            @FieldMap HashMap<String, String> fields
    );

    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @POST("api/caterer-details/{id}")
    Observable<RestourentModeResponse> restourentDetailApi(
            @Path("id") String id,
            @Body TypedInput body
    );

   // @GET("api/item-details/{item}")

    @HTTP(method = "get", path = "api/item-details/{item}")
    Observable<ProductDetailResponse> productDetailApi(
            @Path("item") String item
            );
    //            @Body String body

    @FormUrlEncoded
    //@GET("api/set-default-address")
    @HTTP(method = "get", path = "api/set-default-address", hasBody = true)
    Observable<DefaultAddressResponse> setDefaultAddressApi(
            @FieldMap HashMap<String, String> fields
    );

    @HTTP(method = "get", path = "api/remove-to-cart/{item}", hasBody = true)
    Observable<RemoveItemFromCart> removeItemToCartApi(
            @Path("item") String item
    );

    @POST(WebUrl.PRODUCT_ADD_TO_CART)
    Observable<ProductAddToCartResponse> product_AddToCart(
//            @FieldMap HashMap<String, String> fields
            @Body CateringServiceATCResponse cateringServiceATCResponse
            );

    @FormUrlEncoded
    @POST(WebUrl.PRODUCT_ADD_TO_CART)
    Observable<ProductAddToCartResponse> productAddToCart(
            @FieldMap HashMap<String, String> fields
    );

    @POST(WebUrl.ADD_TO_FEB_RST)
    Observable<AddtoFebRestourentResponse> addToFevrestourentApi(
            @Body String body
    );

    @FormUrlEncoded
    @POST(WebUrl.GET_API_LOGIN)
    Observable<LoginResponse> loginAPI(
            @Field("email") String phone,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST(WebUrl.GET_API_FORGOT_PASSWORD)
    Observable<ForGotPasswordResponse> forgotPassword(
            @Field("email") String phone
    );

    @FormUrlEncoded
    @POST(WebUrl.PLACE_ORDER_API)
    Observable<PlaceOrderResponse> placeOrderAPI(
            @FieldMap HashMap<String, String> fields
    );

    @FormUrlEncoded
    @POST(WebUrl.GET_USER_PROFILE)
    Observable<ProfileResponse> GetUserProfile(
            @Field("user_id") String phone
    );

    @FormUrlEncoded
    @POST(WebUrl.GET_API_SIGNUP)
    Observable<SignUPResponse> signUpAPI(
            @Field("name") String name,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("password") String password,
            @Field("confirm_password") String confirm_password,
            @Field("device_token") String device_token,
            @Field("device_type") String device_type
    );

    @GET(WebUrl.GET_CITY_LIST)
    Observable<CityList> getCityList();

    @GET(WebUrl.GET_PAGES)
    Observable<PagesResponse> getPages();

    @GET(WebUrl.GET_CART)
    Observable<CartResponse> getUserCart();

    @GET(WebUrl.GET_ADDRESSES)
    Observable<AddressResponse> getUserAddresses();

    @GET(WebUrl.GET_ORDER_LIST)
    Observable<OrderListResponse> getOrderList();

    @GET(WebUrl.GET_FAVOURITE_LIST)
    Observable<FavListResponse> getFavList();

    @FormUrlEncoded
    @POST(WebUrl.updatePayment)
    Observable<PaymentResponse> updatePayment(
            @Field("invoice_id") String order_id,
            @Field("payment_id") String payment_id,
            @Field("payment_status") Boolean payment_status,
            @Field("track_id") String track_id,
            @Field("transaction_number") String transaction_number
     );

    @FormUrlEncoded
    @POST(WebUrl.promocode)
    Observable<PromoCodeResponse> promoCode(
            @Field("coupon_code") String promo_code,
            @Field("address_id") String address_id
    );
}


