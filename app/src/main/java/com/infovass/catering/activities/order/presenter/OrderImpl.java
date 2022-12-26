package com.infovass.catering.activities.order.presenter;

import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.ServiceGenerator;
import com.infovass.catering.activities.network.WebService;
import com.infovass.catering.activities.order.model.OrderListResponse;
import com.infovass.catering.activities.order.view.OrderViews;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderImpl implements OrderPresenter {

    private OrderViews views;

    public OrderImpl(OrderViews views) {
        this.views = views;
    }

    @Override
    public void GetOrderListApi(String token) {
        try
        {
            views.showLoading();
            WebService webService = ServiceGenerator.createService(WebService.class , token);
            Observable<OrderListResponse> observable = webService.getOrderList();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<OrderListResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            // views.hideLoading();
                        }

                        @Override
                        public void onNext(OrderListResponse orderListResponse) {
                            try
                            {
                                views.hideLoading();
                                if(orderListResponse.getStatus())
                                    views.onSuccessGetOrderListAPi(orderListResponse);
                                else
                                    views.onSuccessGetOrderListAPi(orderListResponse);
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
