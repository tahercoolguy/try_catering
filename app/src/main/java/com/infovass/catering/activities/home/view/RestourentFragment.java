package com.infovass.catering.activities.home.view;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infovass.catering.R;
import com.infovass.catering.activities.CalenderActivity;
import com.infovass.catering.activities.Location.view.LocationActivity;
import com.infovass.catering.activities.Location.view.TimeActivity;
import com.infovass.catering.activities.MainActivity;
import com.infovass.catering.activities.adapers.RestourentcategoriesAdapter;
import com.infovass.catering.activities.adapers.ResturantLargeAdapter;
import com.infovass.catering.activities.home.model.RestourentListResponse;
import com.infovass.catering.activities.home.presenter.RestourentImpl;
import com.infovass.catering.activities.home.presenter.RestourentPresenter;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.ProgressHUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RestourentFragment extends Fragment implements RestourentView {
    private final static int LOCATION_REQUEST_CODE = 1;
    private final static int DATE_REQUEST_CODE = 2;
    private final static int TIME_REQUEST_CODE = 3;

    List<RestourentListResponse.Datum> restourentLIst = new ArrayList<>();
    private ProgressHUD progressHUD;
    RestourentPresenter restourentPresenter;
    View view;
    RestourentcategoriesAdapter restourentcategoriesAdapter;
    ResturantLargeAdapter resturantLargeAdapter;
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

    Activity activity;

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


        tv_city.setSelected(true);
        tv_date.setSelected(true);
        tv_time.setSelected(true);
        searchLL.setVisibility(View.GONE);
        framelayout.setVisibility(View.VISIBLE);
        progressHUD = ProgressHUD.create(getContext(), getString(R.string.loading), false, null, null);
        restourentPresenter = new RestourentImpl(this);
               restourentPresenter.getRestourentlistApi("", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

//        restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));


        tv_city.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_NAME, ""));
        tv_time.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_TIME, ""));
        tv_date.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

        List<String> list = new ArrayList<>();
        list.add(getResources().getString(R.string.all));
        list.add(getResources().getString(R.string.catering));
        list.add(getResources().getString(R.string.delivery));

        restourentcategoriesAdapter = new RestourentcategoriesAdapter(list, getContext());
        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);
        detail_recyclerView.setLayoutManager(HorizontalLayout);
        detail_recyclerView.setAdapter(restourentcategoriesAdapter);
        restourentcategoriesAdapter.setOnItemClickListener(new RestourentcategoriesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView custom_tab_textView, LinearLayout detail_item_linearLayout) {
                restourentcategoriesAdapter.notifyDataSetChanged();
                if (position == 0) {
                    restourentPresenter.getRestourentlistApi("", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
                }
                if (position == 1) {
                    restourentPresenter.getRestourentlistApi("1", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
                }
                if (position == 2) {
                    restourentPresenter.getRestourentlistApi("2", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
                }
//                if (position==3)
//                {
//                    restourentPresenter.getRestourentlistApi("3",SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""));
//                }
            }
        });

        resturantLargeAdapter = new ResturantLargeAdapter(getContext(), restourentLIst);
        resturantListView.setLayoutManager(new LinearLayoutManager(getContext()));
        resturantListView.setAdapter(resturantLargeAdapter);
        resturantLargeAdapter.setOnItemClickListener(new ResturantLargeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position,int selectedposition, int Restaurant_Status,List<RestourentListResponse.Datum> restourentLIst) {
                SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(position).getId());
                int restaurententID = restourentLIst.get(position).getId();
                String restaurant_Status = String.valueOf(Restaurant_Status);
                Intent intent = new Intent(getContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
                        .putExtra("restaurant_Status", restaurant_Status);
                startActivity(intent);
                activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

            }
        });
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
        startActivityForResult(intent,RESULT_OK);
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
        try {
            restourentLIst.clear();
            if (restourentListResponse.getData().size() == 0) {
//                lnr_noProduct.setVisibility(View.VISIBLE);
                resturantListView.setVisibility(View.GONE);

//                restourentLIst = new ArrayList<>();
//                resturantLargeAdapter.notifyDataSetChanged();
            } else {
//                lnr_noProduct.setVisibility(View.GONE);
                resturantListView.setVisibility(View.VISIBLE);
                restourentLIst.addAll(restourentListResponse.getData());
                resturantLargeAdapter.notifyDataSetChanged();
            }

        } catch (Exception ignore) {
            restourentLIst = new ArrayList<>();
            ignore.printStackTrace();
            resturantLargeAdapter.notifyDataSetChanged();

        }
    }

    String newtime, newdate, newlocation;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == LOCATION_REQUEST_CODE) {
            if (data != null) {
                  newlocation = data.getStringExtra("newlocationArea");
                if(newlocation!=null){
                    tv_city.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_NAME, ""));
                    tv_city.setText(newlocation);
                    restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                }



            }
        }
        if (requestCode == DATE_REQUEST_CODE) {
            if (data != null) {
                String newdate = data.getStringExtra("newdate");
                tv_date.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
            }
        }
        if (requestCode == TIME_REQUEST_CODE) {
            if (data != null) {
                String newtime = data.getStringExtra("newtime");
                String newtimes = data.getStringExtra("newtime");
                tv_time.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_TIME, ""));
                restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

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
}