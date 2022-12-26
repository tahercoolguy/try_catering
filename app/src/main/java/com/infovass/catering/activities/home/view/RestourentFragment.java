package com.infovass.catering.activities.home.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infovass.catering.R;
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

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestourentFragment extends Fragment implements RestourentView {

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
        progressHUD = ProgressHUD.create(getContext(), getString(R.string.loading), false, null, null);
        restourentPresenter = new RestourentImpl(this);
 //       restourentPresenter.getRestourentlistApi("", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

        restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));


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
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id , position);
                }
                if (position == 1) {
                    restourentPresenter.getRestourentlistApi("1", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id , position);
                }
                if (position == 2) {
                    restourentPresenter.getRestourentlistApi("2", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id , position);
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
            public void onItemClick(int position) {
                SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(position).getId());
                int restaurententID=restourentLIst.get(position).getId();
                Intent intent = new Intent(getContext(), RestourentDetailActivity.class).putExtra("restaurententID",restaurententID);
                startActivity(intent);
            }
        });
        return view;
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
        resturantListView.setVisibility(View.GONE);
    }

    @Override
    public void onNoInternet() {

    }
}