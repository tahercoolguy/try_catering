package com.infovass.catering.activities.fav.presenter;

import com.infovass.catering.activities.fav.model.FavListResponse;
import com.infovass.catering.activities.fav.view.FavViews;
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

public class FavImpl implements FavPresenter {

    private FavViews views;

    public FavImpl(FavViews views) {
        this.views = views;
    }

    @Override
    public void getFevListApi(String token) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            Observable<FavListResponse> observable = webService.getFavList();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<FavListResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // views.hideLoading();
                        }

                        @Override
                        public void onNext(FavListResponse favListResponse) {
                            try
                            {
                                views.hideLoading();
                                if(favListResponse.getStatus())
                                    views.onSuccessGetFavListAPi(favListResponse);
                                else
                                    views.onSuccessGetFavListAPi(favListResponse);
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
