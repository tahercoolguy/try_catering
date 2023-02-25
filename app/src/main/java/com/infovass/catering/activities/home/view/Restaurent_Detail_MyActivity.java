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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.infovass.catering.MyFormat.Controller.AppController;
import com.infovass.catering.MyFormat.MyDM.Image;
import com.infovass.catering.MyFormat.MyDM.Image_;
import com.infovass.catering.MyFormat.MyDM.Item;
import com.infovass.catering.MyFormat.MyDM.Mode;
import com.infovass.catering.MyFormat.MyDM.Root;
import com.infovass.catering.MyFormat.Utils.ConnectionDetector;
import com.infovass.catering.R;
import com.infovass.catering.activities.adapers.DetailNewAdapter;
import com.infovass.catering.activities.adapers.MainCategoriesNewAdapter;
import com.infovass.catering.activities.dialog.BottomSheetInfoFragment;
import com.infovass.catering.activities.home.adapter.RestourentDetailsIBN;
import com.infovass.catering.activities.home.adapter.RestourentDetailsImageBanner;
import com.infovass.catering.activities.home.model.RestourentDetailResponse;
import com.infovass.catering.activities.home.model.RestourentModeResponse;
import com.infovass.catering.activities.home.presenter.RestourentDetailPresenter;
import com.infovass.catering.activities.login.view.LoginActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;

public class Restaurent_Detail_MyActivity extends AppCompatActivity {
    boolean addToFev = false;
    private AppController appController;
    private Dialog progress;
    private ConnectionDetector connectionDetector;
    RestourentDetailPresenter restourentDetailPresenter;
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

    DetailNewAdapter detailAdapter;

    MainCategoriesNewAdapter menusAdapter;
    int restaurententID;


    RestourentDetailsIBN mViewPagerAdapter;
    String modeType = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurent_detail_my);
        ButterKnife.bind(this);
//        restaurententID = Integer.parseInt(getIntent().getStringExtra("restaurententID"));
        appController = (AppController) this.getApplicationContext();
        connectionDetector = new ConnectionDetector(getApplicationContext());
        Intent mIntent = getIntent();
        restaurententID = mIntent.getIntExtra("restaurententID", 0);

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
//                            restourentDetailPresenter.addToFevCatererApi(SharedPreferencesUtils.getInstance(Restaurent_Detail_MyActivity.this).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(Restaurent_Detail_MyActivity.this).getValue(Constants.KEY_RESTOURENT_ID, ""));
                        } else {
                            addToFavButton.setBackgroundResource(R.drawable.ic_heart_red);
                            addToFev = true;
//                            restourentDetailPresenter.addToFevCatererApi(SharedPreferencesUtils.getInstance(Restaurent_Detail_MyActivity.this).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(Restaurent_Detail_MyActivity.this).getValue(Constants.KEY_RESTOURENT_ID, ""));
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
    ArrayList<Mode> modeArrayList = new ArrayList<>();
    ArrayList<Item> itemArrayList = new ArrayList<>();

    public void productDetailAPI() {
        if (connectionDetector.isConnectingToInternet()) {

            MultipartTypedOutput multipartTypedOutput = new MultipartTypedOutput();
            String id = String.valueOf(restaurententID);
//






            JSONObject jsonObj = new JSONObject();
            try {
                jsonObj.put("mode_type", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }


            String json = "{\"mode_type\":\"1\"}";
            TypedInput in = null;
            try {
                in = new TypedByteArray("application/json", jsonObj.toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
//            FooResponse response = foo.postRawJson(in);



            appController.paServices.ProductDetailAPI(id,in, new Callback<Root>() {
                @Override
                public void success(Root root, Response response) {
                    if (root.getStatus().equalsIgnoreCase("true")) {



                        modeArrayList = root.getData().getModes();

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
                                SharedPreferencesUtils.getInstance(Restaurent_Detail_MyActivity.this).setValue(Constants.MODE_ID, "" + modeArrayList.get(position).getId());
                                if (modeArrayList.get(position).getName().equalsIgnoreCase("Delivery")) {
                                    // lnr_deleveryServices.setVisibility(View.VISIBLE);
                                    //  lnr_cateringServices.setVisibility(View.GONE);
                                    menuTextView.setText("Delivery info");
                                    modeType = "Delivery";
                                }
                                if (modeArrayList.get(position).getName().equalsIgnoreCase("Table Booking")) {
                                    //  lnr_deleveryServices.setVisibility(View.VISIBLE);
                                    //  lnr_cateringServices.setVisibility(View.GONE);
                                    menuTextView.setText("Table Booking info");
                                    modeType = "Table Booking";
                                }
                                if (modeArrayList.get(position).getName().equalsIgnoreCase("Catering")) {
                                    //  lnr_deleveryServices.setVisibility(View.GONE);
                                    //  lnr_cateringServices.setVisibility(View.VISIBLE);
                                    menuTextView.setText("Catering info");
                                    modeType = "Catering";
                                }
                                detailAdapter.notifyDataSetChanged();
//                                restourentDetailPresenter.getRestourentDetailApi(SharedPreferencesUtils.getInstance(Restaurent_Detail_MyActivity.this).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(Restaurent_Detail_MyActivity.this).getValue(Constants.KEY_RESTOURENT_ID, ""), "" + modeArrayList.get(position).getId());
                            }
                        });

                        ///////////////////////////////////////////////////////////////////////////////////////////////////

                        itemArrayList = root.getData().getItem();
                        menusAdapter = new MainCategoriesNewAdapter(getApplicationContext(), itemArrayList);
                        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        recyclerViewMenu.setAdapter(menusAdapter);
                        menusAdapter.setOnItemClickListener(new MainCategoriesNewAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position, int verPos, Integer id) {
                                try {
//                                    Log.i("Yhan", "===" + itemArrayList.get(verPos));
                                    SharedPreferencesUtils.getInstance(Restaurent_Detail_MyActivity.this).setValue(Constants.ITEM_ID, "" + id);
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
                                Log.d("ss", "sks");
                            }
                        });

                        /////////////////////////////////////////////////////////////////////////////////////////////////////

                        ArrayList<Image>imagesArrayList=root.getData().getImages();
                        //for image banner
                        // Initializing the ViewPagerAdapter
                        mViewPagerAdapter = new RestourentDetailsIBN(Restaurent_Detail_MyActivity.this,imagesArrayList );

                        // Adding the Adapter to the ViewPager
                        restourentimage.setAdapter(mViewPagerAdapter);

                    } else {
                        Toast.makeText(Restaurent_Detail_MyActivity.this, getString(R.string.not_avilable_for_catering), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    error.printStackTrace();
                    Log.e("String", error.toString());
                }
            });

        } else {
            Toast.makeText(Restaurent_Detail_MyActivity.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
        }
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