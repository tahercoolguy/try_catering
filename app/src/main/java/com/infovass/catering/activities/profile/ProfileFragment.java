package com.infovass.catering.activities.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.infovass.catering.R;
import com.infovass.catering.activities.ChangeLanguageActivity;
import com.infovass.catering.activities.login.view.LoginActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.order.OrderListActivity;
import com.infovass.catering.activities.profile.view.MyAccountDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends Fragment {

    View view;
    @BindView(R.id.tv_userName)
    AppCompatTextView tv_userName;
    @BindView(R.id.rel_profile)
    RelativeLayout rel_profile;
    @BindView(R.id.rel_order)
    RelativeLayout rel_order;
    @BindView(R.id.rel_termCondition)
    RelativeLayout rel_termCondition;
    @BindView(R.id.rel_changeLanguage)
    RelativeLayout rel_changeLanguage;
    @BindView(R.id.rel_privacyPolicy)
    RelativeLayout rel_privacyPolicy;
    @BindView(R.id.logOut)
    RelativeLayout logOut;
    @BindView(R.id.logIn)
    RelativeLayout logIn;


    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.rel_privacyPolicy, R.id.rel_profile, R.id.rel_order, R.id.rel_termCondition, R.id.rel_changeLanguage, R.id.logOut, R.id.logIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.rel_privacyPolicy:
                try {
                    Intent intent = new Intent(getActivity(), PrivacyPolicyActivity.class);
                    startActivity(intent);
                } catch (Exception g) {
                }
                break;

            case R.id.rel_changeLanguage:
                try {
                    Intent intent = new Intent(getActivity(), ChangeLanguageActivity.class);
                    startActivity(intent);
                } catch (Exception g) {
                }
                break;

            case R.id.rel_profile:
                try {
                    Intent intent = new Intent(getActivity(), MyAccountDetailActivity.class);
                    startActivity(intent);
                } catch (Exception g) {
                }
                break;

            case R.id.rel_order:
                try {
                    Intent intent = new Intent(getActivity(), OrderListActivity.class);
                    startActivity(intent);
                } catch (Exception g) {
                }
                break;

            case R.id.rel_termCondition:
                try {
                    Intent intent = new Intent(getActivity(), TermConditionActivity.class);
                    startActivity(intent);
                } catch (Exception g) {
                }
                break;

            case R.id.logOut:
                try {
                    SharedPreferencesUtils.getInstance(getActivity()).setValue(Constants.TOKEN, "null");
                    SharedPreferencesUtils.getInstance(getActivity()).setValue(Constants.UserName, "null");
                    SharedPreferencesUtils.getInstance(getActivity()).setValue(Constants.UserID, "null");
                    SharedPreferencesUtils.getInstance(getActivity()).setValue(Constants.KEY_AREA_NAME, "");
                    SharedPreferencesUtils.getInstance(getActivity()).setValue(Constants.KEY_TIME, "");
                    SharedPreferencesUtils.getInstance(getActivity()).setValue(Constants.KEY_DATE, "");
                    SharedPreferencesUtils.getInstance(getActivity()).setValue(Constants.KEY_LOGGED_IN, false);
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } catch (Exception g) {
                }
                break;

            case R.id.logIn:
                try {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                } catch (Exception g) {
                }
                break;


        }
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

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);

        tv_userName.setText(SharedPreferencesUtils.getInstance(getActivity()).getValue(Constants.UserName, ""));

        if((SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_LOGGED_IN, false))){
            logOut.setVisibility(View.VISIBLE);
            logIn.setVisibility(View.GONE);
        } else {
            logOut.setVisibility(View.GONE);
            logIn.setVisibility(View.VISIBLE);
        }


//        addressAdapter = new AddressAdapter(getContext());
//        savedAddressListView.setLayoutManager(new LinearLayoutManager(getContext()));
//        savedAddressListView.hasFixedSize();
//        savedAddressListView.setAdapter(addressAdapter);
//        addressAdapter.setOnItemClickListener(new AddressAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position, TextView custom_tab_textView, LinearLayout detail_item_linearLayout) {
//
//            }
//        });
        return view;
    }

}