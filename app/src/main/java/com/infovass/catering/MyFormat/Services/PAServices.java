package com.infovass.catering.MyFormat.Services;


//import io.opencensus.stats.Stats;


import com.infovass.catering.MyFormat.MyDM.Root;
import com.infovass.catering.activities.home.model.RestourentModeResponse;

;import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
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

//    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
//    @POST("caterer-details/{id}")
//    Observable<RestourentModeResponse> restourentDetailApi(
//            @Path("id") String id,
//            @Body TypedInput body
//    );
 }
