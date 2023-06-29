package com.infovass.catering.activities.home.presenter;

import com.infovass.catering.activities.home.model.RestourentListResponse;
import com.infovass.catering.activities.home.view.RestourentView;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.ServiceGenerator;
import com.infovass.catering.activities.network.WebService;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RestourentImpl implements RestourentPresenter {

    private RestourentView views;

    public RestourentImpl(RestourentView views) {
        this.views = views;
    }

    @Override
    public void getRestourentlistApi(String mode_type, String area_id, String date) {
        try {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class);
            Observable<RestourentListResponse> observable = webService.restourentList(mode_type, area_id, date);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<RestourentListResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // No action needed
                        }

                        @Override
                        public void onNext(RestourentListResponse restourentListResponse) {
                            try {
                                if (restourentListResponse.getStatus()) {
                                    views.onSuccessGetRestourentListAPi(restourentListResponse);
                                } else {
                                    views.onFail(restourentListResponse.getMessage());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            views.hideLoading();

                            if (e instanceof SocketTimeoutException) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getRestourentlist_Api(String date) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class);
            Observable<RestourentListResponse> observable = webService.restouren_tList(date);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<RestourentListResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // views.hideLoading();
                        }

                        @Override
                        public void onNext(RestourentListResponse restourentListResponse) {
                            try
                            {
                                views.hideLoading();
                                if(restourentListResponse.getStatus())
                                    views.onSuccessGetRestourentListAPi(restourentListResponse);
                                else
                                    views.onSuccessGetRestourentListAPi(restourentListResponse);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            views.hideLoading();

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
            j.printStackTrace();
        }
    }

}