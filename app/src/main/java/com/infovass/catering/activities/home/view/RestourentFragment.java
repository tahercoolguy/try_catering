package com.infovass.catering.activities.home.view;

import static android.app.Activity.RESULT_OK;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import static com.infovass.catering.Controller.AppController.TAG;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.infovass.catering.DM.Order_DetailsDM.OrderDetailsRoot;
import com.infovass.catering.MyFormat.Controller.AppController;
import com.infovass.catering.MyFormat.Utils.ConnectionDetector;
import com.infovass.catering.R;
import com.infovass.catering.Utils.Helper;
import com.infovass.catering.activities.CalenderActivity;
import com.infovass.catering.activities.DataModel.MainRestaurentDM.RC_Data;
import com.infovass.catering.activities.DataModel.MainRestaurentDM.RC_Root;
import com.infovass.catering.activities.DataModel.RD_TopRankedCaterersItem;
import com.infovass.catering.activities.DataModel.RD_catererData;
import com.infovass.catering.activities.DataModel.RD_caterers_Bannerdata;
import com.infovass.catering.activities.DataModel.RD_caterers_Root;
import com.infovass.catering.activities.DataModel.RD_caterers_TopRankeCaterers;
import com.infovass.catering.activities.Location.view.LocationActivity;
import com.infovass.catering.activities.Location.view.TimeActivity;
import com.infovass.catering.activities.MainActivity;
import com.infovass.catering.activities.adapers.HomeAdSliderAdapter;
import com.infovass.catering.activities.adapers.Order_DetailAdapter;
import com.infovass.catering.activities.adapers.RestourentcategoriesAdapter;
import com.infovass.catering.activities.adapers.ResturantLargeAdapter;
import com.infovass.catering.activities.adapers.ResturantMainLargeAdapter;
import com.infovass.catering.activities.adapers.ResturantNewLargeAdapter;
import com.infovass.catering.activities.adapers.ResturantTopMenuAdapter;
import com.infovass.catering.activities.adapers.ResturantTopRestaurentAdapter;
import com.infovass.catering.activities.home.model.RestourentListResponse;
import com.infovass.catering.activities.home.presenter.RestourentImpl;
import com.infovass.catering.activities.home.presenter.RestourentPresenter;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.order.OrderDetailActivity;
import com.infovass.catering.activities.utill.ProgressHUD;
import com.smarteist.autoimageslider.SliderView;

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
import retrofit.mime.TypedString;
import retrofit2.http.Field;

public class RestourentFragment extends Fragment implements RestourentView {
    private final static int LOCATION_REQUEST_CODE = 1;
    private final static int DATE_REQUEST_CODE = 2;
    private final static int TIME_REQUEST_CODE = 3;

    //    List<RestourentListResponse.Datum> restourentLIst = new ArrayList<>();
    List<RC_Data> restourentLIst = new ArrayList<>();
    private ProgressHUD progressHUD;
    RestourentPresenter restourentPresenter;
    View view;
    RestourentcategoriesAdapter restourentcategoriesAdapter;
    //    ResturantLargeAdapter resturantLargeAdapter;
    ResturantNewLargeAdapter resturantLargeAdapter;
    @BindView(R.id.resturantListView)
    RecyclerView resturantListView;
    @BindView(R.id.detail_recyclerView)
    RecyclerView detail_recyclerView;
    @BindView(R.id.tv_city)
    AppCompatTextView tv_city;
    @BindView(R.id.tv_time)
    AppCompatTextView tv_time;
    @BindView(R.id.tv_date)
    AppCompatTextView tv_date;

    @BindView(R.id.locationLL)
    LinearLayout locationLL;

    @BindView(R.id.dateLL)
    LinearLayout dateLL;

    @BindView(R.id.timeLL)
    LinearLayout timeLL;

    @BindView(R.id.searchLL)
    LinearLayout searchLL;

    @BindView(R.id.framelayout)
    FrameLayout framelayout;

    @BindView(R.id.imageSlider)
    SliderView imageSlider;
    @BindView(R.id.topMenuRcv)
    RecyclerView topMenuRcv;
    @BindView(R.id.topRestaurentsRcv)
    RecyclerView topRestaurentsRcv;
    @BindView(R.id.topmenuTxt)
    TextView topmenuTxt;
    @BindView(R.id.topResTxt)
    TextView topResTxt;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swiperefresh;
    @BindView(R.id.scroolNested)
    NestedScrollView scroolNested;
    @BindView(R.id.headingLayout)
    LinearLayout headingLayout;
    @BindView(R.id.locationTxt)
    AppCompatTextView locationTxt;
    @BindView(R.id.dateTxt)
    AppCompatTextView dateTxt;
    @BindView(R.id.timeTxt)
    AppCompatTextView timeTxt;
    @BindView(R.id.shimmerFrameLayout)
    ShimmerFrameLayout shimmerFrameLayout;
    @BindView(R.id.homeAdShimmerLayout)
    ShimmerFrameLayout homeAdShimmerLayout;
    @BindView(R.id.topResShimmerLayout)
    ShimmerFrameLayout topResShimmerLayout;

    @BindView(R.id.topMenuShimmerLayout)
    ShimmerFrameLayout topMenuShimmerLayout;


    Activity activity;
    private AppController appController;
    private Dialog progress;
    private ConnectionDetector connectionDetector;
    Context context;
    int previousScrollY = 0;
    int scrollThreshold = 30;
    boolean refreshBoolean = false;

    public RestourentFragment() {
        // Required empty public constructor
    }

    public static RestourentFragment newInstance() {
        RestourentFragment fragment = new RestourentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_restourent, container, false);
        ButterKnife.bind(this, view);
        activity = getActivity();
        context = getActivity().getApplicationContext();
        appController = (AppController) getActivity().getApplicationContext();
        connectionDetector = new ConnectionDetector(getActivity());
        tv_city.setSelected(true);
        tv_date.setSelected(true);
        tv_time.setSelected(true);
        searchLL.setVisibility(View.GONE);
        framelayout.setVisibility(View.VISIBLE);
        progressHUD = ProgressHUD.create(getContext(), getString(R.string.loading), false, null, null);
//        restourentPresenter = new RestourentImpl(this);

        swiperefresh.setRefreshing(true);
        shimmerFrameLayout.startShimmer();
        homeAdShimmerLayout.startShimmer();
        topResShimmerLayout.startShimmer();
        topMenuShimmerLayout.startShimmer();
        imageSlider.setVisibility(View.GONE);
        topRestaurentsRcv.setVisibility(View.GONE);
        topMenuRcv.setVisibility(View.GONE);
//        restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
//        restourentPresenter.getRestourentlistApi("", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

        newRandomCaterers();
        restaurentAPI();


        tv_time.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_TIME, ""));
        tv_date.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

//        List<String> list = new ArrayList<>();
//        list.add(getResources().getString(R.string.all));
//        list.add(getResources().getString(R.string.catering));
//        list.add(getResources().getString(R.string.delivery));
//
//        restourentcategoriesAdapter = new RestourentcategoriesAdapter(list, getContext());
//        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(
//                getContext(),
//                LinearLayoutManager.HORIZONTAL,
//                false);
//        detail_recyclerView.setLayoutManager(HorizontalLayout);
//        detail_recyclerView.setAdapter(restourentcategoriesAdapter);
//        restourentcategoriesAdapter.setOnItemClickListener(new RestourentcategoriesAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position, TextView custom_tab_textView, LinearLayout detail_item_linearLayout) {
//                restourentcategoriesAdapter.notifyDataSetChanged();
//                if (position == 0) {
//                    restourentPresenter.getRestourentlistApi("", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
//                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
//                }
//                if (position == 1) {
//                    restourentPresenter.getRestourentlistApi("1", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
//                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
//                }
//                if (position == 2) {
//                    restourentPresenter.getRestourentlistApi("2", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
//                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
//                }
////                if (position==3)
////                {
////                    restourentPresenter.getRestourentlistApi("3",SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""));
////                }
//            }
//        });
        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
            resturantListView.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            // Create LayoutParams and set margins programmatically
            LinearLayout.LayoutParams topRestaurentsRcvlayoutParams = (LinearLayout.LayoutParams) topRestaurentsRcv.getLayoutParams();
            LinearLayout.LayoutParams topMenuRcvlayoutParams = (LinearLayout.LayoutParams) topMenuRcv.getLayoutParams();


            topRestaurentsRcvlayoutParams.setMargins(0, 0, 21, 0);
            topMenuRcvlayoutParams.setMargins(0, 0, 21, 0);
            topRestaurentsRcv.setLayoutParams(topRestaurentsRcvlayoutParams);
            topMenuRcv.setLayoutParams(topMenuRcvlayoutParams);

            tv_city.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_ARABIC_AREA_NAME, ""));


        } else {
            resturantListView.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            // Create LayoutParams and set margins programmatically

            LinearLayout.LayoutParams topRestaurentsRcvlayoutParams = (LinearLayout.LayoutParams) topRestaurentsRcv.getLayoutParams();
            LinearLayout.LayoutParams topMenuRcvlayoutParams = (LinearLayout.LayoutParams) topMenuRcv.getLayoutParams();

            tv_city.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_NAME, ""));
            topRestaurentsRcvlayoutParams.setMargins(21, 0, 0, 0);
            topMenuRcvlayoutParams.setMargins(21, 0, 0, 0);
            topRestaurentsRcv.setLayoutParams(topRestaurentsRcvlayoutParams);
            topMenuRcv.setLayoutParams(topMenuRcvlayoutParams);

        }

//        resturantLargeAdapter = new ResturantLargeAdapter(getContext(), restourentLIst);
//        resturantListView.setLayoutManager(new LinearLayoutManager(getContext()));
//        resturantListView.setAdapter(resturantLargeAdapter);
//        resturantLargeAdapter.setOnItemClickListener(new ResturantLargeAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position, int selectedposition, int Restaurant_Status, List<RestourentListResponse.Datum> restourentLIst) {
//                SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(position).getId());
//                int restaurententID = restourentLIst.get(position).getId();
//                String restaurant_Status = String.valueOf(Restaurant_Status);
//                Intent intent = new Intent(getContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
//                        .putExtra("restaurant_Status", restaurant_Status);
//                startActivity(intent);
//                activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
//
//            }
//        });

        swiperefresh.setRefreshing(false);
        swiperefresh.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.
//                        restourentPresenter.getRestourentlistApi("", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

                        swiperefresh.setRefreshing(false);
                        newRandomCaterers();
                        restaurentAPI();
                    }
                }
        );

        // Set up the scroll listener
        scroolNested.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                int scrollDifference = scrollY - previousScrollY;
//                if (scrollDifference > scrollThreshold) {
//                    // Scrolling downwards
//                    hideIcon();
//                } else if (scrollDifference < -scrollThreshold) {
//                    // Scrolling upwards
//                    showIcon();
//                }
//                previousScrollY = scrollY;
                if (scrollY > 100) {
                    if (scrollY > oldScrollY) {
                        Log.i("TAG", "Scroll DOWN");
//                        hideIcon();
                        setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.white));
                        setStatusBarIconColor(true);
                        refreshBoolean = false;
                    }
                }

//                if (scrollY < oldScrollY) {
//                    Log.i(TAG, "Scroll UP");
//                    showIcon();
//                }

                if (scrollY == 0) {
                    Log.i(TAG, "TOP SCROLL");
//                    showIcon();
                    setStatusBarIconColor(false);
                    setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                    refreshBoolean = true;
                }

                if (scrollY == (v.getMeasuredHeight() - v.getChildAt(0).getMeasuredHeight())) {
                    Log.i(TAG, "BOTTOM SCROLL");
//                    hideIcon();
                    setStatusBarIconColor(true);
                    setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.white));
                    refreshBoolean = false;

                }

            }
        });


        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
            locationTxt.setText("موقع");
            dateTxt.setText("تاريخ");
            timeTxt.setText("وقت");
//            topmenuTxt.setText("القوائم");
//            topResTxt.setText("أفضل");
        } else {

            locationTxt.setText("Location");
            dateTxt.setText("Date");
            timeTxt.setText("Time");
//            topmenuTxt.setText(getString(R.string.top_menus));
//            topResTxt.setText(getString(R.string.top_restaurants));
        }
        // Set the initial color of the status bar
        setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
        return view;
    }

    //    public void closeKeyboard() {
//        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
//    }
//    public static void hideKeyboard(Activity activity) {
//        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
//            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
//        }
//    }
    @OnClick(R.id.locationLL)
    public void ClickLocationLL() {
        Intent intent = new Intent(getActivity(), LocationActivity.class);
        intent.putExtra("newlocationArea", "newlocationArea");
        startActivityForResult(intent, RESULT_OK);
        activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

    }

    @OnClick(R.id.dateLL)
    public void ClickDateLL() {

        Intent intent = new Intent(getActivity(), CalenderActivity.class);
        intent.putExtra("newdate", "newdate");
        startActivityForResult(intent, DATE_REQUEST_CODE);
        activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

    }

    @OnClick(R.id.timeLL)
    public void ClickTimeLL() {

        Intent intent = new Intent(getActivity(), TimeActivity.class);
        intent.putExtra("newtime", "newtime");
        startActivityForResult(intent, TIME_REQUEST_CODE);
        activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
    }

    @Override
    public void onSuccessGetRestourentListAPi(RestourentListResponse restourentListResponse) {
//        try {
//
//            if (restourentListResponse.getData().size() == 0) {
////                lnr_noProduct.setVisibility(View.VISIBLE);
//                resturantListView.setVisibility(View.GONE);
//
//                swiperefresh.setRefreshing(false);
//                restourentLIst = new ArrayList<>();
//                resturantLargeAdapter.notifyDataSetChanged();
//                // on below line we are stopping our shimmer
//                // and making its visibility to gone.
//                shimmerFrameLayout.startShimmer();
//                shimmerFrameLayout.setVisibility(View.VISIBLE);
//
//            } else {
////                lnr_noProduct.setVisibility(View.GONE);
//                // on below line we are stopping our shimmer
//                // and making its visibility to gone.
//                shimmerFrameLayout.stopShimmer();
//                shimmerFrameLayout.setVisibility(View.GONE);
//
//                resturantListView.setVisibility(View.VISIBLE);
//                restourentLIst.addAll(restourentListResponse.getData());
//                resturantLargeAdapter.notifyDataSetChanged();
//                swiperefresh.setRefreshing(false);
//                resturantLargeAdapter = new ResturantLargeAdapter(getContext(), restourentLIst);
//                resturantListView.setLayoutManager(new LinearLayoutManager(getContext()));
//                resturantListView.setAdapter(resturantLargeAdapter);
//                resturantLargeAdapter.setOnItemClickListener(new ResturantLargeAdapter.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(int position, int selectedposition, int Restaurant_Status, List<RestourentListResponse.Datum> restourentLIst) {
//                        SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(position).getId());
//                        int restaurententID = restourentLIst.get(position).getId();
//                        String restaurant_Status = String.valueOf(Restaurant_Status);
//                        Intent intent = new Intent(getContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
//                                .putExtra("restaurant_Status", restaurant_Status);
//                        startActivity(intent);
//                        activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
//
//                    }
//                });
//            }
//
//
//        } catch (Exception ignore) {
//            restourentLIst = new ArrayList<>();
//            ignore.printStackTrace();
//            resturantLargeAdapter.notifyDataSetChanged();
//
//        }
    }

    String newtime, newdate, newlocation;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == LOCATION_REQUEST_CODE) {
            if (data != null) {
                newlocation = data.getStringExtra("newlocationArea");
                if (newlocation != null) {
                    tv_city.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_NAME, ""));
                    tv_city.setText(newlocation);
//                    restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

                    newRandomCaterers();
                    restaurentAPI();
                }


            }
        }
        if (requestCode == DATE_REQUEST_CODE) {
            if (data != null) {
                String newdate = data.getStringExtra("newdate");
                tv_date.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
//                restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                newRandomCaterers();
                restaurentAPI();
            }
        }
        if (requestCode == TIME_REQUEST_CODE) {
            if (data != null) {
                String newtime = data.getStringExtra("newtime");
                String newtimes = data.getStringExtra("newtime");
                tv_time.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_TIME, ""));
//                restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

                newRandomCaterers();
                restaurentAPI();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void showLoading() {
        try {
//            progressHUD.show();
        } catch (Exception f) {
        }
    }

    @Override
    public void hideLoading() {
        try {
//            progressHUD.dismiss();
        } catch (Exception f) {
        }
    }

    @Override
    public void onFail(String msg) {
        resturantListView.setVisibility(View.GONE);
    }

    @Override
    public void onNoInternet() {

    }


    public void newRandomCaterers() {
        if (connectionDetector.isConnectingToInternet()) {

            String area_id = SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, "");
            String date = SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, "");
            MultipartTypedOutput multipartTypedOutput = new MultipartTypedOutput();
//            String token = SharedPreferencesUtils.getInstance(LocationActivity.this).getValue(Constants.TOKEN, "" );

            multipartTypedOutput.addPart("mode_type", new TypedString(""));
            multipartTypedOutput.addPart("area_id", new TypedString(area_id));
            multipartTypedOutput.addPart("date", new TypedString(date));

            appController.paServices.newRandomCaterers(multipartTypedOutput, new Callback<RD_caterers_Root>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void success(RD_caterers_Root rd_caterers_root, Response response) {

                    if (rd_caterers_root.getStatus().equalsIgnoreCase("true")) {

                        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {

                            topmenuTxt.setText("القوائم");
                            topResTxt.setText("أفضل");
                        } else {


                            topmenuTxt.setText(context.getString(R.string.top_menus));
                            topResTxt.setText(context.getString(R.string.top_restaurants));
                        }

//                        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
//                            topResTxt.setText("أفضل المطاعم");
//                            topmenuTxt.setText("القوائم العلوية");
//                        }
//
//                        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
//                            topResTxt.setText(context.getString(R.string.top_restaurants));
//                            topmenuTxt.setText(context.getString(R.string.top_menus));
//                        }


                        try {

                            if (rd_caterers_root.getData().getBannerData().size() > 0) {
                                homeAdShimmerLayout.setVisibility(View.GONE);
                                homeAdShimmerLayout.stopShimmer();
                                imageSlider.setVisibility(View.VISIBLE);
                                setImageSlider(rd_caterers_root.getData().getBannerData());
                            } else {
                                homeAdShimmerLayout.setVisibility(View.GONE);
                                homeAdShimmerLayout.stopShimmer();
                                imageSlider.setVisibility(View.GONE);
                            }

                        } catch (Exception e) {
                            homeAdShimmerLayout.setVisibility(View.GONE);
                            homeAdShimmerLayout.stopShimmer();
                            imageSlider.setVisibility(View.GONE);
                            e.printStackTrace();
                        }


                        try {
                            if (rd_caterers_root.getData().getTopRankedCaterersItems().size() > 0) {
                                topMenuShimmerLayout.setVisibility(View.GONE);
                                topMenuShimmerLayout.stopShimmer();
                                topMenuRcv.setVisibility(View.VISIBLE);
                                topmenuTxt.setVisibility(View.VISIBLE);
                                setTopMenuRcv(rd_caterers_root.getData().getTopRankedCaterersItems());
                            } else {
                                topMenuShimmerLayout.setVisibility(View.GONE);
                                topMenuShimmerLayout.stopShimmer();
                                topMenuRcv.setVisibility(View.GONE);
                                topmenuTxt.setVisibility(View.GONE);
                            }

                        } catch (Exception e) {
                            topMenuShimmerLayout.setVisibility(View.GONE);
                            topMenuShimmerLayout.stopShimmer();
                            topMenuRcv.setVisibility(View.GONE);
                            topmenuTxt.setVisibility(View.GONE);
                            e.printStackTrace();
                        }


                        try {


                            if (rd_caterers_root.getData().getTopRankedCaterers().size() > 0) {

                                topResShimmerLayout.setVisibility(View.GONE);
                                topResShimmerLayout.stopShimmer();
                                topRestaurentsRcv.setVisibility(View.VISIBLE);
                                topResTxt.setVisibility(View.VISIBLE);
                                setTopRestaurentsRcv(rd_caterers_root.getData().getTopRankedCaterers());

                            } else {
                                topResShimmerLayout.setVisibility(View.GONE);
                                topResShimmerLayout.stopShimmer();
                                topRestaurentsRcv.setVisibility(View.GONE);
                                topResTxt.setVisibility(View.GONE);
                            }

                        } catch (Exception e) {
                            topResShimmerLayout.setVisibility(View.GONE);
                            topResShimmerLayout.stopShimmer();
                            topRestaurentsRcv.setVisibility(View.GONE);
                            topResTxt.setVisibility(View.GONE);
                            e.printStackTrace();
                        }


                    } else {
                        homeAdShimmerLayout.setVisibility(View.VISIBLE);
                        imageSlider.setVisibility(View.GONE);
                        topRestaurentsRcv.setVisibility(View.GONE);
                        topMenuRcv.setVisibility(View.GONE);
                        homeAdShimmerLayout.startShimmer();
                        topResShimmerLayout.startShimmer();
                        topMenuShimmerLayout.startShimmer();
                        Helper.showToast(getActivity(), getString(R.string.something_wrong));
                    }

                }

                @Override
                public void failure(RetrofitError error) {
                    homeAdShimmerLayout.setVisibility(View.VISIBLE);
                    imageSlider.setVisibility(View.GONE);
                    topRestaurentsRcv.setVisibility(View.GONE);
                    topMenuRcv.setVisibility(View.GONE);
                    homeAdShimmerLayout.startShimmer();
                    topResShimmerLayout.startShimmer();
                    topMenuShimmerLayout.startShimmer();
                    error.printStackTrace();
                }
            });

        } else {
            Toast.makeText(getActivity(), getString(R.string.no_internet), Toast.LENGTH_SHORT).show();

        }
    }


    private void setImageSlider(ArrayList<RD_caterers_Bannerdata> caterers_bannerdata) {

        try {
            HomeAdSliderAdapter sliderAdapter = new HomeAdSliderAdapter(activity, caterers_bannerdata);
            imageSlider.setSliderAdapter(sliderAdapter);
            imageSlider.setScrollTimeInSec(4); //set scroll delay in seconds :
            imageSlider.startAutoCycle();
            imageSlider.setIndicatorEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setTopMenuRcv(ArrayList<RD_TopRankedCaterersItem> topRankedCaterersItems) {

        try {

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
            topMenuRcv.setLayoutManager(linearLayoutManager);
            ResturantTopMenuAdapter topMenuAdapter = new ResturantTopMenuAdapter(activity, topRankedCaterersItems);
            topMenuRcv.setAdapter(topMenuAdapter);

            topMenuAdapter.setOnItemClickListener(new ResturantTopMenuAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, int selectedposition, ArrayList<RD_TopRankedCaterersItem> restourentLIst) {
                    SharedPreferencesUtils.getInstance(activity.getApplicationContext()).setValue(Constants.ITEM_ID, "" + restourentLIst.get(position).getId());
//                SharedPreferencesUtils.getInstance(activity.getApplicationContext()).setValue(Constants.MODE_ID, "" + restourentLIst.get(position).getSubcategory_id());
//
//                    if (restourentLIst.get(position).getItem_logo().contains("caterer_item")) {
//                        Intent intent = new Intent(activity.getApplicationContext(), CateringServiceDetailActivity.class)
//                                .putExtra("status", restourentLIst.get(position).getStatus())
//                                .putExtra("min_time", restourentLIst.get(position).getAddon_item());
//                        activity.startActivity(intent);
//                        activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
//                    } else {
                    String min_time = "0";
                    min_time = restourentLIst.get(position).getCaterer().getMinimum_time();
                    Intent intent = new Intent(activity.getApplicationContext(), ProductDetailActivity.class)
                            .putExtra("status", restourentLIst.get(position).getStatus())
                            .putExtra("min_time", min_time);
                    activity.startActivity(intent);

                    activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
//                    }


                }
            });

            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                topMenuRcv.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            } else {
                topMenuRcv.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setTopRestaurentsRcv(ArrayList<RD_caterers_TopRankeCaterers> topRankedCaterersItems) {

        try {

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
            topRestaurentsRcv.setLayoutManager(linearLayoutManager);

            ResturantTopRestaurentAdapter topRestaurentAdapter = new ResturantTopRestaurentAdapter(activity, topRankedCaterersItems);

            topRestaurentsRcv.setAdapter(topRestaurentAdapter);


            topRestaurentAdapter.setOnItemClickListener(new ResturantTopRestaurentAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, int selectedposition, int Restaurant_Status, List<RD_caterers_TopRankeCaterers> restourentLIst) {
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(position).getId());
                    int restaurententID = Integer.parseInt(restourentLIst.get(position).getId());
                    String restaurant_Status = String.valueOf(Restaurant_Status);
                    Intent intent = new Intent(getContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
                            .putExtra("restaurant_Status", restaurant_Status);
                    startActivity(intent);
                    activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                }
            });

            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                topRestaurentsRcv.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            } else {
                topRestaurentsRcv.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setRestaurentsLargeRcv(ArrayList<RD_catererData> catererData) {

        try {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
            resturantListView.setLayoutManager(linearLayoutManager);

            ResturantMainLargeAdapter resturantMainLargeAdapter = new ResturantMainLargeAdapter(activity, catererData);

            resturantListView.setAdapter(resturantMainLargeAdapter);


            resturantMainLargeAdapter.setOnItemClickListener(new ResturantMainLargeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, int selectedposition, int Restaurant_Status, List<RD_catererData> restourentLIst) {
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(position).getId());
                    int restaurententID = Integer.parseInt(restourentLIst.get(position).getId());
                    String restaurant_Status = String.valueOf(Restaurant_Status);
                    Intent intent = new Intent(getContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
                            .putExtra("restaurant_Status", restaurant_Status);
                    startActivity(intent);
                    activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Define methods to hide and show the icon
    private void hideIcon() {
        // Hide the icon
        // For example: icon.setVisibility(View.GONE);
        headingLayout.setVisibility(View.GONE);

    }

    private void showIcon() {
        // Show the icon
        // For example: icon.setVisibility(View.VISIBLE);
        headingLayout.setVisibility(View.VISIBLE);
    }


    public void restaurentAPI() {
        if (connectionDetector.isConnectingToInternet()) {

            String area_id = SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, "");
            String date = SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, "");
            MultipartTypedOutput multipartTypedOutput = new MultipartTypedOutput();
//            String token = SharedPreferencesUtils.getInstance(LocationActivity.this).getValue(Constants.TOKEN, "" );

            multipartTypedOutput.addPart("mode_type", new TypedString(""));
            multipartTypedOutput.addPart("area_id", new TypedString(area_id));
            multipartTypedOutput.addPart("date", new TypedString(date));

            appController.paServices.RandomCaterers(multipartTypedOutput, new Callback<RC_Root>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void success(RC_Root rd_caterers_root, Response response) {

                    if (rd_caterers_root.getStatus().equalsIgnoreCase("true")) {

                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);

                        resturantListView.setVisibility(View.VISIBLE);
                        restourentLIst.addAll(rd_caterers_root.getData());
                        swiperefresh.setRefreshing(false);
                        try {
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
                            resturantListView.setLayoutManager(linearLayoutManager);

                            resturantLargeAdapter = new ResturantNewLargeAdapter(activity, rd_caterers_root.getData());

                            resturantListView.setAdapter(resturantLargeAdapter);


                            resturantLargeAdapter.setOnItemClickListener(new ResturantNewLargeAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position, int selectedposition, int Restaurant_Status, List<RC_Data> restourentLIst) {
                                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(position).getId());
                                    int restaurententID = Integer.parseInt(restourentLIst.get(position).getId());
                                    String restaurant_Status = String.valueOf(Restaurant_Status);
                                    Intent intent = new Intent(getContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
                                            .putExtra("restaurant_Status", restaurant_Status);
                                    startActivity(intent);
                                    activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                                }
                            });
                        } catch (Exception e) {
                            resturantListView.setVisibility(View.GONE);

                            swiperefresh.setRefreshing(false);
                            restourentLIst = new ArrayList<>();
                            // on below line we are stopping our shimmer
                            // and making its visibility to gone.
                            shimmerFrameLayout.startShimmer();
                            shimmerFrameLayout.setVisibility(View.VISIBLE);
                            e.printStackTrace();
                        }


                    } else {
                        resturantListView.setVisibility(View.GONE);

                        swiperefresh.setRefreshing(false);
                        restourentLIst = new ArrayList<>();
                        // on below line we are stopping our shimmer
                        // and making its visibility to gone.
                        shimmerFrameLayout.startShimmer();
                        shimmerFrameLayout.setVisibility(View.VISIBLE);
                        Helper.showToast(getActivity(), getString(R.string.something_wrong));
                    }

                }

                @Override
                public void failure(RetrofitError error) {

                    error.printStackTrace();
                }
            });

        } else {
            Toast.makeText(getActivity(), getString(R.string.no_internet), Toast.LENGTH_SHORT).show();

        }
    }

    private void setStatusBarColor(int color) {
        // Set the color of the status bar dynamically
        Window window = getActivity().getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    private void setStatusBarIconColor(boolean isDark) {
        // Set the icon color of the status bar dynamically
        Window window = getActivity().getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decorView = window.getDecorView();
            int flags = decorView.getSystemUiVisibility();
            if (isDark) {
                // Set icon color to black
                flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            } else {
                // Set icon color to white
                flags &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            decorView.setSystemUiVisibility(flags);
        }
    }
}