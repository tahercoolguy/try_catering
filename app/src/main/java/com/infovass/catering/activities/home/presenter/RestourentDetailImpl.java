package com.infovass.catering.activities.home.presenter;

import android.util.Log;

import com.infovass.catering.activities.home.model.AddtoFebRestourentResponse;
import com.infovass.catering.activities.home.model.RestourentAddToFevResponse;
import com.infovass.catering.activities.home.model.RestourentDetailResponse;
import com.infovass.catering.activities.home.model.RestourentModeResponse;
import com.infovass.catering.activities.home.view.RestourentDetailView;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.ServiceGenerator;
import com.infovass.catering.activities.network.WebService;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;

public class RestourentDetailImpl implements RestourentDetailPresenter {

    private RestourentDetailView views;

    public RestourentDetailImpl(RestourentDetailView views) {
        this.views = views;
    }

    @Override
    public void getRestourentDetailApi(String token , String id) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            Observable<RestourentDetailResponse> observable = webService.restourentDetailApi(id);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<RestourentDetailResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                             views.hideLoading();
                        }

                        @Override
                        public void onNext(RestourentDetailResponse restourentDetailResponse) {
                            try
                            {
                                Log.i("TYRRR" , "reererwrew");
                                views.hideLoading();
                                if(restourentDetailResponse.getStatus())
                                    views.onSuccessGetRestourentDetailAPi(restourentDetailResponse);
                                else
                                    views.onSuccessGetRestourentDetailAPi(restourentDetailResponse);
                            }catch (Exception e){}
                        }

                        @Override
                        public void onError(Throwable e) {
                            views.hideLoading();
                            Log.i("TYRRR" , e.toString());
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
            Log.i("TYRRR" , j.getMessage());
        }
    }

    @Override
    public void getRestourentDetailApi(String token ,String id , String mode_type) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("mode_type", "1");

            String po = jsonObj.toString();
            //   String Checker = gson.toJson(jsonObject);
            TypedInput in = null;
            try {
                in = new TypedByteArray("application/json", po.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            Observable<RestourentModeResponse> observable = webService.restourentDetailApi(id , in);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<RestourentModeResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.hideLoading();
                        }

                        @Override
                        public void onNext(RestourentModeResponse restourentModeResponse) {
                            try
                            {
                                views.hideLoading();
                                if(restourentModeResponse.getStatus())
                                    views.onSuccessGetRestourentModeAPi(restourentModeResponse);
                                else
                                    views.onSuccessGetRestourentModeAPi(restourentModeResponse);
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
    public void addToFevCatererApi(String token, String caterer_id) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            HashMap<String, String> fields = new HashMap<>();
            fields.put("caterer_id", caterer_id);
            Observable<RestourentAddToFevResponse> observable = webService.addToFevCatererApi(fields);
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
                                    views.onSuccessAddToFevRestourentAPi(restourentAddToFevResponse);
                                else
                                    views.onSuccessAddToFevRestourentAPi(restourentAddToFevResponse);
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
    public void getRestourentAddToFavApi(String caterer_id) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class);
            JSONObject object = new JSONObject();
            object.put("caterer_id", caterer_id);
            Observable<AddtoFebRestourentResponse> observable = webService.addToFevrestourentApi(caterer_id);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<AddtoFebRestourentResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.hideLoading();
                        }

                        @Override
                        public void onNext(AddtoFebRestourentResponse addtoFebRestourentResponse) {
                            try
                            {
//                                views.hideLoading();
//                                if(restourentDetailResponse.getStatus())
//                                    views.onSuccessAddToFevRestourentModeAPi(addtoFebRestourentResponse);
//                                else
//                                    views.onSuccessAddToFevRestourentModeAPi(addtoFebRestourentResponse);
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
