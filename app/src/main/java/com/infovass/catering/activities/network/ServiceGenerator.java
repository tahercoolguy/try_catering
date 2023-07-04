package com.infovass.catering.activities.network;

import android.util.Log;

import com.infovass.catering.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static final String TAG = "RetrofitManager";

    private static Gson gson = new GsonBuilder().setLenient().serializeNulls().create();

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    // No need to instantiate this class.
    private ServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, WebUrl.BASE_URL, new MyOkHttpInterceptor(""));
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl, String no) {
        return createService(serviceClass, baseUrl, new MyOkHttpInterceptor(""));
    }

    public static <S> S createService(Class<S> serviceClass, String token) {
        return createService(serviceClass, WebUrl.BASE_URL, new MyOkHttpInterceptor(token));
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl, Interceptor networkInterceptor) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        if (networkInterceptor != null) {
            okHttpClientBuilder.addNetworkInterceptor(networkInterceptor);
        }

        okHttpClientBuilder.writeTimeout(120, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(90, TimeUnit.SECONDS);

        OkHttpClient modifiedOkHttpClient = okHttpClientBuilder.addInterceptor(getHttpLoggingInterceptor()).build();

        retrofitBuilder.client(modifiedOkHttpClient);
        retrofitBuilder.baseUrl(baseUrl);

        Retrofit retrofit = retrofitBuilder.build();

        return retrofit.create(serviceClass);
    }

    private static Cache getCache() {
        Cache mCache = null;
        try {
            mCache = new Cache(new File(IDApplication.getInstance().getCacheDir(), "http_cache"),
                    10 * 1024 * 1024); // 10 MB
        } catch (Exception e) {
            Log.e(TAG, "Could not create Cache!");
        }
        return mCache;
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return httpLoggingInterceptor;
    }

    public static class MyOkHttpInterceptor implements Interceptor {
        String token = "";

        MyOkHttpInterceptor(String token) {
            this.token = token;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request newRequest = null;

            if (token != null && token.length() > 0) {
                newRequest = originalRequest.newBuilder()
                        .header("Authorization", "Bearer " + token)
                        .build();
            } else {
                newRequest = originalRequest.newBuilder()
                        .build();
            }

            return chain.proceed(newRequest);
        }
    }


}