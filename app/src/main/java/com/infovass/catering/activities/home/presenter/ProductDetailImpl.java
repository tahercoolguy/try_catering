package com.infovass.catering.activities.home.presenter;

import android.util.Log;

import com.google.gson.JsonArray;
import com.infovass.catering.activities.home.model.CateringServiceATCResponse;
import com.infovass.catering.activities.home.model.ProductAddToCartResponse;
import com.infovass.catering.activities.home.model.ProductDetailResponse;
import com.infovass.catering.activities.home.model.RestourentAddToFevResponse;
import com.infovass.catering.activities.home.view.ProductDetailView;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.ServiceGenerator;
import com.infovass.catering.activities.network.WebService;

import org.json.JSONObject;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductDetailImpl implements ProductDetailPresenter {

    private ProductDetailView views;

    public ProductDetailImpl(ProductDetailView views) {
        this.views = views;
    }

    @Override
    public void addToFevItemApi(String token, String item_id) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            HashMap<String, String> fields = new HashMap<>();
            fields.put("item_id", item_id);
            Observable<RestourentAddToFevResponse> observable = webService.addToFevItemApi(fields);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<RestourentAddToFevResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.hideLoading();
                        }

                        @Override
                        public void onNext(RestourentAddToFevResponse restourentAddToFevResponse) {
                            try
                            {
                                views.hideLoading();
                                if(restourentAddToFevResponse.getStatus())
                                    views.onSuccessAddToFevItemAPi(restourentAddToFevResponse);
                                else
                                    views.onSuccessAddToFevItemAPi(restourentAddToFevResponse);
                            }catch (Exception e){}
                        }

                        @Override
                        public void onError(Throwable e) {
                            views.hideLoading();
                            Log.i("DETAILDETAILDETAIL",e.getMessage());
                            if (e instanceof SocketTimeoutException) {//ClassNotFoundException
                                views.onFail(Constants.StatusMessage.TIMEOUT);
                            } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
                                views.onNoInternet();
                            } else {
                                views.onFail("" + e.toString());
                            }
                        }

                        @Override
                        public void onComplete() {
                            views.hideLoading();
                        }
                    });
        }catch (Exception j){
            Log.i("DETAILDETAILDETAIL",j.getMessage());
        }
    }

    @Override
    public void getProductDetailApi(String token , String item_id, String mode_type) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class);
            JSONObject object = new JSONObject();
            object.putOpt("mode_type", mode_type);
            Observable<ProductDetailResponse> observable = webService.productDetailApi(item_id , object.toString());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ProductDetailResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.hideLoading();
                        }

                        @Override
                        public void onNext(ProductDetailResponse productDetailResponse) {
                            try
                            {
                                views.hideLoading();
                                if(productDetailResponse.getStatus())
                                    views.onSuccessGetProductDetailAPi(productDetailResponse);
                                else
                                    views.onSuccessGetProductDetailAPi(productDetailResponse);
                            }catch (Exception e){}
                        }

                        @Override
                        public void onError(Throwable e) {
                            views.hideLoading();
                            Log.i("ERROR" , ""+e.getMessage());
                            if (e instanceof SocketTimeoutException) {//ClassNotFoundException
                                views.onFail(Constants.StatusMessage.TIMEOUT);
                            } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
                                views.onNoInternet();
                            } else {
                                views.onFail("" + e.toString());
                            }
                        }

                        @Override
                        public void onComplete() {
                            views.hideLoading();
                        }
                    });
        }catch (Exception j){
            views.hideLoading();
            Log.i("RTRTRTRT",j.getMessage());}
    }

    @Override
    public void productAddToCartApi(String token, String item_id, String quantity, String remove_old,String special_request, String mode_id, JsonArray jsonArray, JsonArray jsonArray1, String value) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            CateringServiceATCResponse cateringServiceATCResponse =new CateringServiceATCResponse(item_id,remove_old,special_request,mode_id,jsonArray,jsonArray1);
//            HashMap<String, String> fields = new HashMap<>();
//            fields.put("item_id", item_id);
//            fields.put("remove_old", remove_old);
//            fields.put("special_request", special_request);
//            fields.put("quantity", quantity);
//            fields.put("mode_id",mode_id);

            Observable<ProductAddToCartResponse> observable = webService.product_AddToCart(cateringServiceATCResponse);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ProductAddToCartResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.hideLoading();
                        }

                        @Override
                        public void onNext(ProductAddToCartResponse productAddToCartResponse) {
                            try
                            {
                                views.hideLoading();
                                if(productAddToCartResponse.getStatus())
                                    views.onSuccessProductAddToCartAPi(productAddToCartResponse);
                                else
                                    views.onSuccessProductAddToCartAPi(productAddToCartResponse);
                            }catch (Exception e){}
                        }

                        @Override
                        public void onError(Throwable e) {
                            views.hideLoading();
                            Log.i("ERROR" , ""+e.getLocalizedMessage());
                            if (e instanceof SocketTimeoutException) {//ClassNotFoundException
                                views.onFail(Constants.StatusMessage.TIMEOUT);
                            } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
                                views.onNoInternet();
                            } else {
                                views.onFail("" + e.toString());
                            }
                        }

                        @Override
                        public void onComplete() {
                            views.hideLoading();
                        }
                    });
        }catch (Exception j){
            views.hideLoading();
            Log.i("RTRTRTRT",j.getMessage());}
    }

    @Override
    public void productAddToCartApi(String token, String item_id, String female_service, String remove_old, String special_request, String addon_items ,String meals,String mode_id) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            HashMap<String, String> fields = new HashMap<>();
            fields.put("item_id", item_id);
            fields.put("female_service", female_service);
            fields.put("remove_old", remove_old);
            fields.put("special_request", special_request);
            fields.put("addon_items", addon_items);
            fields.put("meals", meals);
            fields.put("mode_id",mode_id);

            Observable<ProductAddToCartResponse> observable = webService.productAddToCart(fields);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ProductAddToCartResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.hideLoading();
                        }

                        @Override
                        public void onNext(ProductAddToCartResponse productAddToCartResponse) {
                            try
                            {
                                views.hideLoading();
                                if(productAddToCartResponse.getStatus())
                                    views.onSuccessProductAddToCartAPi(productAddToCartResponse);
                                else
                                    views.onSuccessProductAddToCartAPi(productAddToCartResponse);
                            }catch (Exception e){}
                        }

                        @Override
                        public void onError(Throwable e) {
                            views.hideLoading();
                            Log.i("ERROR" , ""+e.getLocalizedMessage());
                            if (e instanceof SocketTimeoutException) {//ClassNotFoundException
                                views.onFail(Constants.StatusMessage.TIMEOUT);
                            } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
                                views.onNoInternet();
                            } else {
                                views.onFail("" + e.toString());
                            }
                        }

                        @Override
                        public void onComplete() {
                            views.hideLoading();
                        }
                    });
        }catch (Exception j){
            views.hideLoading();
            }
    }
}
