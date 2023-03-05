package com.infovass.catering.activities.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.infovass.catering.DM.PrivacyPolicyRoot;
import com.infovass.catering.MyFormat.Controller.AppController;
import com.infovass.catering.MyFormat.MyDM.Root;
import com.infovass.catering.MyFormat.Utils.ConnectionDetector;
import com.infovass.catering.R;
import com.infovass.catering.activities.home.view.RestaurentDetailNew;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.profile.model.PagesResponse;
import com.infovass.catering.activities.profile.model.ProfileResponse;
import com.infovass.catering.activities.profile.presenter.ProfileImpl;
import com.infovass.catering.activities.profile.presenter.ProfilePresenter;
import com.infovass.catering.activities.profile.view.ProfileViews;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PrivacyPolicyActivity extends AppCompatActivity implements ProfileViews {

    private AppController appController;
    private Dialog progress;
    private ConnectionDetector connectionDetector;

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
    public void onSuccessGetProfileAPi(ProfileResponse profileResponse) {

    }

    @Override
    public void onSuccessPagesAPi(PagesResponse pagesResponse) {



    }

    ProfilePresenter presenter;
    @BindView(R.id.backButton)
    ImageButton backButton;
    @BindView(R.id.tv_termAndCondition)
    AppCompatTextView tv_termAndCondition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        ButterKnife.bind(this);
        appController = (AppController) this.getApplicationContext();
        connectionDetector = new ConnectionDetector(getApplicationContext());
//        presenter = new ProfileImpl(this);
//        presenter.GetTermAndConditionApi();
        privacyPolicyAPI();

    }



    public void privacyPolicyAPI() {
        if (connectionDetector.isConnectingToInternet()) {

            appController.paServices.PrivacyPolicyAPI(new Callback<PrivacyPolicyRoot>() {
                @Override
                public void success(PrivacyPolicyRoot privacyPolicyRoot, Response response) {

                    try {
                        if(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
                        {
                            tv_termAndCondition.setText(Html.fromHtml(""+privacyPolicyRoot.getData().getContent_arabic()));
                        }
                        if(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.Language, "").equalsIgnoreCase("en"))
                        {
                            tv_termAndCondition.setText(Html.fromHtml(""+privacyPolicyRoot.getData().getContent()));
                        }

                    }catch (Exception j){
                        j.printStackTrace();
                    }




                }

                @Override
                public void failure(RetrofitError error) {

                    error.printStackTrace();
                }
            });

        } else {
            Toast.makeText(PrivacyPolicyActivity.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();

        }
    }



    @OnClick({R.id.backButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButton:
                try {
                    finish();
                } catch (Exception g) {
                }
                break;
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