package com.infovass.catering.activities.order;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.infovass.catering.R;
import com.infovass.catering.activities.adapers.OrderAdapter;
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.order.model.OrderListResponse;
import com.infovass.catering.activities.order.presenter.OrderImpl;
import com.infovass.catering.activities.order.presenter.OrderPresenter;
import com.infovass.catering.activities.order.view.OrderViews;
import com.infovass.catering.activities.utill.ProgressHUD;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderListActivity extends BaseActivity implements OrderViews {

    List<OrderListResponse.Datum> list = new ArrayList<>();
    private ProgressHUD progressHUD;
    OrderPresenter orderPresenter;
    OrderAdapter orderAdapter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        ButterKnife.bind(this);
        progressHUD = ProgressHUD.create(this, getString(R.string.loading), false, null, null);
        orderPresenter = new OrderImpl(this);
        orderPresenter.GetOrderListApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""));

        orderAdapter = new OrderAdapter(getApplicationContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(orderAdapter);
    }

    @OnClick({R.id.backButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButton:
                finish();
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onNoInternet() {

    }

    @Override
    public void onSuccessGetOrderListAPi(OrderListResponse orderListResponse) {
        try {
            if (orderListResponse.getStatus())
            {
                list.clear();
                if (orderListResponse.getData().size()==0) {

                }
                else
                {
                    list.addAll(orderListResponse.getData());
                    orderAdapter.notifyDataSetChanged();
                }
            }else
            {
                Toast.makeText(getActivityContext() , orderListResponse.getMessage() , Toast.LENGTH_SHORT).show();
            }

        }catch (Exception f){}
    }
}