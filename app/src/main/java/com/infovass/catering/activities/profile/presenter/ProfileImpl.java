package com.infovass.catering.activities.profile.presenter;

import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.ServiceGenerator;
import com.infovass.catering.activities.network.WebService;
import com.infovass.catering.activities.profile.model.PagesResponse;
import com.infovass.catering.activities.profile.model.ProfileResponse;
import com.infovass.catering.activities.profile.view.ProfileViews;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProfileImpl implements ProfilePresenter {

    private ProfileViews views;

    public ProfileImpl(ProfileViews views) {
        this.views = views;
    }

    @Override
    public void GetUserProfileApi(String user_id) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class);
            Observable<ProfileResponse> observable = webService.GetUserProfile(user_id);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ProfileResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // views.hideLoading();
                        }

                        @Override
                        public void onNext(ProfileResponse profileResponse) {
                            try
                            {
                                views.hideLoading();
                                if(profileResponse.getStatus().equalsIgnoreCase("200"))
                                    views.onSuccessGetProfileAPi(profileResponse);
                                else
                                    views.onSuccessGetProfileAPi(profileResponse);
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
    public void GetTermAndConditionApi()
    {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class);
            Observable<PagesResponse> observable = webService.getPages();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<PagesResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // views.hideLoading();
                        }

                        @Override
                        public void onNext(PagesResponse pagesResponse) {
                            try
                            {
                                views.hideLoading();
                                if(pagesResponse.getStatus())
                                    views.onSuccessPagesAPi(pagesResponse);
                                else
                                    views.onSuccessPagesAPi(pagesResponse);
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

}
