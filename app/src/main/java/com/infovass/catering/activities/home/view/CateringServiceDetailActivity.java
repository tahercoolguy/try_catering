package com.infovass.catering.activities.home.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.infovass.catering.R;
import com.infovass.catering.activities.adapers.AddMainOnFoodItemAdapters;
import com.infovass.catering.activities.adapers.ItemsAdapters;
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.cart.view.CartActivity;
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
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CateringServiceDetailActivity extends BaseActivity implements ProductDetailView {

    int femailService = 0, alert = 0;
    float totalAmount;
    List<ProductDetailResponse.Item> addons = new ArrayList<>();
    List<ProductDetailResponse.Meal> meals = new ArrayList<ProductDetailResponse.Meal>();
    AddMainOnFoodItemAdapters addOnFoodItemsAdapters;
    ItemsAdapters itemsAdapters;
    boolean addToFev = false;
    ProductDetailPresenter productDetailPresenter;
    private ProgressHUD progressHUD;
    @BindView(R.id.rel_findFood)
    RelativeLayout rel_findFood;
    @BindView(R.id.backButton)
    ImageButton backButton;
    @BindView(R.id.img_productImage)
    AppCompatImageView img_productImage;
    @BindView(R.id.tv_setuUpTime)
    AppCompatTextView tv_setuUpTime;
    @BindView(R.id.tv_requirements)
    AppCompatTextView tv_requirements;
    @BindView(R.id.addToFavButton)
    AppCompatImageButton addToFavButton;
    @BindView(R.id.tv_forPersons)
    AppCompatTextView tv_forPersons;
    @BindView(R.id.mealNameTextView)
    AppCompatTextView mealNameTextView;
    @BindView(R.id.mealTagTextView)
    AppCompatTextView mealTagTextView;
    @BindView(R.id.serveTagTextView)
    AppCompatTextView serveTagTextView;
    @BindView(R.id.tv_foodDetail)
    AppCompatTextView tv_foodDetail;
    @BindView(R.id.tv_service)
    AppCompatTextView tv_service;
    @BindView(R.id.lnr_serviceRequest)
    LinearLayout lnr_serviceRequest;
    @BindView(R.id.tv_femailServiceCount)
    AppCompatTextView tv_femailServiceCount;
    @BindView(R.id.img_femailServiceMin)
    AppCompatImageView img_femailServiceMin;
    @BindView(R.id.img_femailServiceMax)
    AppCompatImageView img_femailServiceMax;
    @BindView(R.id.tv_total)
    AppCompatTextView tv_total;
    @BindView(R.id.rv_foodItems)
    RecyclerView rv_foodItems;
    @BindView(R.id.edt_note)
    AppCompatEditText edt_note;
    @BindView(R.id.ch_femailServices)
    CheckBox ch_femailServices;
    @BindView(R.id.arrowImageView)
    ImageView arrowImageView;
    @BindView(R.id.tv_note)
    AppCompatTextView tv_note;
    @BindView(R.id.rv_Items)
    RecyclerView rv_Items;
    int id;
    String status;

    JsonArray jsonArray = new JsonArray();
    JsonArray jsonArray1 = new JsonArray();

    private HashMap<String, Integer> addOnCartItems = new HashMap<>();
    private HashMap<String, Integer> mealCartItems = new HashMap<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @BindView(R.id.not_availableTxt)
    AppCompatTextView not_availableTxt;

    @BindView(R.id.not_availableRL)
    RelativeLayout not_availableRL;


    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catering_service_detail);
        Bundle bundle = getIntent().getExtras();
        try {
            getWindow().setStatusBarColor(Color.BLACK);
        } catch (Exception t) {
        }
        ButterKnife.bind(this);


        Intent mIntent = getIntent();
        status = mIntent.getStringExtra("status");

        if (status.equalsIgnoreCase("1")) {
            not_availableRL.setVisibility(View.VISIBLE);
            rel_findFood.setVisibility(View.GONE);
        } else {
            not_availableRL.setVisibility(View.GONE);
            rel_findFood.setVisibility(View.VISIBLE);
        }

        //for adapter
        addOnFoodItemsAdapters = new AddMainOnFoodItemAdapters(getActivityContext(), addons);
        rv_foodItems.setHasFixedSize(true);
        rv_foodItems.setLayoutManager(new LinearLayoutManager(getActivityContext()));
        rv_foodItems.setAdapter(addOnFoodItemsAdapters);
        addOnFoodItemsAdapters.setOnItemClickListener(new AddMainOnFoodItemAdapters.OnItemClickListener() {
            @Override
            public void onItemClick(int postion, int vertPos, Integer id) {


            }

            @Override
            public void onItemClickMax(int verposition, int postion, AppCompatTextView tv_femailServiceCount) {
                try {
                    int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
                    itemCount = itemCount + 1;
                    tv_femailServiceCount.setText("" + itemCount);
                    // Double total = totalAmount + addons.get(position).getItem().get(position).getPrice();
                    float total = totalAmount + addons.get(postion).getItem().get(verposition).getPrice();
                    totalAmount = total;
                    tv_total.setText(total + " KWD");

//                    tv_total.setText(String.format("%.3f", total) + " KWD");
                    Log.d("sssss",total+ " KWD");

                    id = addons.get(postion).getItem().get(verposition).getId();

                    addOnCartItems.put(String.valueOf(id), itemCount);

//                    JsonObject jsonObject = new JsonObject();
//                    jsonObject.addProperty("id",id);
//                    jsonObject.addProperty("quantity",itemCount);
//                    jsonArray.add(jsonObject);
                } catch (Exception g) {
                }
            }

            @Override
            public void onItemClickMin(int verposition, int postion, AppCompatTextView tv_femailServiceCount) {
                try {
                    int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
                    itemCount = itemCount - 1;
                    if (itemCount < 0) {
                        Toast.makeText(CateringServiceDetailActivity.this, "Cannot set item count -ve.", Toast.LENGTH_SHORT).show();
                    } else {
                        tv_femailServiceCount.setText("" + itemCount);
                        Float total = totalAmount - addons.get(postion).getItem().get(verposition).getPrice();
                        totalAmount = total;
                        tv_total.setText(total + " KWD");
//                        tv_total.setText(String.format("%.3f", total) + " KWD");

                        id = addons.get(postion).getItem().get(verposition).getId();

                        addOnCartItems.put(String.valueOf(id), itemCount);

//                        JsonObject jsonObject = new JsonObject();
//                        jsonObject.addProperty("id",id);
//                        jsonObject.addProperty("quantity",itemCount);
//                        jsonArray.add(jsonObject);

                    }
                } catch (Exception g) {
                }
            }
        });
//        addOnFoodItemsAdapters.setOnItemClickListener(new AddMainOnFoodItemAdapters.OnItemClickListener() {
//            @Override
//            public void onClickaddOnMin(int position, AppCompatTextView tv_femailServiceCount) {
//                try {
//                    int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
//                    itemCount = itemCount - 1;
//                    if (itemCount < 0) {
//                        Toast.makeText(CateringServiceDetailActivity.this, "Cannot set item count -ve.", Toast.LENGTH_SHORT).show();
//                    } else {
//                        tv_femailServiceCount.setText("" + itemCount);
//                        Double total = totalAmount - addons.get(position).getItem().get(position).getPrice();
//                        totalAmount = total;
//                        tv_total.setText(total + " KWD");
//                    }
//                } catch (Exception g) {
//                }
//            }
//
//            @Override
//            public void onClickaddOnMax(int position, AppCompatTextView tv_femailServiceCount) {
//                try {
//                    int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
//                    itemCount = itemCount + 1;
//                    tv_femailServiceCount.setText("" + itemCount);
//                    Double total = totalAmount + addons.get(position).getItem().get(position).getPrice();
//                    totalAmount = total;
//                    tv_total.setText(total + " KWD");
//                } catch (Exception g) {
//                }
//            }
//
//        });

        //for meal
        itemsAdapters = new ItemsAdapters(getActivityContext(), meals);
        rv_Items.setHasFixedSize(true);
        rv_Items.setLayoutManager(new LinearLayoutManager(getActivityContext()));
        rv_Items.setAdapter(itemsAdapters);
        itemsAdapters.setOnItemClickListener(new ItemsAdapters.OnItemClickListener() {
            @Override
            public void onClickaddOnMin(int verposition,int position, AppCompatTextView tv_femailServiceCount) {
                try {
                    int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
                    //  itemCount = itemCount - 1;
                    if (itemCount < 0) {
                        Toast.makeText(CateringServiceDetailActivity.this, "Cannot set item count -ve.", Toast.LENGTH_SHORT).show();
                    } else {
//                        tv_femailServiceCount.setText("" + itemCount);
//                        Double total = totalAmount - addons.get(position).getItem().get(position).getPrice();
//                        totalAmount = total;
//                        tv_total.setText(total + " KWD");

                       // id = meals.get(position).getId();
                        id = meals.get(position).getMealItems().get(verposition).getId();
                        mealCartItems.put(String.valueOf(id), itemCount);

//                        JsonObject jsonObject = new JsonObject();
//                        jsonObject.addProperty("id", id);
//                        jsonObject.addProperty("quantity", itemCount);
//                        jsonArray1.add(jsonObject);
                    }
                } catch (Exception g) {
                }
            }

            @Override
            public void onClickaddOnMax(int verposition,int position, AppCompatTextView tv_femailServiceCount) {
                try {
                    int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
                    //   itemCount = itemCount + 1;
//                    tv_femailServiceCount.setText("" + itemCount);
//                    Double total = totalAmount + meals.get(position).getItem().get(position).getPrice();
//                    totalAmount = total;
//                    tv_total.setText(total + " KWD");

                    id = meals.get(position).getMealItems().get(verposition).getId();
                    mealCartItems.put(String.valueOf(id), itemCount);

//                    JsonObject jsonObject = new JsonObject();
//                    jsonObject.addProperty("id", id);
//                    jsonObject.addProperty("quantity", itemCount);
//                    jsonArray1.add(jsonObject);
                } catch (Exception g) {
                }
            }

        });

        progressHUD = ProgressHUD.create(getActivityContext(), getString(R.string.loading), false, null, null);
        productDetailPresenter = new ProductDetailImpl(this);
        productDetailPresenter.getProductDetailApi(//SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""),
                SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.ITEM_ID, ""));
//                , SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.MODE_ID, ""));
        //  productDetailPresenter.getProductDetailApi("36");
    }

    @OnClick({R.id.arrowImageView, R.id.ch_femailServices, R.id.addToFavButton, R.id.rel_findFood, R.id.backButton, R.id.img_femailServiceMin, R.id.img_femailServiceMax})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.arrowImageView:
                try {
                    BottomSheetInfoFragment bottomSheetInfoFragment = BottomSheetInfoFragment.newInstance();
                    bottomSheetInfoFragment.show(getSupportFragmentManager(), "bottomSheetDialog");
                } catch (Exception g) {
                }
                break;

            case R.id.ch_femailServices:
                try {
                    if (ch_femailServices.isChecked()) {
                        femailService = 1;
                    } else {
                        femailService = 0;
                    }
                } catch (Exception g) {
                }
                break;

            case R.id.img_femailServiceMax:
                try {
                    int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
                    itemCount = itemCount + 1;
                    tv_femailServiceCount.setText("" + itemCount);
                } catch (Exception g) {
                }
                break;

            case R.id.img_femailServiceMin:
                try {
                    int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
                    itemCount = itemCount - 1;
                    if (itemCount < 0) {
                        Toast.makeText(getActivityContext(), "You cannot set value in -.", Toast.LENGTH_SHORT).show();
                    } else {
                        tv_femailServiceCount.setText("" + itemCount);
                    }
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

            case R.id.rel_findFood:
                try {
                    if (SharedPreferencesUtils.getInstance(this).getValue(Constants.KEY_LOGGED_IN, false)) {
                        SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.addressID, "");
                        SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.address, "");

                        jsonArray = new JsonArray();
                        for (Map.Entry<String, Integer> entry : addOnCartItems.entrySet()) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("id", Integer.parseInt(entry.getKey()));
                            jsonObject.addProperty("quantity", entry.getValue());
                            jsonArray.add(jsonObject);
                        }

                        jsonArray1 = new JsonArray();
                        for (Map.Entry<String, Integer> entry : mealCartItems.entrySet()) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("id", Integer.parseInt(entry.getKey()));
                            jsonObject.addProperty("quantity", entry.getValue());
                            jsonArray1.add(jsonObject);
                        }

                        productDetailPresenter.productAddToCartApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""),
                                SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.ITEM_ID, ""),
                                "" + femailService, "no", edt_note.getText().toString(), SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.MODE_ID, ""),
                                jsonArray, jsonArray1, "");
                    } else {
                        Intent i1 = new Intent(this, LoginActivity.class);
                        startActivity(i1);
                    }
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
    public void onSuccessGetProductDetailAPi(ProductDetailResponse productDetailResponse) {
        try {
            if (productDetailResponse.getStatus()) {

                try {
//                    Picasso.get().load("" + productDetailResponse.getData().getItemLogoPath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(img_productImage);
                    Picasso.get().load("" + productDetailResponse.getData().getItemLogoPath()).into(img_productImage);

                } catch (Exception ex) {
                }

                try {
                    if (productDetailResponse.getData().getCaterer().getFemaleService().equalsIgnoreCase("available")) {
                        ch_femailServices.setVisibility(View.VISIBLE);
                    } else {
                        ch_femailServices.setVisibility(View.GONE);
                    }
                } catch (Exception h) {
                }

                try {
                    addons.clear();
                    meals.clear();
                    if (productDetailResponse.getData().getAddon().size() == 0) {

                    } else {
                        addons.addAll(productDetailResponse.getData().getAddon().get(0).getItems()); //work pending
                        //   addons.addAll(productDetailResponse.getData().getAddon().get(0).getItems().get(0).getItem()); //work pending
                        addOnFoodItemsAdapters.notifyDataSetChanged();
                    }

                    if (productDetailResponse.getData().getMeals().size() == 0) {

                    } else {
                        meals.addAll(productDetailResponse.getData().getMeals());
                        itemsAdapters.notifyDataSetChanged();
                    }

                } catch (Exception ignore) {
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
                    Log.i("LLLLLL", "OPOPOP");
                    tv_total.setText(productDetailResponse.getData().getItemCostPerServe() + " KWD");
                    totalAmount = Float.valueOf((String.valueOf(productDetailResponse.getData().getArabicItemCostPerServe())));
                    String SetupTimeInMinute = "" + productDetailResponse.getData().getCaterer().getSetupTimeInMinute();
                    if (SetupTimeInMinute != null) {
                        tv_setuUpTime.setText("" + productDetailResponse.getData().getSetupTimeInMinute() + " Min");
                    } else {
                        tv_setuUpTime.setText("---");
                    }

                    String arabicRecuirement = "" + productDetailResponse.getData().getCaterer().getRequirements();
                    if (arabicRecuirement != null) {
                        tv_requirements.setText("" + productDetailResponse.getData().getRequirements());
                    } else {
                        tv_requirements.setText("---");
                    }
                    tv_forPersons.setText("For " + productDetailResponse.getData().getItemServingCapacity() + " Persons");
                    mealNameTextView.setText("" + productDetailResponse.getData().getArabicItemName());
                    mealTagTextView.setText(Html.fromHtml("" + productDetailResponse.getData().getArabicItemLongDescription()));
                    serveTagTextView.setText("For " + productDetailResponse.getData().getItemServingCapacity() + " Persons");
                    tv_foodDetail.setText("" + productDetailResponse.getData().getArabicFoodDetails());
                    //  tv_note.setText(""+productDetailResponse.getData().getArabicFoodDetails());
                    tv_service.setText("" + productDetailResponse.getData().getArabicServiceAndPresentation());
                }

                if (SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                    tv_total.setText(productDetailResponse.getData().getItemCostPerServe() + " KWD");
                    totalAmount = Float.valueOf((String.valueOf(productDetailResponse.getData().getArabicItemCostPerServe())));
                    String SetupTimeInMinute = "" + productDetailResponse.getData().getCaterer().getSetupTimeInMinute();
                    String SetupTime = "" + productDetailResponse.getData().getCaterer().getSetupTimeInMinute();
                    if (SetupTime != null) {
                        tv_setuUpTime.setText("" + productDetailResponse.getData().getSetupTimeInMinute() + " Min");
                    } else {
                        tv_setuUpTime.setText("---");
                    }

                    String recuirement = "" + productDetailResponse.getData().getCaterer().getRequirements();
                    if (recuirement != null) {
                        tv_requirements.setText("" + productDetailResponse.getData().getRequirements());
                    } else {
                        tv_requirements.setText("---");
                    }

                    tv_forPersons.setText("For " + productDetailResponse.getData().getItemServingCapacity() + " Persons");
                    mealNameTextView.setText("" + productDetailResponse.getData().getItemName());
                    mealTagTextView.setText(Html.fromHtml("" + productDetailResponse.getData().getItemLongDescription()));
                    serveTagTextView.setText("For " + productDetailResponse.getData().getItemServingCapacity() + " Persons");
                    tv_foodDetail.setText("" + productDetailResponse.getData().getFoodDetails());
                    // tv_note.setText(""+productDetailResponse.getData().getArabicFoodDetails());
                    tv_service.setText("" + productDetailResponse.getData().getServiceAndPresentation());
                }

            }
        } catch (Exception g) {
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
    public void onSuccessProductAddToCartAPi(ProductAddToCartResponse productAddToCartResponse) {
        try {
            if (productAddToCartResponse.getStatus()) {
                try {
                    alert = productAddToCartResponse.getalert();
                } catch (Exception g) {
                }

//                if(alert == 1)
//                {
//
//                }else
//                {
                Toast.makeText(getActivityContext(), productAddToCartResponse.getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CateringServiceDetailActivity.this, CartActivity.class);
                startActivity(intent);
                //  }
            } else {
                Toast.makeText(getActivityContext(), productAddToCartResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception j) {
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

}