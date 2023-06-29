package com.infovass.catering.activities.Location.view;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.infovass.catering.R;
import com.infovass.catering.activities.CalenderActivity;
import com.infovass.catering.activities.Location.model.AreaList;
import com.infovass.catering.activities.Location.model.CityList;
import com.infovass.catering.activities.Location.presenter.LocationImpl;
import com.infovass.catering.activities.Location.presenter.LocationPresenter;
import com.infovass.catering.activities.MainActivity;
import com.infovass.catering.activities.adapers.AreaAdapter;
import com.infovass.catering.activities.adapers.ExpandableListAdapter;
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.ProgressHUD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AreaActivity extends BaseActivity implements LocationViews {

    Boolean selectAreaStatus = false;
    List<AreaList.Result> list = new ArrayList<>();
    LocationPresenter locationPresenter;
    private ProgressHUD progressHUD;
    AreaAdapter areaAdapter;
    ExpandableListAdapter listAdapter;
    @BindView(R.id.rec_city)
    RecyclerView rec_city;
    @BindView(R.id.exp_listView)
    ExpandableListView exp_listView;
    @BindView(R.id.rel_findFood)
    RelativeLayout rel_findFood;
    @BindView(R.id.tv_skip)
    AppCompatTextView tv_skip;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    String newlocation;

    @Override

    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        ButterKnife.bind(this);
        progressHUD = ProgressHUD.create(this, getString(R.string.loading), false, null, null);
        locationPresenter = new LocationImpl(this);
        locationPresenter.getArealistApi(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_CITY_ID, ""));
        // preparing list data
        //       prepareListData();
//        listAdapter = new ExpandableListAdapter(LocationActivity.this, listDataHeader, listDataChild);
//        // setting list adapter
//        exp_listView.setAdapter(listAdapter);

        areaAdapter = new AreaAdapter(getApplicationContext(), list);
        rec_city.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rec_city.setAdapter(areaAdapter);
        areaAdapter.setOnItemClickListener(new AreaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                if (SharedPreferencesUtils.getInstance(AreaActivity.this).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                    SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_ARABIC_AREA_NAME, "" + list.get(position).getArabicName());
                    SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_AREA_NAME, "" + list.get(position).getName());
                } else {
                    SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_AREA_NAME, "" + list.get(position).getName());
                    SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_ARABIC_AREA_NAME, "" + list.get(position).getArabicName());

                }

                SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_AREA_ID, "" + list.get(position).getId());
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setSelected(false);
                }
                list.get(position).setSelected(!list.get(position).isSelected());
                areaAdapter.notifyDataSetChanged();
                selectAreaStatus = true;
            }
        });
        UpdateLocation();

    }

    public void UpdateLocation() {
        Intent intent = getIntent();
        if (intent != null) {
            newlocation = intent.getStringExtra("newlocationArea");
        }
    }

    @OnClick({R.id.rel_findFood, R.id.tv_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_skip:
                try {
                    Intent intent = new Intent(AreaActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                    finish();
                } catch (Exception g) {
                }
                break;

            case R.id.rel_findFood:
                try {
                    if (selectAreaStatus) {

                        if (newlocation != null) {
                            Intent intent = new Intent();
                            intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                            intent.putExtra("newlocationArea", newlocation);
                            setResult(RESULT_OK, intent);

                            finish();
                        } else {
                            Intent intent = new Intent(AreaActivity.this, CalenderActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                            finish();
                        }


                    } else {
                        Toast.makeText(AreaActivity.this, "Please Select City First.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception g) {
                }
                break;

        }
    }

    @Override
    public void onSuccessGetCityListAPi(CityList cityList) {
    }

    @Override
    public void onSuccessGetAreaListAPi(AreaList areaList) {
        try {
            list.clear();
            if (areaList.getResult().size() == 0) {
//                lnr_noProduct.setVisibility(View.VISIBLE);
//                lnr_main.setVisibility(View.GONE);
            } else {
//                lnr_noProduct.setVisibility(View.GONE);
//                lnr_main.setVisibility(View.VISIBLE);
                list.addAll(areaList.getResult());
                areaAdapter.notifyDataSetChanged();
            }

        } catch (Exception ignore) {
        }
    }


    @Override
    public void showLoading() {
        try {
            //progressHUD.show();
        } catch (Exception f) {
        }
    }

    @Override
    public void hideLoading() {
        try {
            progressHUD.dismiss();
        } catch (Exception f) {
        }
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onNoInternet() {

    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
    }
}