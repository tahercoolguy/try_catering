package com.infovass.catering.activities.fav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.infovass.catering.R;
import com.infovass.catering.activities.adapers.FavAdapter;
import com.infovass.catering.activities.fav.model.FavListResponse;
import com.infovass.catering.activities.fav.presenter.FavImpl;
import com.infovass.catering.activities.fav.presenter.FavPresenter;
import com.infovass.catering.activities.fav.view.FavViews;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavFragment extends Fragment implements FavViews {

    List<FavListResponse.Datum> list = new ArrayList<>();
    FavPresenter favPresenter;
    View view;
    @BindView(R.id.favListView)
    RecyclerView favListView;
    FavAdapter favAdapter;

    public FavFragment() {
        // Required empty public constructor
    }

    public static FavFragment newInstance() {
        FavFragment fragment = new FavFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fav, container, false);
        ButterKnife.bind(this, view);
        favPresenter = new FavImpl(this);
        favPresenter.getFevListApi(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.TOKEN, ""));
        favAdapter = new FavAdapter(getContext() , list);
        favListView.setLayoutManager(new LinearLayoutManager(getContext()));
        favListView.setAdapter(favAdapter);
        favAdapter.setOnItemClickListener(new FavAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView custom_tab_textView, LinearLayout detail_item_linearLayout) {

            }
        });
        return view;
    }

    @Override
    public void onSuccessGetFavListAPi(FavListResponse favListResponse) {
        try {
            if (favListResponse.getStatus()) {
                list.clear();
                if (favListResponse.getData().size() == 0) {
//                lnr_noProduct.setVisibility(View.VISIBLE);
//                lnr_main.setVisibility(View.GONE);
                } else {
//                lnr_noProduct.setVisibility(View.GONE);
//                lnr_main.setVisibility(View.VISIBLE);
                    try{
                        list.addAll(favListResponse.getData());
                        favAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }else
            {
                Toast.makeText(getContext(), ""+favListResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }catch (Exception ignore){}
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
}