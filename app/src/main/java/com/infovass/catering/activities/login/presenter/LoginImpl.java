package com.infovass.catering.activities.login.presenter;

import com.infovass.catering.activities.login.model.ForGotPasswordResponse;
import com.infovass.catering.activities.login.model.LoginResponse;
import com.infovass.catering.activities.login.model.SignUPResponse;
import com.infovass.catering.activities.login.view.LoginViews;
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

public class LoginImpl implements LoginPresenter {

    private LoginViews views;

    public LoginImpl(LoginViews views) {
        this.views = views;
    }

    @Override
    public void callForgotPasswordApi(String email) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class);
            Observable<ForGotPasswordResponse> observable = webService.forgotPassword(email);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ForGotPasswordResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // views.hideLoading();
                        }

                        @Override
                        public void onNext(ForGotPasswordResponse forGotPasswordResponse) {
                            try
                            {
                                views.hideLoading();
                                if(forGotPasswordResponse.getStatus())
                                    views.onSuccessForgotpasswordPi(forGotPasswordResponse);
                                else
                                    views.onSuccessForgotpasswordPi(forGotPasswordResponse);
                            }catch (Exception e){}
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
        }catch (Exception j){}
    }

    @Override
    public void callLoginApi(String email, String password) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class);
            Observable<LoginResponse> observable = webService.loginAPI(email, password);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<LoginResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // views.hideLoading();
                        }

                        @Override
                        public void onNext(LoginResponse loginResponse) {
                            try
                            {
                                views.hideLoading();
                                if(loginResponse.getStatus())
                                    views.onSuccessLoginAPi(loginResponse);
                                else
                                    views.onSuccessLoginAPi(loginResponse);
                            }catch (Exception e){}
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
        }catch (Exception j){}
    }

    @Override
    public void callSignUpApi(String name , String email , String phone, String password , String confirm_password , String device_token , String device_type) {
        views.showLoading();
        WebService webService = ServiceGenerator.createService(WebService.class);
        Observable<SignUPResponse> observable = webService.signUpAPI(name, email , phone , password , confirm_password , device_token , device_type);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SignUPResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // views.hideLoading();
                    }

                    @Override
                    public void onNext(SignUPResponse signUPResponse) {
                        views.hideLoading();
                        if (signUPResponse.getStatus().equalsIgnoreCase("200"))
                            views.onSuccessSignUpAPi(signUPResponse);
                        else
                            views.onSuccessSignUpAPi(signUPResponse);
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

    }

}
