package com.infovass.catering.activities.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.activities.Location.model.AreaList;
import com.infovass.catering.activities.Location.model.CityList;
import com.infovass.catering.activities.adapers.AddressAdapter;
import com.infovass.catering.activities.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.infovass.catering.R;
import com.infovass.catering.activities.cart.view.CartActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.profile.model.AddAddressResponse;
import com.infovass.catering.activities.profile.model.AddressResponse;
import com.infovass.catering.activities.profile.model.DefaultAddressResponse;
import com.infovass.catering.activities.profile.presenter.AddressImpl;
import com.infovass.catering.activities.profile.presenter.AddressPresenter;
import com.infovass.catering.activities.profile.view.AddAddressActivity;
import com.infovass.catering.activities.profile.view.AddressViews;
import com.infovass.catering.activities.utill.ProgressHUD;

import java.util.ArrayList;
import java.util.List;

public class AddressActivity extends BaseActivity implements AddressViews {

    List<AddressResponse.Datum> list = new ArrayList<>();
    AddressPresenter addressPresenter;
    private ProgressHUD progressHUD;
    @BindView(R.id.rec_address)
    RecyclerView rec_address;
    @BindView(R.id.rel_findFood)
    RelativeLayout rel_findFood;
    AddressAdapter addressAdapter;
    @BindView(R.id.backButton)
    ImageButton backButton;
    String date, time;

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @OnClick({R.id.rel_findFood, R.id.backButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_findFood:
                try {
                    Intent intent = new Intent(AddressActivity.this, AddAddressActivity.class);
                    startActivity(intent);
                } catch (Exception g) {
                }
                break;

            case R.id.backButton:
                try {
                    finish();
                } catch (Exception g) {
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        progressHUD = ProgressHUD.create(this, getString(R.string.loading), false, null, null);
        addressPresenter = new AddressImpl(this);
        addressPresenter.addressListApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""));
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            date = bundle.getString("date");
            time = bundle.getString("time");
        }

        addressAdapter = new AddressAdapter(getApplicationContext(), list);
        rec_address.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rec_address.hasFixedSize();
        rec_address.setAdapter(addressAdapter);
        addressAdapter.setOnItemClickListener(new AddressAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.ClassName, "").equalsIgnoreCase("cart")) {
                    SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.addressID, "" + list.get(position).getId());
                    SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.address, "" + list.get(position).getAddress());
                    Bundle bundle = new Bundle();
                    bundle.putString("date", date);
                    bundle.putString("time", time);
                    Intent intent = new Intent(AddressActivity.this, CartActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
                //addressPresenter.setDefaultAddressApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, "") , ""+list.get(position).getId());
            }
        });
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
    public void onSuccessGetAddressAPi(AddressResponse addressResponse) {
        try {
            if (addressResponse.getStatus()) {
                list.clear();
                if (addressResponse.getData().size() == 0) {

                } else {
                    list.addAll(addressResponse.getData());
                    addressAdapter.notifyDataSetChanged();
                    Log.i("SIZEEEE", "" + list.size());
                }
            } else {
                Toast.makeText(getActivityContext(), addressResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

        } catch (Exception f) {
        }
    }

    @Override
    public void onSuccessSetDefaultAddressAPi(DefaultAddressResponse defaultAddressResponse) {
        try {
            if (defaultAddressResponse.getStatus()) {
                Intent intent = new Intent(AddressActivity.this, CartActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "" + defaultAddressResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

        } catch (Exception j) {
        }
    }

    @Override
    public void onSuccessGetCityListAPi(CityList cityList) {

    }

    @Override
    public void onSuccessGetAreaListAPi(AreaList areaList) {

    }

    @Override
    public void onSuccessAddAddressAPi(AddAddressResponse addressResponse) {

    }
}