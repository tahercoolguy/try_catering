package com.infovass.catering.activities.login.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;

import com.infovass.catering.R;
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.login.model.ForGotPasswordResponse;
import com.infovass.catering.activities.login.model.LoginResponse;
import com.infovass.catering.activities.login.model.SignUPResponse;
import com.infovass.catering.activities.login.presenter.LoginImpl;
import com.infovass.catering.activities.login.presenter.LoginPresenter;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.InputValidations;
import com.infovass.catering.activities.utill.ProgressHUD;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordActivity extends BaseActivity implements LoginViews {

    String mUserEmail;
    private ProgressHUD progressHUD;
    LoginPresenter presenter;
    @BindView(R.id.firstNameET)
    EditText firstNameET;
    @BindView(R.id.signUpB)
    Button signUpB;
    @BindView(R.id.tv_back)
    TextView tv_back;
    String lan;

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        progressHUD = ProgressHUD.create(this, getString(R.string.loading), false, null, null);
        presenter = new LoginImpl(this);
        lan = SharedPreferencesUtils.getInstance(this).getValue(Constants.Language, "");
    }

    @OnClick({R.id.signUpB, R.id.tv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signUpB:
                try {
                    callLoginAPI();
                } catch (Exception g) {
                }
                break;

            case R.id.tv_back:
                try {
                    finish();
                } catch (Exception g) {
                }
                break;

        }
    }

    private void callLoginAPI() {
        if (isNetAvail()) {
//            Log.i("Yhan", "HAN");
            if (isValid()) {
                try {
                    presenter.callForgotPasswordApi(mUserEmail);
                } catch (Exception j) {
                }
            }
        }
    }

    private boolean isValid() {
        boolean error = true;
        mUserEmail = Objects.requireNonNull(firstNameET.getText()).toString().trim();

        if (InputValidations.isNullOrEmpty(mUserEmail)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(ForgotPasswordActivity.this, R.anim.shake);
            firstNameET.startAnimation(shake);
            firstNameET.setError(getString(R.string.valid_email_address));
            firstNameET.setFocusable(true);
            firstNameET.requestFocus();
        } else if (!InputValidations.isEmailValid(mUserEmail)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(ForgotPasswordActivity.this, R.anim.shake);
            firstNameET.startAnimation(shake);
            firstNameET.setError(getString(R.string.valid_email_address));
            firstNameET.setFocusable(true);
            firstNameET.requestFocus();
        }

        return error;
    }

    @Override
    public void onSuccessForgotpasswordPi(ForGotPasswordResponse forGotPasswordResponse) {
        try {
            if (forGotPasswordResponse.getStatus()) {
                if (lan.equals("ar")) {
                    Toast.makeText(getActivityContext(), "لقد أرسلنا رمز إلى بريدك الإلكتروني  من فضلك تفقده و قم بالتأكيد", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivityContext(), forGotPasswordResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }

//                Intent intent = new Intent(getActivityContext(), LoginActivity.class);
//                startActivity(intent);
                Intent i = new Intent(ForgotPasswordActivity.this,
                        LoginActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            } else {
                Toast.makeText(getActivityContext(), forGotPasswordResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

        } catch (Exception h) {
        }
    }

    @Override
    public void onSuccessLoginAPi(LoginResponse loginResponse) {

    }

    @Override
    public void onSuccessSignUpAPi(SignUPResponse signUPResponse) {

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

    }

    @Override
    public void onNoInternet() {

    }
}