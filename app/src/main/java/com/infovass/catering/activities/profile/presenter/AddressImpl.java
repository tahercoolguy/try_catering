package com.infovass.catering.activities.profile.presenter;

import android.util.Log;

import com.infovass.catering.activities.Location.model.AreaList;
import com.infovass.catering.activities.Location.model.CityList;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.ServiceGenerator;
import com.infovass.catering.activities.network.WebService;
import com.infovass.catering.activities.profile.model.AddAddressResponse;
import com.infovass.catering.activities.profile.model.AddressResponse;
import com.infovass.catering.activities.profile.model.DefaultAddressResponse;
import com.infovass.catering.activities.profile.view.AddressViews;

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

public class AddressImpl implements AddressPresenter {

    private AddressViews views;

    public AddressImpl(AddressViews views) {
        this.views = views;
    }

    @Override
    public void addressListApi(String token) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            Observable<AddressResponse> observable = webService.getUserAddresses();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<AddressResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // views.hideLoading();
                        }

                        @Override
                        public void onNext(AddressResponse addressResponse) {
                            try
                            {
                                views.hideLoading();
                                if(addressResponse.getStatus())
                                    views.onSuccessGetAddressAPi(addressResponse);
                                else
                                    views.onSuccessGetAddressAPi(addressResponse);
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
                             views.hideLoading();
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
    public void setDefaultAddressApi(String token, String address_id) {
        try
        {
            Log.i("TKTTKTKKTK" , token);
            Log.i("ADDRESSSS" , address_id);
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
//            JSONObject postData = new JSONObject();
//            postData.put("address_id", address_id);

            HashMap<String, String> fields = new HashMap<>();
            fields.put("address_id", address_id);

            Observable<DefaultAddressResponse> observable = webService.setDefaultAddressApi(fields);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<DefaultAddressResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            views.hideLoading();
                        }

                        @Override
                        public void onNext(DefaultAddressResponse defaultAddressResponse) {
                            try
                            {
                                views.hideLoading();
                                if(defaultAddressResponse.getStatus())
                                    views.onSuccessSetDefaultAddressAPi(defaultAddressResponse);
                                else
                                    views.onSuccessSetDefaultAddressAPi(defaultAddressResponse);
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

    @Override
    public void AddAddressApi(String token ,String first_name, String last_name, String house_no, String contact_no, String appartment, String landmark, String pincode, String address_type, String address, String lat, String lng, String city_id, String area_id, String piece, String avenue, String street) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            Observable<AddAddressResponse> observable = webService.addAddressAPI(first_name,last_name,house_no ,contact_no ,appartment , landmark , pincode , address_type , address , lat ,lng ,city_id , area_id , piece , avenue , street );
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<AddAddressResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // views.hideLoading();
                        }

                        @Override
                        public void onNext(AddAddressResponse addressResponse) {
                            try
                            {

                                views.hideLoading();
                                if(addressResponse.getStatus())

                                    views.onSuccessAddAddressAPi(addressResponse);
                                else
                                    views.onSuccessAddAddressAPi(addressResponse);
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
        }catch (Exception j){
            Log.i("Yhan", j.getMessage());
        }
    }
}
