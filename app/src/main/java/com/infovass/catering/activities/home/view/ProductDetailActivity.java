package com.infovass.catering.activities.home.view;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.infovass.catering.DeepLinking.DynamicLinkHelper;
import com.infovass.catering.R;
import com.infovass.catering.Utils.Helper;
import com.infovass.catering.activities.DataModel.RD_Image;
import com.infovass.catering.activities.Location.view.LocationActivity;
import com.infovass.catering.activities.adapers.CateringSDSliderAdapter;
import com.infovass.catering.activities.cart.view.CartActivity;
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.dialog.BottomSheetInfoFragment;
import com.infovass.catering.activities.home.model.ProductAddToCartResponse;
import com.infovass.catering.activities.home.model.ProductDetailResponse;
import com.infovass.catering.activities.home.model.RestourentAddToFevResponse;
import com.infovass.catering.activities.home.presenter.ProductDetailImpl;
import com.infovass.catering.activities.home.presenter.ProductDetailPresenter;
import com.infovass.catering.activities.login.view.LoginActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.ProgressHUD;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailActivity extends BaseActivity implements ProductDetailView {

    double mProductPrice = 0;
    boolean addToFev = false;
    ProductDetailPresenter productDetailPresenter;
    private ProgressHUD progressHUD;
    @BindView(R.id.img_minButton)
    AppCompatImageView img_minButton;
    @BindView(R.id.tv_productCount)
    AppCompatTextView tv_productCount;
    @BindView(R.id.tv_totalPrice)
    AppCompatTextView tv_totalPrice;
    @BindView(R.id.arrowImageView)
    ImageView arrowImageView;
    @BindView(R.id.img_maxButton)
    AppCompatImageView img_maxButton;
    @BindView(R.id.addToFavButton)
    androidx.appcompat.widget.AppCompatImageButton addToFavButton;

    @BindView(R.id.img_productImage)
    AppCompatImageView img_productImage;
    @BindView(R.id.tv_minNots)
    AppCompatTextView tv_minNots;
    @BindView(R.id.tv_minOrder)
    AppCompatTextView tv_minOrder;
    @BindView(R.id.tv_deleveryCharges)
    AppCompatTextView tv_deleveryCharges;
    @BindView(R.id.tv_forPersions)
    AppCompatTextView tv_forPersions;
    @BindView(R.id.mealNameTextView)
    AppCompatTextView mealNameTextView;
    @BindView(R.id.mealTagTextView)
    AppCompatTextView mealTagTextView;
    @BindView(R.id.priceTextView)
    AppCompatTextView priceTextView;
    @BindView(R.id.edt_note)
    AppCompatEditText edt_note;

    @BindView(R.id.not_availableTxt)
    AppCompatTextView not_availableTxt;

    @BindView(R.id.not_availableRL)
    RelativeLayout not_availableRL;

    @BindView(R.id.rel_findFood)
    RelativeLayout rel_findFood;
    @BindView(R.id.imageSlider)
    SliderView imageSlider;

    @BindView(R.id.shareImageView)
    AppCompatImageView shareImageView;
    String status, min_time;
    private DynamicLinkHelper dynamicLinkHelper;
    Activity activity;
    String tittle = "", subtittle = "", img  = "", id = "", price = "";
String deep_linking_back="false";

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        activity=ProductDetailActivity.this;
        dynamicLinkHelper = new DynamicLinkHelper(this,activity);


        try {
            getWindow().setStatusBarColor(Color.BLACK);
        } catch (Exception t) {
        }
        ButterKnife.bind(this);

        tv_minNots.setSelected(true);
        tv_minOrder.setSelected(true);
        tv_deleveryCharges.setSelected(true);

        progressHUD = ProgressHUD.create(getActivityContext(), getString(R.string.loading), false, null, null);
        productDetailPresenter = new ProductDetailImpl(this);
//        productDetailPresenter.getProductDetailApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.ITEM_ID, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.MODE_ID, ""));
        productDetailPresenter.getProductDetailApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.ITEM_ID, ""));


        Intent mIntent = getIntent();
        status = mIntent.getStringExtra("status");
        min_time = mIntent.getStringExtra("min_time");
        deep_linking_back = mIntent.getStringExtra("deep_linking_back");
        if(deep_linking_back==null){
            deep_linking_back="false";
        }

        if (status.equalsIgnoreCase("1")) {
            not_availableRL.setVisibility(View.VISIBLE);
            rel_findFood.setVisibility(View.GONE);
        } else {
            not_availableRL.setVisibility(View.GONE);
            rel_findFood.setVisibility(View.VISIBLE);
        }

    }

    @OnClick({R.id.arrowImageView, R.id.rel_findFood, R.id.backButton, R.id.img_minButton, R.id.img_maxButton, R.id.addToFavButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.arrowImageView:
                try {
                    BottomSheetInfoFragment bottomSheetInfoFragment = BottomSheetInfoFragment.newInstance();
                    bottomSheetInfoFragment.show(getSupportFragmentManager(), "bottomSheetDialog");
                } catch (Exception g) {
                }
                break;

            case R.id.addToFavButton:
                try {
                    if (SharedPreferencesUtils.getInstance(this).getValue(Constants.KEY_LOGGED_IN, false)) {
                        if (addToFev) {
                            addToFavButton.setBackgroundResource(R.drawable.ic_heart);
                            addToFev = false;
                            productDetailPresenter.addToFevItemApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.ITEM_ID, ""));
                        } else {
                            addToFavButton.setBackgroundResource(R.drawable.ic_heart_red);
                            addToFev = true;
                            productDetailPresenter.addToFevItemApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.ITEM_ID, ""));
                        }
                    } else {
                        Intent i1 = new Intent(this, LoginActivity.class);
                        startActivity(i1);
                    }
                } catch (Exception g) {
                }
                break;

            case R.id.img_maxButton:
                try {
                    int itemCount = Integer.parseInt(tv_productCount.getText().toString());
                    itemCount = itemCount + 1;
                    tv_productCount.setText("" + itemCount);
                    tv_totalPrice.setText(mProductPrice * itemCount + " KWD");
                } catch (Exception g) {
                }
                break;

            case R.id.img_minButton:
                try {
                    int itemCount = Integer.parseInt(tv_productCount.getText().toString());
                    itemCount = itemCount - 1;
                    if (itemCount == 0) {
                        Toast.makeText(getActivityContext(), getString(R.string.cannot_item_count_zero), Toast.LENGTH_SHORT).show();
                    } else {
                        tv_productCount.setText("" + itemCount);
                        tv_totalPrice.setText(mProductPrice * itemCount + " KWD");
                    }

                } catch (Exception g) {
                }
                break;

            case R.id.rel_findFood:
                try {
                    if (SharedPreferencesUtils.getInstance(this).getValue(Constants.KEY_LOGGED_IN, false)) {
                        SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.addressID, "");
                        SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.address, "");

                        Date d = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                        String currentDateTimeString = sdf.format(d);
                        String selectedTimeString = SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_TIME, "");

                        String[] currentTime = currentDateTimeString.split(" ");
                        String[] selectedTime = selectedTimeString.split(" ");


                        // Creating a SimpleDateFormat object
                        // to parse time in the format HH:MM:SS
                        SimpleDateFormat simpleDateFormat
                                = new SimpleDateFormat("HH:mm:ss");

                        // Parsing the Time Period
                        Date date1 = null, date2 = null;
                        try {
                            date1 = simpleDateFormat.parse(currentTime[0] + ":00");
                            date2 = simpleDateFormat.parse(selectedTime[0] + ":00");
                        } catch (ParseException exception) {
                            exception.printStackTrace();
                        }


                        // Calculating the difference in milliseconds
                        long differenceInMilliSeconds;


                        differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());


                        // Calculating the difference in Hours
                        long differenceInHours
                                = (differenceInMilliSeconds / (60 * 60 * 1000))
                                % 24;

                        // Calculating the difference in Minutes
                        long differenceInMinutes
                                = (differenceInMilliSeconds / (60 * 1000)) % 60;

                        // Calculating the difference in Seconds
                        long differenceInSeconds
                                = (differenceInMilliSeconds / 1000) % 60;

                        // Printing the answer
                        System.out.println(
                                "Difference is " + differenceInHours + " hours "
                                        + differenceInMinutes + " minutes "
                                        + differenceInSeconds + " Seconds. ");

                        //
                        int minTime, checkTime;
                        minTime = Integer.parseInt(min_time);
                        checkTime = Integer.parseInt(String.valueOf(differenceInHours));
//
                        if (minTime == 0) {
                            productDetailPresenter.productAddToCartApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.ITEM_ID, ""), tv_productCount.getText().toString(), edt_note.getText().toString(),
                                    SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.MODE_ID, ""), "", "", SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.MODE_ID, ""));
                        } else {
                            if (minTime > checkTime) {
                                productDetailPresenter.productAddToCartApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.ITEM_ID, ""), tv_productCount.getText().toString(), edt_note.getText().toString(),
                                        SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.MODE_ID, ""), "", "", SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.MODE_ID, ""));

                            } else {
                                Helper.showToast(ProductDetailActivity.this, getString(R.string.select_valid_time));

                            }
                        }
//


                    } else {
                        Intent i1 = new Intent(this, LoginActivity.class);
                        startActivity(i1);
                    }
                } catch (Exception g) {
                }
                break;

            case R.id.backButton:
                try {
                    if(deep_linking_back.equalsIgnoreCase("true")){
                        Intent intent = new Intent(ProductDetailActivity.this, LocationActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                        finish();
                    }else{
                        finish();
                    }
                } catch (Exception g) {
                }
                break;

        }
    }

    String max_time_arabic;

    @Override
    public void onSuccessGetProductDetailAPi(ProductDetailResponse productDetailResponse) {
        try {
            if (productDetailResponse.getStatus()) {

                id= String.valueOf(productDetailResponse.getData().getId());
                max_time_arabic = productDetailResponse.getData().getArabicMaxTime();

                try {
//                    Picasso.get().load("" + productDetailResponse.getData().getItemLogoPath()).into(img_productImage);
                    setImageSlider(productDetailResponse.getData().getImages());
                    img=productDetailResponse.getData().getImages().get(0).getItem_logo_path();
//                    Picasso.get().load("" + productDetailResponse.getData().getItemLogoPath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(img_productImage);
                } catch (Exception ex) {
                }

                try {
                    if (productDetailResponse.getData().getIsFavorite()) {
                        addToFavButton.setBackgroundResource(R.drawable.ic_heart_red);
                        addToFev = true;

                    } else {
                        addToFavButton.setBackgroundResource(R.drawable.ic_heart);
                        addToFev = false;
                    }
                } catch (Exception g) {
                }

                if (SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                    mealNameTextView.setText("" + productDetailResponse.getData().getArabicItemName());
                    mealTagTextView.setText(Html.fromHtml("" + productDetailResponse.getData().getArabicItemLongDescription()));
                    tittle=productDetailResponse.getData().getArabicItemName();
                    subtittle= String.valueOf(productDetailResponse.getData().getArabicFoodDetails());
                    priceTextView.setText("" + productDetailResponse.getData().getItemCostPerServe() + " KWD");
                    tv_forPersions.setText( getString(R.string._for_)+" " + productDetailResponse.getData().getItemServingCapacity()+" "+getString(R.string.persons));
                    tv_minNots.setText("" + productDetailResponse.getData().getCaterer().getTimeShow());
                    tv_minOrder.setText("" + productDetailResponse.getData().getCaterer().getMinOrder() + " KWD");
                }

                if (SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                    tittle=productDetailResponse.getData().getItemName();
                    subtittle= String.valueOf(productDetailResponse.getData().getFoodDetails());
                    mealNameTextView.setText("" + productDetailResponse.getData().getItemName());
                    mealTagTextView.setText(Html.fromHtml("" + productDetailResponse.getData().getItemLongDescription()));
                    priceTextView.setText("" + productDetailResponse.getData().getItemCostPerServe() + " KWD");
                    tv_forPersions.setText("For " + productDetailResponse.getData().getItemServingCapacity() + " Persons");
                    tv_minNots.setText("" + productDetailResponse.getData().getCaterer().getTimeShow());
                    if ("" + productDetailResponse.getData().getCaterer().getMinOrder() == null) {
                        tv_minOrder.setText("---");
                    } else {
                        tv_minOrder.setText("" + productDetailResponse.getData().getCaterer().getMinOrder() + " KWD");
                    }

                }


                if (productDetailResponse.getData().getCaterer().getDeliveryCharge() == 0) {
                    tv_deleveryCharges.setText("FREE");
                } else {
                    tv_deleveryCharges.setText("" + productDetailResponse.getData().getCaterer().getDeliveryCharge());
                }


                try {
                    mProductPrice = Double.parseDouble(String.valueOf(productDetailResponse.getData().getItemCostPerServe()));
                    tv_totalPrice.setText(mProductPrice + " KWD");
                } catch (Exception g) {
                }

            }
        } catch (Exception g) {
        }
    }

    @Override
    public void onSuccessProductAddToCartAPi(ProductAddToCartResponse productAddToCartResponse) {
        try {
            if (productAddToCartResponse.getStatus()) {
                Toast.makeText(getActivityContext(), productAddToCartResponse.getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
            } else {
                Toast.makeText(getActivityContext(), productAddToCartResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception j) {
        }
    }

    @Override
    public void onSuccessAddToFevItemAPi(RestourentAddToFevResponse restourentAddToFevResponse) {
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
        Log.i("OKKKKK", msg);
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
        if(deep_linking_back.equalsIgnoreCase("true")){
            Intent intent = new Intent(ProductDetailActivity.this, LocationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
            finish();
        }else{
            finish();
            super.onBackPressed();
        }
    }

    private void setImageSlider(ArrayList<RD_Image> rd_imageArrayList) {

        try {
            CateringSDSliderAdapter sliderAdapter = new CateringSDSliderAdapter(ProductDetailActivity.this, rd_imageArrayList);
            imageSlider.setSliderAdapter(sliderAdapter);
            imageSlider.setScrollTimeInSec(5); //set scroll delay in seconds :
            imageSlider.startAutoCycle();
            imageSlider.setIndicatorEnabled(false);
            imageSlider.setAutoCycle(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @OnClick(R.id.shareImageView)
    public void onclickshareImageView(){
        try {
            dynamicLinkHelper.createDynamicLinkForFirebase(tittle,img, id,"product_detail",subtittle,status,min_time);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}