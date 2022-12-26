package com.infovass.catering.activities.Location.presenter;

import android.util.Log;

import com.infovass.catering.activities.Location.model.AreaList;
import com.infovass.catering.activities.Location.model.CityList;
import com.infovass.catering.activities.Location.view.LocationViews;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.ServiceGenerator;
import com.infovass.catering.activities.network.WebService;

import org.json.JSONObject;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class LocationImpl implements LocationPresenter {

    private LocationViews views;

    public LocationImpl(LocationViews views) {
        this.views = views;
    }

    @Override
    public void getArealistApi(String city_id) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class);
            Observable<AreaList> observable = webService.areaAPI(city_id);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<AreaList>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // views.hideLoading();
                        }

                        @Override
                        public void onNext(AreaList areaList) {
                            try
                            {
                                views.hideLoading();
                                if(areaList.getStatus().equalsIgnoreCase("200"))
                                    views.onSuccessGetAreaListAPi(areaList);
                                else
                                    views.onSuccessGetAreaListAPi(areaList);
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
    public void getCityListApi() {
        views.showLoading();
        WebService webService = ServiceGenerator.createService(WebService.class);
        JSONObject object = new JSONObject();
        Observable<CityList> observable = webService.getCityList();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CityList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        views.showLoading();
                    }

                    @Override
                    public void onNext(CityList cityList) {
                        if (cityList.getStatus()) {
                            Log.i("KUKUUUU", "OKKK");
                            views.onSuccessGetCityListAPi(cityList);
                        }
                        else
                        {
                            Log.i("KUKUUUU","NA");
                            views.onSuccessGetCityListAPi(cityList);}
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
}

