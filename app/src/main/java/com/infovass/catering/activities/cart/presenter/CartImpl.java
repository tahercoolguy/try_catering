package com.infovass.catering.activities.cart.presenter;

import android.util.Log;

import com.infovass.catering.activities.cart.model.CartResponse;
import com.infovass.catering.activities.cart.model.PlaceOrderResponse;
import com.infovass.catering.activities.cart.model.PromoCodeResponse;
import com.infovass.catering.activities.cart.model.RemoveItemFromCart;
import com.infovass.catering.activities.cart.view.CartView;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.ServiceGenerator;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
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
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class CartImpl implements CartPresenter {

    private CartView views;

    public CartImpl(CartView views) {
        this.views = views;
    }

    @Override
    public void getUserCartApi(String token) {
        views.showLoading();
        WebService webService = ServiceGenerator.createService(WebService.class , token);
        JSONObject object = new JSONObject();
        Observable<CartResponse> observable = webService.getUserCart();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        views.showLoading();
                    }

                    @Override
                    public void onNext(CartResponse cartResponse) {
                        if (cartResponse.getStatus()) {
                            views.onSuccessGetCartAPi(cartResponse);
                        }
                        else
                        {
                            views.onSuccessGetCartAPi(cartResponse);}
                    }

                    @Override
                    public void onError(Throwable e) {
                        views.hideLoading();
                        Log.i("KUKUUUU","NA"+e.getMessage());
                        if (e instanceof HttpException) {
                            ResponseBody body = ((HttpException) e).response().errorBody();
                        }
                        if (e instanceof SocketTimeoutException) {//ClassNotFoundException
                            views.onFail(Constants.StatusMessage.TIMEOUT);
                        } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
                            views.onNoInternet();
                        } else {
                            views.onFail(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        views.hideLoading();
                    }
                });
    }

    @Override
    public void deleteCartItemApi(String token, String itemID) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            JSONObject object = new JSONObject();
            Observable<RemoveItemFromCart> observable = webService.removeItemToCartApi(itemID);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<RemoveItemFromCart>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.showLoading();
                        }

                        @Override
                        public void onNext(RemoveItemFromCart removeItemFromCart) {
                            if (removeItemFromCart.getStatus()) {
                                views.onSuccessDeleteItemCartAPi(removeItemFromCart);
                            }
                            else
                            {
                                views.onSuccessDeleteItemCartAPi(removeItemFromCart);}
                        }

                        @Override
                        public void onError(Throwable e) {
                            views.hideLoading();
                            Log.i("KUKUUUU","NA"+e.getMessage());
                            if (e instanceof HttpException) {
                                ResponseBody body = ((HttpException) e).response().errorBody();
                            }
                            if (e instanceof SocketTimeoutException) {//ClassNotFoundException
                                views.onFail(Constants.StatusMessage.TIMEOUT);
                            } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
                                views.onNoInternet();
                            } else {
                                views.onFail(e.getMessage());
                            }
                        }

                        @Override
                        public void onComplete() {
                            views.hideLoading();
                        }
                    });
        }catch (Exception k){}
    }

    @Override
    public void plaseOrderApi(String token, String address_id, String request_date_time,String payment_type,String time) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            HashMap<String, String> fields = new HashMap<>();
            fields.put("address_id", address_id);
            fields.put("request_date_time", request_date_time);
            fields.put("payment_type", payment_type);
            fields.put("time", time);
            Observable<PlaceOrderResponse> observable = webService.placeOrderAPI(fields);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<PlaceOrderResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.showLoading();
                        }

                        @Override
                        public void onNext(PlaceOrderResponse placeOrderResponse) {
                            if (placeOrderResponse.getStatus()) {
                                views.onSuccessPlaseOrderAPi(placeOrderResponse);
                            }
                            else
                            {
                                views.onSuccessPlaseOrderAPi(placeOrderResponse);}
                        }

                        @Override
                        public void onError(Throwable e) {
                            views.hideLoading();
                            Log.i("KUKUUUU","NA"+e.getMessage());
                            if (e instanceof HttpException) {
                                ResponseBody body = ((HttpException) e).response().errorBody();
                            }
                            if (e instanceof SocketTimeoutException) {//ClassNotFoundException
                                views.onFail(Constants.StatusMessage.TIMEOUT);
                            } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
                                views.onNoInternet();
                            } else {
                                views.onFail(e.getMessage());
                            }
                        }

                        @Override
                        public void onComplete() {
                            views.hideLoading();
                        }
                    });
        }catch (Exception k){}
    }

    @Override
    public void getUserPromoCode(String token, String code , String address_id) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            JSONObject object = new JSONObject();
//            SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.addressID, "" + list.get(position).getId());
            Observable<PromoCodeResponse> observable = webService.promoCode(code, address_id);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<PromoCodeResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.showLoading();
                        }

                        @Override
                        public void onNext(PromoCodeResponse promoCodeResponse) {
                            if (promoCodeResponse.getStatus()) {
                                views.onSuccessPromoCodeAPi(promoCodeResponse);
                            }
                            else
                            {
                                views.onSuccessPromoCodeAPi(promoCodeResponse);}
                        }

                        @Override
                        public void onError(Throwable e) {
                            views.hideLoading();
                            Log.i("KUKUUUU","NA"+e.getMessage());
                            if (e instanceof HttpException) {
                                ResponseBody body = ((HttpException) e).response().errorBody();
                            }
                            if (e instanceof SocketTimeoutException) {//ClassNotFoundException
                                views.onFail(Constants.StatusMessage.TIMEOUT);
                            } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
                                views.onNoInternet();
                            } else {
                                views.onFail(e.getMessage());
                            }
                        }

                        @Override
                        public void onComplete() {
                            views.hideLoading();
                        }
                    });
        }catch (Exception k){}

    }
}
