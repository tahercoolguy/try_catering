package com.infovass.catering.activities.home.view;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.infovass.catering.R;
import com.infovass.catering.activities.adapers.DetailAdapter;

import com.infovass.catering.activities.adapers.MainCategoriesAdapter;
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.dialog.BottomSheetInfoFragment;
import com.infovass.catering.activities.home.adapter.RestourentDetailsImageBanner;
import com.infovass.catering.activities.home.model.AddtoFebRestourentResponse;
import com.infovass.catering.activities.home.model.RestourentAddToFevResponse;
import com.infovass.catering.activities.home.model.RestourentDetailResponse;
import com.infovass.catering.activities.home.model.RestourentModeResponse;
import com.infovass.catering.activities.home.presenter.RestourentDetailImpl;
import com.infovass.catering.activities.home.presenter.RestourentDetailPresenter;
import com.infovass.catering.activities.login.view.LoginActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.ProgressHUD;
import com.squareup.picasso.Picasso;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RestourentDetailActivity extends BaseActivity implements RestourentDetailView {

    boolean addToFev = false;
    RestourentDetailPresenter restourentDetailPresenter;
    int modefirstItem = 0;
    String modeType = "";
    @BindView(R.id.detail_recyclerView)
    RecyclerView detail_recyclerView;
    @BindView(R.id.recyclerViewMenu)
    RecyclerView recyclerViewMenu;
    @BindView(R.id.backButton)
    ImageButton backButton;
    @BindView(R.id.resturantNameTextView)
    AppCompatTextView resturantNameTextView;
    @BindView(R.id.resturantdetail)
    AppCompatTextView resturantdetail;
    @BindView(R.id.restourentRatingBar)
    RatingBar restourentRatingBar;
    @BindView(R.id.tv_minOrder)
    AppCompatTextView tv_minOrder;
    @BindView(R.id.tv_minNots)
    AppCompatTextView tv_minNots;
    @BindView(R.id.tv_deleveryCharges)
    AppCompatTextView tv_deleveryCharges;
    @BindView(R.id.restourentimage)
    ViewPager restourentimage;
    @BindView(R.id.addToFavButton)
    AppCompatImageView addToFavButton;
    @BindView(R.id.lnr_deleveryServices)
    LinearLayout lnr_deleveryServices;
    @BindView(R.id.lnr_cateringServices)
    LinearLayout lnr_cateringServices;

    @BindView(R.id.tv_setuUpTime)
    AppCompatTextView tv_setuUpTime;
    @BindView(R.id.tv_requirements)
    AppCompatTextView tv_requirements;
    @BindView(R.id.menuTextView)
    AppCompatTextView menuTextView;

    DetailAdapter detailAdapter;
    MainCategoriesAdapter menusAdapter;
    List<RestourentDetailResponse.Mode> modes = new ArrayList<>();
    List<RestourentModeResponse.Item> items = new ArrayList<>();
    private ProgressHUD progressHUD;
    RestourentDetailsImageBanner mViewPagerAdapter;

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restourent_detail);
        try {
            getWindow().setStatusBarColor(Color.BLACK);
        } catch (Exception t) {
        }
        ButterKnife.bind(this);
        progressHUD = ProgressHUD.create(getActivityContext(), getString(R.string.loading), false, null, null);
        restourentDetailPresenter = new RestourentDetailImpl(this);
        restourentDetailPresenter.getRestourentDetailApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_RESTOURENT_ID, ""),"1");

        List<String> list = new ArrayList<>();
        list.add(getString(R.string.delivery_service));
        list.add(getString(R.string.catering_service));
        list.add(getString(R.string.other_service));

        detailAdapter = new DetailAdapter(modes, getApplicationContext());
        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(
                getApplicationContext(),
                LinearLayoutManager.HORIZONTAL,
                false);
        detail_recyclerView.setLayoutManager(HorizontalLayout);
        detail_recyclerView.setAdapter(detailAdapter);
        detailAdapter.setOnItemClickListener(new DetailAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView custom_tab_textView, LinearLayout detail_item_linearLayout) {
                SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.MODE_ID, "" + modes.get(position).getId());
                if (modes.get(position).getName().equalsIgnoreCase("Delivery")) {
                    // lnr_deleveryServices.setVisibility(View.VISIBLE);
                    //  lnr_cateringServices.setVisibility(View.GONE);
                    menuTextView.setText("Delivery info");
                    modeType = "Delivery";
                }
                if (modes.get(position).getName().equalsIgnoreCase("Table Booking")) {
                    //  lnr_deleveryServices.setVisibility(View.VISIBLE);
                    //  lnr_cateringServices.setVisibility(View.GONE);
                    menuTextView.setText("Table Booking info");
                    modeType = "Table Booking";
                }
                if (modes.get(position).getName().equalsIgnoreCase("Catering")) {
                    //  lnr_deleveryServices.setVisibility(View.GONE);
                    //  lnr_cateringServices.setVisibility(View.VISIBLE);
                    menuTextView.setText("Catering info");
                    modeType = "Catering";
                }
                detailAdapter.notifyDataSetChanged();
                restourentDetailPresenter.getRestourentDetailApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_RESTOURENT_ID, ""), "" + modes.get(position).getId());
            }
        });

/////////////////////////////////////////////

        menusAdapter = new MainCategoriesAdapter(getApplicationContext(), items);
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewMenu.setAdapter(menusAdapter);
        menusAdapter.setOnItemClickListener(new MainCategoriesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int verPos,Integer id) {
                try {
                    Log.i("Yhan", "===" + items.get(verPos));
                    SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.ITEM_ID, ""+ id);
                    if (modeType.equalsIgnoreCase("Delivery")) {
                        Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class);
                        startActivity(intent);
                    }
                    if (modeType.equalsIgnoreCase("Table Booking")) {
                        Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class);
                        startActivity(intent);
                    }
                    if (modeType.equalsIgnoreCase("Catering")) {
                        Intent intent = new Intent(getApplicationContext(), CateringServiceDetailActivity.class);
                        startActivity(intent);
                    }

                } catch (Exception j) {
                }
            }

            @Override
            public void OnViewList() {
                Log.d("ss","sks");
            }
        });
    }

    @OnClick({R.id.backButton, R.id.addToFavButton, R.id.img_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_info:
                try {
                    BottomSheetInfoFragment bottomSheetInfoFragment = BottomSheetInfoFragment.newInstance();
                    bottomSheetInfoFragment.show(getSupportFragmentManager(), "bottomSheetDialog");
                } catch (Exception g) {
                }
                break;
            case R.id.backButton:
                try {
                    finish();
                } catch (Exception g) {
                }
                break;
            case R.id.addToFavButton:
                try {
                    if (SharedPreferencesUtils.getInstance(this).getValue(Constants.KEY_LOGGED_IN, false)) {
                        if (addToFev) {
                            addToFavButton.setBackgroundResource(R.drawable.ic_heart);
                            addToFev = false;
                            restourentDetailPresenter.addToFevCatererApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_RESTOURENT_ID, ""));
                        } else {
                            addToFavButton.setBackgroundResource(R.drawable.ic_heart_red);
                            addToFev = true;
                            restourentDetailPresenter.addToFevCatererApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_RESTOURENT_ID, ""));
                        }
                    } else {
                        Intent i1 = new Intent(this, LoginActivity.class);
                        startActivity(i1);
                    }
                } catch (Exception g) {
                }
                break;
        }
    }

    @Override
    public void onSuccessGetRestourentDetailAPi(RestourentDetailResponse restourentDetailResponse) {
        try {

            try {
                if (restourentDetailResponse.getData().getIsFavorite()) {
                    addToFavButton.setBackgroundResource(R.drawable.ic_heart_red);
                    addToFev = true;

                } else {
                    addToFavButton.setBackgroundResource(R.drawable.ic_heart);
                    addToFev = false;
                }
            } catch (Exception g) {
            }

            if (SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                resturantNameTextView.setText(restourentDetailResponse.getData().getArabicName());
                resturantdetail.setText(restourentDetailResponse.getData().getArabicDetail());
                tv_minNots.setText(restourentDetailResponse.getData().getTimeShow());
                tv_minOrder.setText(restourentDetailResponse.getData().getMinOrder());
                tv_setuUpTime.setText(restourentDetailResponse.getData().getSetupTimeInMinute() + " Mins");
//                tv_requirements.setText(restourentDetailResponse.getData().getRequirements());
                tv_requirements.setText(restourentDetailResponse.getData().getRequirements());
            }

            if (SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                resturantNameTextView.setText(restourentDetailResponse.getData().getName());
                resturantdetail.setText(restourentDetailResponse.getData().getDetail());
                tv_minNots.setText(restourentDetailResponse.getData().getTimeShow());
                tv_minOrder.setText(restourentDetailResponse.getData().getMinOrder());
                tv_setuUpTime.setText(restourentDetailResponse.getData().getSetupTimeInMinute() + " Mins");
                tv_requirements.setText(restourentDetailResponse.getData().getRequirements());
            }
            try {
                SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.INFO, "" + restourentDetailResponse.getData().getCashOrderPolicy());
            } catch (Exception h) {
            }
            restourentRatingBar.setRating(Float.parseFloat("" + restourentDetailResponse.getData().getRating()));
            if (Objects.equals(restourentDetailResponse.getData().getDeliveryCharge(), "0")) {
                tv_deleveryCharges.setText("Free");
            } else {
                tv_deleveryCharges.setText("" + restourentDetailResponse.getData().getDeliveryCharge());
            }
            //for image banner
            // Initializing the ViewPagerAdapter
            mViewPagerAdapter = new RestourentDetailsImageBanner(getActivityContext(), restourentDetailResponse.getData().getImages());

            // Adding the Adapter to the ViewPager
            restourentimage.setAdapter(mViewPagerAdapter);
//            try {
//                Picasso.get().load("" + restourentDetailResponse.getData().getCoverImagePath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(restourentimage);
//            } catch (Exception ex) {
//            }
            try {
                modes.clear();
                try {
                    modefirstItem = restourentDetailResponse.getData().getModes().get(0).getId();
                    modeType = restourentDetailResponse.getData().getModes().get(0).getName();
                    SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.MODE_ID, "" + modefirstItem);
                } catch (Exception g) {
                }
                modes.addAll(restourentDetailResponse.getData().getModes());
                detailAdapter.notifyDataSetChanged();

                try {
                    if(!modes.isEmpty()) {
                        if (modes.get(0).getName().equalsIgnoreCase("Delivery")) {
                            //  lnr_deleveryServices.setVisibility(View.VISIBLE);
                            //  lnr_cateringServices.setVisibility(View.GONE);
                            menuTextView.setText("Delivery info");
                        }
                        if (modes.get(0).getName().equalsIgnoreCase("Table Booking")) {
                            //   lnr_deleveryServices.setVisibility(View.VISIBLE);
                            //   lnr_cateringServices.setVisibility(View.GONE);
                            menuTextView.setText("Table Booking info");
                        }
                        if (modes.get(0).getName().equalsIgnoreCase("Catering")) {
                            //   lnr_deleveryServices.setVisibility(View.GONE);
                            //   lnr_cateringServices.setVisibility(View.VISIBLE);
                            menuTextView.setText("Catering info");
                        }
                    }
                } catch (Exception j) {
                    Log.i(j.toString(),"checker");
                }

            } catch (Exception h) {
                Log.i(h.toString(),"checker");

            }
            try {
                restourentDetailPresenter.getRestourentDetailApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_RESTOURENT_ID, ""), "1"); //+ modefirstItem);
            } catch (Exception f) {
                Log.i(f.toString(),"checker");

            }
        } catch (Exception g) {
            Log.i(g.toString(),"checker");

            Log.i("UIUOOIOI", g.getMessage());
        }
    }

    @Override
    public void onSuccessGetRestourentModeAPi(RestourentModeResponse restourentModeResponse) {
        try {
            if (restourentModeResponse.getStatus()) {
                items.clear();

                items.addAll(restourentModeResponse.getData().getItem());

                menusAdapter.notifyDataSetChanged();
            }
        } catch (Exception h) {
        }
    }

    @Override
    public void onSuccessAddToFevRestourentAPi(RestourentAddToFevResponse restourentAddToFevResponse) {
        try {
            if (restourentAddToFevResponse.getStatus()) {
                Toast.makeText(getActivityContext(), restourentAddToFevResponse.getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivityContext(), restourentAddToFevResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception h) {
        }
    }

    @Override
    public void onSuccessAddToFevRestourentModeAPi(AddtoFebRestourentResponse addtoFebRestourentResponse) {

    }

    @Override
    public void showLoading() {
        try {
            progressHUD.show();
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
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_in);
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
        super.onBackPressed();
    }
}