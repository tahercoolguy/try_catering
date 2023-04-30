package com.infovass.catering.activities.cart.presenter;

import android.util.Log;

import com.infovass.catering.activities.cart.model.PaymentResponse;
import com.infovass.catering.activities.cart.model.PlaceOrderResponse;
import com.infovass.catering.activities.cart.view.CartView;
import com.infovass.catering.activities.cart.view.PaymentView;
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
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class PaymentImpl implements PaymentPresenter{
    private PaymentView views;
    public PaymentImpl(PaymentView views) {
        this.views = views;
    }
    @Override
    public void getPayment(String token, String order_id, String payment_id, Boolean payment_status,String transaction_number,String track_id, String invoice_id) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            JSONObject object = new JSONObject();
            Observable<PaymentResponse> observable = webService.updatePayment(invoice_id,payment_id,payment_status,track_id,transaction_number);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<PaymentResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.showLoading();
                        }

                        @Override
                        public void onNext(PaymentResponse placeOrderResponse) {
                            if (placeOrderResponse.getStatus()) {
                                views.onSuccessGetPayment(placeOrderResponse);
                            }
                            else
                            {
                                views.onSuccessGetPayment(placeOrderResponse);}
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
