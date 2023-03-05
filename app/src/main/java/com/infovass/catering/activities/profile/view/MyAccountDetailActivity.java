package com.infovass.catering.activities.profile.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatEditText;

import com.infovass.catering.R;
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.profile.AddressActivity;
import com.infovass.catering.activities.profile.model.PagesResponse;
import com.infovass.catering.activities.profile.model.ProfileResponse;
import com.infovass.catering.activities.profile.presenter.ProfileImpl;
import com.infovass.catering.activities.profile.presenter.ProfilePresenter;
import com.infovass.catering.activities.utill.ProgressHUD;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyAccountDetailActivity extends BaseActivity implements ProfileViews {

    private ProgressHUD progressHUD;
    ProfilePresenter presenter;
    @BindView(R.id.userNameEditText)
    AppCompatEditText userNameEditText;
    @BindView(R.id.userPhoneNo)
    AppCompatEditText userPhoneNo;
    @BindView(R.id.userEmail)
    AppCompatEditText userEmail;
    @BindView(R.id.rel_address)
    RelativeLayout rel_address;
    @BindView(R.id.backImg)
    ImageView backImg;


    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_detail);
        ButterKnife.bind(this);

        progressHUD = ProgressHUD.create(this, getString(R.string.loading), false, null, null);
        presenter = new ProfileImpl(this);
        presenter.GetUserProfileApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.UserID, ""));
    }


    @OnClick(R.id.backImg)
    public void clickBack(){
        finish();
    }

    @OnClick({R.id.rel_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_address:
                try {
                    SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.ClassName, "address");
                    Intent intent = new Intent(MyAccountDetailActivity.this, AddressActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                } catch (Exception g) {
                }
                break;
        }
    }


    @Override
    public void onSuccessGetProfileAPi(ProfileResponse profileResponse) {
        try {
            Log.i("RESPONSEEEE", "" + profileResponse.getResult().get(0).getName());
            userNameEditText.setText("" + profileResponse.getResult().get(0).getName());
            userPhoneNo.setText("" + profileResponse.getResult().get(0).getPhone());
            userEmail.setText("" + profileResponse.getResult().get(0).getEmail());
        } catch (Exception h) {
            Log.i("ERROOR", h.getMessage());
        }

    }

    @Override
    public void onSuccessPagesAPi(PagesResponse pagesResponse) {

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
        overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_in);
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
        super.onBackPressed();
    }

}