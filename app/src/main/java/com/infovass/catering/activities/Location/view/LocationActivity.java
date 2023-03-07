package com.infovass.catering.activities.Location.view;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.infovass.catering.BuildConfig;
import com.infovass.catering.R;
import com.infovass.catering.activities.Location.model.AreaList;
import com.infovass.catering.activities.Location.model.CityList;
import com.infovass.catering.activities.Location.presenter.LocationImpl;
import com.infovass.catering.activities.Location.presenter.LocationPresenter;
import com.infovass.catering.activities.MainActivity;
import com.infovass.catering.activities.adapers.CityAdapter;
import com.infovass.catering.activities.adapers.ExpandableListAdapter;
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.AppSettings;
import com.infovass.catering.activities.utill.ProgressHUD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LocationActivity extends BaseActivity implements LocationViews {

    Boolean selectAreaStatus = false;
    List<CityList.Result> list = new ArrayList<>();
    LocationPresenter locationPresenter;
    private ProgressHUD progressHUD;
    CityAdapter cityAdapter;
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

    public void LocationActivity(){}

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        ButterKnife.bind(this);
        progressHUD = ProgressHUD.create(this, getString(R.string.loading), false, null, null);
        locationPresenter = new LocationImpl(this);
        locationPresenter.getCityListApi();
        // preparing list data
        //       prepareListData();
//        listAdapter = new ExpandableListAdapter(LocationActivity.this, listDataHeader, listDataChild);
//        // setting list adapter
//        exp_listView.setAdapter(listAdapter);

        cityAdapter = new CityAdapter(getApplicationContext() , list);
        rec_city.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rec_city.setAdapter(cityAdapter);
        cityAdapter.setOnItemClickListener(new CityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_CITY_ID, ""+list.get(position).getId());
                for(int i = 0 ;i<list.size() ;i++)
                {
                    list.get(i).setSelected(false);
                }
                list.get(position).setSelected(!list.get(position).isSelected());
                cityAdapter.notifyDataSetChanged();
                selectAreaStatus= true;
            }
        });
        UpdateLocation();
    }

    public  void UpdateLocation(){
        Intent intent= getIntent();
        if(intent!=null){
            newlocation=intent.getStringExtra("newlocation");
        }
    }



    private void setLanguageResource(String language_code) {
        Resources res = getResources();
        // Change locale main_settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = new Locale(language_code.toLowerCase());
        res.updateConfiguration(conf, dm);
    }

    @OnClick({R.id.rel_findFood , R.id.tv_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_skip:
                try {
                    Intent intent = new Intent(LocationActivity.this  , MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                    finish();
                }catch (Exception g) {}
                break;

            case R.id.rel_findFood:
                try {
                    if(selectAreaStatus) {
                        Intent intent = new Intent(LocationActivity.this, AreaActivity.class);
                        intent.putExtra("newlocation",newlocation);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                        finish();
                    }else {
                        Toast.makeText(LocationActivity.this, "Please Select Area First.", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception g) {}
                break;

        }
    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add(getResources().getString(R.string.hawalli));
        listDataHeader.add(getResources().getString(R.string.bayan));
        listDataHeader.add(getString(R.string.mishref));
        listDataHeader.add(getString(R.string.maidan_hawalli));
        listDataHeader.add(getString(R.string.Jabriya));
        listDataHeader.add(getString(R.string.rumaithiya));
        listDataHeader.add(getString(R.string.salmiya));


        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add(getString(R.string.al_asimah));
        top250.add(getString(R.string.Jabriya));
        top250.add(getResources().getString(R.string.hawalli));
        top250.add(getString(R.string.farwaniyah));
        top250.add(getString(R.string.kabeer));
        top250.add(getString(R.string.ahmadi));
        top250.add(getString(R.string.al_asimah));
        top250.add(getString(R.string.Jahra));
        top250.add(getResources().getString(R.string.hawalli));
        top250.add(getString(R.string.al_asimah));
        top250.add(getString(R.string.Jabriya));
        top250.add(getResources().getString(R.string.hawalli));
        top250.add(getString(R.string.farwaniyah));
        top250.add(getString(R.string.kabeer));
        top250.add(getString(R.string.ahmadi));
        top250.add(getString(R.string.al_asimah));
        top250.add(getString(R.string.Jahra));
        top250.add(getResources().getString(R.string.hawalli));
        top250.add(getString(R.string.al_asimah));
        top250.add(getString(R.string.Jabriya));
        top250.add(getResources().getString(R.string.hawalli));
        top250.add(getString(R.string.farwaniyah));
        top250.add(getString(R.string.kabeer));
        top250.add(getString(R.string.ahmadi));
        top250.add(getString(R.string.al_asimah));
        top250.add(getString(R.string.Jahra));
        top250.add(getResources().getString(R.string.hawalli));

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add(getString(R.string.al_asimah));
        nowShowing.add(getString(R.string.Jabriya));
        nowShowing.add(getResources().getString(R.string.hawalli));
        nowShowing.add(getString(R.string.farwaniyah));
        nowShowing.add(getString(R.string.kabeer));
        nowShowing.add(getString(R.string.ahmadi));
        nowShowing.add(getString(R.string.al_asimah));
        nowShowing.add(getString(R.string.Jahra));
        nowShowing.add(getResources().getString(R.string.hawalli));
        nowShowing.add(getString(R.string.al_asimah));
        nowShowing.add(getString(R.string.Jabriya));
        nowShowing.add(getResources().getString(R.string.hawalli));
        nowShowing.add(getString(R.string.farwaniyah));
        nowShowing.add(getString(R.string.kabeer));
        nowShowing.add(getString(R.string.ahmadi));
        nowShowing.add(getString(R.string.al_asimah));
        nowShowing.add(getString(R.string.Jahra));
        nowShowing.add(getResources().getString(R.string.hawalli));
        nowShowing.add(getString(R.string.al_asimah));
        nowShowing.add(getString(R.string.Jabriya));
        nowShowing.add(getResources().getString(R.string.hawalli));
        nowShowing.add(getString(R.string.farwaniyah));
        nowShowing.add(getString(R.string.kabeer));
        nowShowing.add(getString(R.string.ahmadi));
        nowShowing.add(getString(R.string.al_asimah));
        nowShowing.add(getString(R.string.Jahra));
        nowShowing.add(getResources().getString(R.string.hawalli));

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add(getString(R.string.al_asimah));
        comingSoon.add(getString(R.string.Jabriya));
        comingSoon.add(getResources().getString(R.string.hawalli));
        comingSoon.add(getString(R.string.farwaniyah));
        comingSoon.add(getString(R.string.kabeer));
        comingSoon.add(getString(R.string.ahmadi));
        comingSoon.add(getString(R.string.al_asimah));
        comingSoon.add(getString(R.string.Jahra));
        comingSoon.add(getResources().getString(R.string.hawalli));
        comingSoon.add(getString(R.string.al_asimah));
        comingSoon.add(getString(R.string.Jabriya));
        comingSoon.add(getResources().getString(R.string.hawalli));
        comingSoon.add(getString(R.string.farwaniyah));
        comingSoon.add(getString(R.string.kabeer));
        comingSoon.add(getString(R.string.ahmadi));
        comingSoon.add(getString(R.string.al_asimah));
        comingSoon.add(getString(R.string.Jahra));
        comingSoon.add(getResources().getString(R.string.hawalli));
        comingSoon.add(getString(R.string.al_asimah));
        comingSoon.add(getString(R.string.Jabriya));
        comingSoon.add(getResources().getString(R.string.hawalli));
        comingSoon.add(getString(R.string.farwaniyah));
        comingSoon.add(getString(R.string.kabeer));
        comingSoon.add(getString(R.string.ahmadi));
        comingSoon.add(getString(R.string.al_asimah));
        comingSoon.add(getString(R.string.Jahra));
        comingSoon.add(getResources().getString(R.string.hawalli));

        List<String> comingSoons = new ArrayList<String>();
        comingSoons.add(getString(R.string.al_asimah));
        comingSoons.add(getString(R.string.Jabriya));
        comingSoons.add(getResources().getString(R.string.hawalli));
        comingSoons.add(getString(R.string.farwaniyah));
        comingSoons.add(getString(R.string.kabeer));
        comingSoons.add(getString(R.string.ahmadi));
        comingSoons.add(getString(R.string.al_asimah));
        comingSoons.add(getString(R.string.Jahra));
        comingSoons.add(getResources().getString(R.string.hawalli));
        comingSoons.add(getString(R.string.al_asimah));
        comingSoons.add(getString(R.string.Jabriya));
        comingSoons.add(getResources().getString(R.string.hawalli));
        comingSoons.add(getString(R.string.farwaniyah));
        comingSoons.add(getString(R.string.kabeer));
        comingSoons.add(getString(R.string.ahmadi));
        comingSoons.add(getString(R.string.al_asimah));
        comingSoons.add(getString(R.string.Jahra));
        comingSoons.add(getResources().getString(R.string.hawalli));
        comingSoons.add(getString(R.string.al_asimah));
        comingSoons.add(getString(R.string.Jabriya));
        comingSoons.add(getResources().getString(R.string.hawalli));
        comingSoons.add(getString(R.string.farwaniyah));
        comingSoons.add(getString(R.string.kabeer));
        comingSoons.add(getString(R.string.ahmadi));
        comingSoons.add(getString(R.string.al_asimah));
        comingSoons.add(getString(R.string.Jahra));
        comingSoons.add(getResources().getString(R.string.hawalli));

        List<String> comingSoonss = new ArrayList<String>();
        comingSoonss.add(getString(R.string.al_asimah));
        comingSoonss.add(getString(R.string.Jabriya));
        comingSoonss.add(getResources().getString(R.string.hawalli));
        comingSoonss.add(getString(R.string.farwaniyah));
        comingSoonss.add(getString(R.string.kabeer));
        comingSoonss.add(getString(R.string.ahmadi));
        comingSoonss.add(getString(R.string.al_asimah));
        comingSoonss.add(getString(R.string.Jahra));
        comingSoonss.add(getResources().getString(R.string.hawalli));
        comingSoonss.add(getString(R.string.al_asimah));
        comingSoonss.add(getString(R.string.Jabriya));
        comingSoonss.add(getResources().getString(R.string.hawalli));
        comingSoonss.add(getString(R.string.farwaniyah));


        List<String> comingSoonsss = new ArrayList<String>();
        comingSoonsss.add(getString(R.string.al_asimah));
        comingSoonsss.add(getString(R.string.Jabriya));
        comingSoonsss.add(getResources().getString(R.string.hawalli));
        comingSoonsss.add(getString(R.string.farwaniyah));
        comingSoonsss.add(getString(R.string.kabeer));
        comingSoonsss.add(getString(R.string.ahmadi));
        comingSoonsss.add(getString(R.string.al_asimah));
        comingSoonsss.add(getString(R.string.Jahra));
        comingSoonsss.add(getResources().getString(R.string.hawalli));
        comingSoonsss.add(getString(R.string.al_asimah));
        comingSoonsss.add(getString(R.string.Jabriya));
        comingSoonsss.add(getResources().getString(R.string.hawalli));
        comingSoonsss.add(getString(R.string.farwaniyah));

        List<String> comingSoonssss = new ArrayList<String>();
        comingSoonssss.add(getString(R.string.ahmadi));
        comingSoonssss.add(getString(R.string.al_asimah));
        comingSoonssss.add(getString(R.string.Jahra));
        comingSoonssss.add(getResources().getString(R.string.hawalli));
        comingSoonssss.add(getString(R.string.al_asimah));
        comingSoonssss.add(getString(R.string.Jabriya));
        comingSoonssss.add(getResources().getString(R.string.hawalli));
        comingSoonssss.add(getString(R.string.farwaniyah));

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), comingSoons);
        listDataChild.put(listDataHeader.get(4), comingSoonss);
        listDataChild.put(listDataHeader.get(5), comingSoonsss);
        listDataChild.put(listDataHeader.get(6), comingSoonssss);
    }

    @Override
    public void onSuccessGetCityListAPi(CityList cityList) {
        try {
            if(cityList.getStatus()) {
                list.clear();
                if (cityList.getResult().size() == 0) {
                } else {
                    list.addAll(cityList.getResult());
                    cityAdapter.notifyDataSetChanged();
                }
            }
        }catch (Exception ignore){}
    }

    @Override
    public void onSuccessGetAreaListAPi(AreaList areaList) {
    }

    @Override
    public void showLoading() {
        try {
            progressHUD.show();
        }catch (Exception f){}
    }

    @Override
    public void hideLoading() {
        try {
            progressHUD.dismiss();
        }catch (Exception f){}
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