package com.infovass.catering.activities.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
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

public class OrderListActivity extends AppCompatActivity implements OrderViews {

    List<OrderListResponse.Datum> list = new ArrayList<>();
    private ProgressHUD progressHUD;
    OrderPresenter orderPresenter;
    OrderAdapter orderAdapter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Context context;
    Activity activity;
//    @Override
//    protected Context getActivityContext() {
//        return this;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        ButterKnife.bind(this);
        context=getApplicationContext();
        progressHUD = ProgressHUD.create(this, getString(R.string.loading), false, null, null);
        orderPresenter = new OrderImpl(this);
        orderPresenter.GetOrderListApi(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.TOKEN, ""));

        orderAdapter = new OrderAdapter(context,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(orderAdapter);

        orderAdapter.setOnItemClickListener(new OrderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String id) {
                id=id;
                startActivity(new Intent(OrderListActivity.this,OrderDetailActivity.class).putExtra("id",id));
                overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

            }
        });

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
                Toast.makeText(getApplicationContext() , orderListResponse.getMessage() , Toast.LENGTH_SHORT).show();
            }

        }catch (Exception f){}
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
    }
}