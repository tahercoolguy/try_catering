package com.infovass.catering.MyFormat.Services;


//import io.opencensus.stats.Stats;


import com.infovass.catering.MyFormat.MyDM.Root;
import com.infovass.catering.activities.home.model.RestourentModeResponse;

import io.reactivex.Observable;
import retrofit.Callback;
import retrofit.http.Body;
 import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedInput;
import retrofit.http.Path;

public interface PAServices {

    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @POST("/caterer-details/{id}")
    void ProductDetailAPI(@Path("id") String id,
                          @Body TypedInput body, Callback<Root> rootCallback);

    @Headers("Cache-Control: no-cache;Content-Type: application/json;")
    @POST("caterer-details/{id}")
    Observable<RestourentModeResponse> restourentDetailApi(
            @Path("id") String id,
            @Body TypedInput body
    );
 }
