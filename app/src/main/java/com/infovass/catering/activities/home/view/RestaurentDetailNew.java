package com.infovass.catering.activities.home.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.infovass.catering.MyFormat.Controller.AppController;
import com.infovass.catering.MyFormat.MyDM.Item;
import com.infovass.catering.MyFormat.MyDM.Mode;
import com.infovass.catering.MyFormat.MyDM.Root;
import com.infovass.catering.MyFormat.Utils.ConnectionDetector;
import com.infovass.catering.R;
import com.infovass.catering.Utils.Helper;
import com.infovass.catering.activities.adapers.DetailAdapter;
import com.infovass.catering.activities.adapers.DetailNewAdapter;
import com.infovass.catering.activities.adapers.MainCategoriesNewAdapter;
import com.infovass.catering.activities.dialog.BottomSheetInfoFragment;
import com.infovass.catering.activities.home.adapter.RestourentDetailsIBN;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedString;

public class RestaurentDetailNew extends AppCompatActivity implements RestourentDetailView {
    boolean addToFev = false;
    private AppController appController;
    private Dialog progress;
    private ConnectionDetector connectionDetector;
    RestourentDetailPresenter restourentDetailPresenter;
    String restaurant_Status;
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
    @BindView(R.id.main_content)
    LinearLayout main_content;

    DetailNewAdapter detailAdapter;

    MainCategoriesNewAdapter menusAdapter;
    int restaurententID;


    RestourentDetailsIBN mViewPagerAdapter;
    String modeType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurent_detail_new);
        ButterKnife.bind(this);
        restourentDetailPresenter = new RestourentDetailImpl(this);
//        restaurententID = Integer.parseInt(getIntent().getStringExtra("restaurententID"));
        appController = (AppController) this.getApplicationContext();
        connectionDetector = new ConnectionDetector(getApplicationContext());
        Intent mIntent = getIntent();
        restaurententID = mIntent.getIntExtra("restaurententID", 0);
        restaurant_Status = mIntent.getStringExtra("restaurant_Status");
        main_content.setVisibility(View.GONE);
        try {
            productDetailAPI();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            getWindow().setStatusBarColor(Color.BLACK);
        } catch (Exception t) {
        }
    }

    int modefirstItem = 1;

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
                            addToFev = false;
                        } else {
                            addToFev = true;
                        }

                        setAddToFev();

                    } else {
                        Intent i1 = new Intent(this, LoginActivity.class);
                        startActivity(i1);
                    }
                } catch (Exception g) {
                    g.printStackTrace();
                }
                break;
        }
    }


    public void setAddToFev() {
        if (addToFev) {
            addToFavButton.setBackgroundResource(R.drawable.ic_heart_red);
            restourentDetailPresenter.addToFevCatererApi(SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.KEY_RESTOURENT_ID, ""));
        } else {
            addToFavButton.setBackgroundResource(R.drawable.ic_heart);
            restourentDetailPresenter.addToFevCatererApi(SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.KEY_RESTOURENT_ID, ""));
        }
    }

    public void addToFev() {
        if (connectionDetector.isConnectingToInternet()) {

            appController.paServices.AddToFevCatererApi("", "", new Callback<Root>() {
                @Override
                public void success(Root root, Response response) {

//                    if(root.getStatus().equalsIgnoreCase("true") {
//
//                    }
                }

                @Override
                public void failure(RetrofitError error) {

                    error.printStackTrace();
                }
            });

        } else {
            Toast.makeText(RestaurentDetailNew.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();

        }
    }


    ArrayList<Mode> modeArrayList = new ArrayList<>();
    ArrayList<Item> itemArrayList = new ArrayList<>();
    List<RestourentDetailResponse.Mode> modes = new ArrayList<>();
    List<RestourentModeResponse.Item> items = new ArrayList<>();
String min_time;
    public void productDetailAPI() {
        if (connectionDetector.isConnectingToInternet()) {


            MultipartTypedOutput multipartTypedOutput = new MultipartTypedOutput();
            String id = String.valueOf(restaurententID);
            JSONObject jsonObj = new JSONObject();
            try {
                jsonObj.put("mode_type", modefirstItem);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            String po = jsonObj.toString();
            //   String Checker = gson.toJson(jsonObject);
            TypedInput in = null;
            try {
                in = new TypedByteArray("application/json", po.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            appController.paServices.ProductDetailAPI(id, in, new Callback<Root>() {
                @Override
                public void success(Root root, Response response) {
                    if (root.getStatus().equalsIgnoreCase("true")) {

                        if (!root.getData().getItem().isEmpty() && !root.getData().getModes().isEmpty()) {

                            min_time=root.getData().getMinimum_time();
                            main_content.setVisibility(View.VISIBLE);
                            ////////////////////////////////////////////////////////////////////////////
                            modes.clear();
                            modeArrayList.clear();
                            modeType = root.getData().getModes().get(0).getName();
                            if (modeType.equalsIgnoreCase("Delivery")) {
                                // lnr_deleveryServices.setVisibility(View.VISIBLE);
                                //  lnr_cateringServices.setVisibility(View.GONE);
                                menuTextView.setText("Delivery info");
                                modeType = "Delivery";
                            }
                            if (modeType.equalsIgnoreCase("Table Booking")) {
                                //  lnr_deleveryServices.setVisibility(View.VISIBLE);
                                //  lnr_cateringServices.setVisibility(View.GONE);
                                menuTextView.setText("Table Booking info");
                                modeType = "Table Booking";
                            }
                            if (modeType.equalsIgnoreCase("Catering")) {
                                //  lnr_deleveryServices.setVisibility(View.GONE);
                                //  lnr_cateringServices.setVisibility(View.VISIBLE);
                                menuTextView.setText("Catering info");
                                modeType = "Catering";
                            }
                            //////////////////////////////////////////////////////////////////////////////////
                            try {
                                if (root.getData().getIs_favorite().equalsIgnoreCase("true")) {
                                    addToFavButton.setBackgroundResource(R.drawable.ic_heart_red);
                                    addToFev = true;

                                } else {
                                    addToFavButton.setBackgroundResource(R.drawable.ic_heart);
                                    addToFev = false;
                                }
                            } catch (Exception g) {
                            }


                            /////////////////////////////////////////////////////////////////////////////////

                            if (SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                                resturantNameTextView.setText(root.getData().getArabic_name());
                                resturantdetail.setText(root.getData().getArabic_detail());
                                tv_minNots.setText(root.getData().getTime_show());
                                tv_minOrder.setText(root.getData().getMin_order());
                                tv_setuUpTime.setText(root.getData().getSetup_time_in_minute() + " Mins");
//                tv_requirements.setText(restourentDetailResponse.getData().getRequirements());
                                tv_requirements.setText(String.valueOf(root.getData().getRequirements()));
                            }

                            if (SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                                resturantNameTextView.setText(root.getData().getName());
                                resturantdetail.setText(root.getData().getDetail());
                                tv_minNots.setText(root.getData().getTime_show());
                                tv_minOrder.setText(root.getData().getMin_order());
                                tv_setuUpTime.setText(root.getData().getSetup_time_in_minute() + " Mins");
                                tv_requirements.setText(String.valueOf(root.getData().getRequirements()));
                            }
                            try {
                                SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).setValue(Constants.INFO, "" + root.getData().getCash_order_policy());
                            } catch (Exception h) {
                            }
                            restourentRatingBar.setRating(Float.parseFloat("" + root.getData().getRating()));
                            if (Objects.equals(root.getData().getDelivery_charge(), "0")) {
                                tv_deleveryCharges.setText("Free");
                            } else {
                                tv_deleveryCharges.setText("" + root.getData().getDelivery_charge());
                            }


                            /////////////////////////////////////////////////////////////////////////////////


                            modeArrayList = root.getData().getModes();
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));
                            modeArrayList.add(new Mode("4", "q", "q", ""));

                            detailAdapter = new DetailNewAdapter(modeArrayList, getApplicationContext());
                            LinearLayoutManager HorizontalLayout = new LinearLayoutManager(
                                    getApplicationContext(),
                                    LinearLayoutManager.HORIZONTAL,
                                    false);
                            detail_recyclerView.setLayoutManager(HorizontalLayout);
                            detail_recyclerView.setAdapter(detailAdapter);
                            detailAdapter.setOnItemClickListener(new DetailNewAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position, TextView custom_tab_textView, LinearLayout detail_item_linearLayout) {
                                    SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).setValue(Constants.MODE_ID, "" + modeArrayList.get(position).getId());
                                    if (modeArrayList.get(position).getName().equalsIgnoreCase("Delivery")) {

                                        menuTextView.setText("Delivery info");
                                        modeType = "Delivery";
                                    }
                                    if (modeArrayList.get(position).getName().equalsIgnoreCase("Table Booking")) {

                                        menuTextView.setText("Table Booking info");
                                        modeType = "Table Booking";
                                    }
                                    if (modeArrayList.get(position).getName().equalsIgnoreCase("Catering")) {
                                        menuTextView.setText("Catering info");
                                        modeType = "Catering";
                                    }
                                    detailAdapter.notifyDataSetChanged();
                                    try {
                                        restourentDetailPresenter.getRestourentDetailApi(SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.KEY_RESTOURENT_ID, ""), "" + modeArrayList.get(position).getId());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });

                            ///////////////////////////////////////////////////////////////////////////////////////////////////

                            //for image banner
                            // Initializing the ViewPagerAdapter
                            mViewPagerAdapter = new RestourentDetailsIBN(RestaurentDetailNew.this, root.getData().getImages());

                            // Adding the Adapter to the ViewPager
                            restourentimage.setAdapter(mViewPagerAdapter);

                            ///////////////////////////////////////////////////////////////////////////////////////////////////

                            itemArrayList = root.getData().getItem();
                            menusAdapter = new MainCategoriesNewAdapter(getApplicationContext(), itemArrayList);
                            recyclerViewMenu.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            recyclerViewMenu.setAdapter(menusAdapter);
                            menusAdapter.setOnItemClickListener(new MainCategoriesNewAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position, int verPos, Integer id) {
                                    try {
//                                    Log.i("Yhan", "===" + items.get(verPos));
                                        SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).setValue(Constants.ITEM_ID, "" + id);
                                        SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).setValue(Constants.MODE_ID, "" + modeArrayList.get(position).getId());
                                        if (modeType.equalsIgnoreCase("Delivery")) {
                                            Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class)
                                                    .putExtra("status", restaurant_Status)
                                                    .putExtra("min_time",min_time);
                                            startActivity(intent);
                                            overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                                        }
                                        if (modeType.equalsIgnoreCase("Table Booking")) {
                                            Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class)
                                                    .putExtra("status", restaurant_Status)
                                                    .putExtra("min_time",min_time);

                                            startActivity(intent);
                                            overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                                        }
                                        if (modeType.equalsIgnoreCase("Catering")) {
                                            Intent intent = new Intent(getApplicationContext(), CateringServiceDetailActivity.class)
                                                    .putExtra("status", restaurant_Status)
                                                    .putExtra("min_time",min_time);
                                            startActivity(intent);
                                            overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                                        }

                                    } catch (Exception j) {
                                        j.printStackTrace();
                                    }
                                }

                                @Override
                                public void OnViewList() {
                                    Log.d("ss", "sks");
                                }
                            });

                        } else {
                            Dialog dialog = new Dialog(RestaurentDetailNew.this, R.style.CustomAlertDialog);

                            dialog.setContentView(R.layout.cusutm_item_no_data_dialog);
                            dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            dialog.setCancelable(false);
                            dialog.getWindow().getAttributes().windowAnimations = R.anim.dialog_enter_animation;
                            main_content.setVisibility(View.GONE);
                            Button backButton = dialog.findViewById(R.id.backButton);
                            backButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    finish();
                                }
                            });
                            dialog.show();
                        }
                    } else {
//                        Toast.makeText(RestaurentDetailNew.this, getString(R.string.not_avilable_for_catering), Toast.LENGTH_SHORT).show();


                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    error.printStackTrace();
                    Log.e("String", error.toString());
                }
            });

        } else {
            Toast.makeText(RestaurentDetailNew.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSuccessGetRestourentDetailAPi(RestourentDetailResponse
                                                        restourentDetailResponse) {
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

            if (SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                resturantNameTextView.setText(restourentDetailResponse.getData().getArabicName());
                resturantdetail.setText(restourentDetailResponse.getData().getArabicDetail());
                tv_minNots.setText(restourentDetailResponse.getData().getTimeShow());
                tv_minOrder.setText(restourentDetailResponse.getData().getMinOrder());
                tv_setuUpTime.setText(restourentDetailResponse.getData().getSetupTimeInMinute() + " Mins");
//                tv_requirements.setText(restourentDetailResponse.getData().getRequirements());
                tv_requirements.setText(restourentDetailResponse.getData().getRequirements());
            }

            if (SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                resturantNameTextView.setText(restourentDetailResponse.getData().getName());
                resturantdetail.setText(restourentDetailResponse.getData().getDetail());
                tv_minNots.setText(restourentDetailResponse.getData().getTimeShow());
                tv_minOrder.setText(restourentDetailResponse.getData().getMinOrder());
                tv_setuUpTime.setText(restourentDetailResponse.getData().getSetupTimeInMinute() + " Mins");
                tv_requirements.setText(restourentDetailResponse.getData().getRequirements());
            }
            try {
                SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).setValue(Constants.INFO, "" + restourentDetailResponse.getData().getCashOrderPolicy());
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
//            mViewPagerAdapter = new RestourentDetailsImageBanner(RestaurentDetailNew.this, restourentDetailResponse.getData().getImages());
//
//            // Adding the Adapter to the ViewPager
//            restourentimage.setAdapter(mViewPagerAdapter);
//            try {
//                Picasso.get().load("" + restourentDetailResponse.getData().getCoverImagePath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(restourentimage);
//            } catch (Exception ex) {
//            }
            try {
                modeArrayList.clear();
                try {
                    modefirstItem = restourentDetailResponse.getData().getModes().get(0).getId();
                    modeType = restourentDetailResponse.getData().getModes().get(0).getName();
                    SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).setValue(Constants.MODE_ID, "" + modefirstItem);
                } catch (Exception g) {
                }
                modes.addAll(restourentDetailResponse.getData().getModes());
                detailAdapter.notifyDataSetChanged();

                try {
                    if (!modes.isEmpty()) {
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
                    Log.i(j.toString(), "checker");
                }

            } catch (Exception h) {
                Log.i(h.toString(), "checker");

            }
            try {
                restourentDetailPresenter.getRestourentDetailApi(SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(RestaurentDetailNew.this).getValue(Constants.KEY_RESTOURENT_ID, ""), "1"); //+ modefirstItem);
            } catch (Exception f) {
                Log.i(f.toString(), "checker");

            }
        } catch (Exception g) {
            Log.i(g.toString(), "checker");

            Log.i("UIUOOIOI", g.getMessage());
        }
    }

    @Override
    public void onSuccessGetRestourentModeAPi(RestourentModeResponse restourentModeResponse) {

    }

    @Override
    public void onSuccessAddToFevRestourentAPi(RestourentAddToFevResponse
                                                       restourentAddToFevResponse) {
        try {
            if (restourentAddToFevResponse.getStatus()) {
//                Toast.makeText(RestaurentDetailNew.this, restourentAddToFevResponse.getMessage(), Toast.LENGTH_SHORT).show();
            } else {
//                Toast.makeText(RestaurentDetailNew.this, restourentAddToFevResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception h) {
        }
    }

    @Override
    public void onSuccessAddToFevRestourentModeAPi(AddtoFebRestourentResponse
                                                           addtoFebRestourentResponse) {

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
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
        super.onBackPressed();
    }
}