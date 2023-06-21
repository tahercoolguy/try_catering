package com.infovass.catering.MyFormat.Services;


//import io.opencensus.stats.Stats;


import com.infovass.catering.DM.AppVersionRootDM;
import com.infovass.catering.DM.EditAddress.EditAddressRoot;
import com.infovass.catering.DM.FavoriteCatererListDM.FavoriteCatererRoot;
import com.infovass.catering.DM.GuestNotificationRoot;
 import com.infovass.catering.DM.Order_DetailsDM.OrderDetailsRoot;
import com.infovass.catering.DM.PrivacyPolicyRoot;
import com.infovass.catering.DM.ProfileDM.ProfileData;
import com.infovass.catering.DM.ProfileDM.ProfileRoot;
import com.infovass.catering.MyFormat.MyDM.Root;
import com.infovass.catering.activities.DataModel.RD_caterers_Root;
import com.infovass.catering.activities.home.model.RestourentModeResponse;

;import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedInput;

public interface PAServices {

    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @POST("/caterer-details/{id}")
    void ProductDetailAPI(@Path("id") String id,
                          @Body TypedInput body, Callback<Root> rootCallback);

    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @POST("/add-favourite-caterer")
    void AddToFevCatererApi(@Path("id") String id,
                            @Path("caterer_id") String caterer_id, Callback<Root> rootCallback);


    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @GET("/privacy-policy")
    void PrivacyPolicyAPI(Callback<PrivacyPolicyRoot> privacyPolicyRootCallback);

    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @GET("/profile")
    void ProfileAPI(@Header("Authorization") String token, Callback<ProfileRoot> profileRootCallback);

    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @POST("/save-guest-device")
    void GuestNotification(@Body MultipartTypedOutput multipartTypedOutput, Callback<GuestNotificationRoot> guestNotificationRootCallback);

    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @GET("/app-version")
    void App_Version(Callback<AppVersionRootDM> appVersionRootDMCallback);


    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @POST("/favourite-caterer-list")
    void Favourite_Caterer_List(@Header("Authorization") String token, Callback<FavoriteCatererRoot> favoriteCatererRootCallback);

//   @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @GET("/order-details/{id}")
    void OrderDetails( @Path("id")  String id,@Header("Authorization") String token, Callback<OrderDetailsRoot> orderDetailsRootCallback);

    @POST("/edit-address/{id}")
    void Edit_Address( @Path("id")  String id,@Header("Authorization") String token,@Body MultipartTypedOutput multipartTypedOutput, Callback<EditAddressRoot> editAddressRootCallback);

    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @POST("/update-payment")
    void Update_Payment(@Body MultipartTypedOutput multipartTypedOutput, Callback<GuestNotificationRoot> guestNotificationRootCallback);

//    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
//    @POST("caterer-details/{id}")
//    Observable<RestourentModeResponse> restourentDetailApi(
//            @Path("id") String id,
//            @Body TypedInput body
//    );

    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @POST("/random-caterers")
    void newRandomCaterers(@Body MultipartTypedOutput multipartTypedOutput, Callback<RD_caterers_Root> caterers_rootCallback);
}
