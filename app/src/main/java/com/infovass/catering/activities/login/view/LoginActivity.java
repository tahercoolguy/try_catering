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
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.infovass.catering.R;
import com.infovass.catering.activities.Location.view.LocationActivity;
import com.infovass.catering.activities.MainActivity;
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

public class LoginActivity extends BaseActivity implements LoginViews {

    private ProgressHUD progressHUD;
    String mUserEmail, mUserpassword;
    LoginPresenter presenter;
    @BindView(R.id.tv_signUP)
    AppCompatTextView tv_signUP;

    @BindView(R.id.forgetPasswordTextView)
    AppCompatTextView forgetPasswordTextView;
    @BindView(R.id.userNameEditText)
    AppCompatEditText userNameEditText;
    @BindView(R.id.passwordEditText)
    AppCompatEditText passwordEditText;
    String lan;

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        progressHUD = ProgressHUD.create(this, getString(R.string.loading), false, null, null);
        presenter = new LoginImpl(this);
        lan = SharedPreferencesUtils.getInstance(this).getValue(Constants.Language, "");
    }

    @OnClick({R.id.tv_signUP, R.id.loginButton, R.id.forgetPasswordTextView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loginButton:
                try {
                    callLoginAPI();
                } catch (Exception g) {
                }
                break;

            case R.id.forgetPasswordTextView:
                try {
                    Intent intentt = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                    startActivity(intentt);
                } catch (Exception g) {
                }
                break;

            case R.id.tv_signUP:
                try {
                    Intent intent = new Intent(LoginActivity.this, SigUpActivity.class);
                    startActivity(intent);
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
                    @SuppressLint("HardwareIds") String android_id = Settings.Secure.getString(getActivityContext().getContentResolver(),
                            Settings.Secure.ANDROID_ID);
                    Log.i("IMEINumber", android_id);
                    presenter.callLoginApi(mUserEmail, mUserpassword);
                } catch (Exception j) {
                }
            }
        }
    }

    private boolean isValid() {
        boolean error = true;
        mUserEmail = Objects.requireNonNull(userNameEditText.getText()).toString().trim();
        mUserpassword = Objects.requireNonNull(passwordEditText.getText()).toString().trim();

        if (InputValidations.isNullOrEmpty(mUserEmail)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.shake);
            userNameEditText.startAnimation(shake);
            userNameEditText.setError(getString(R.string.valid_email_address));
            userNameEditText.setFocusable(true);
            userNameEditText.requestFocus();
        } else if (!InputValidations.isEmailValid(mUserEmail)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.shake);
            userNameEditText.startAnimation(shake);
            userNameEditText.setError(getString(R.string.valid_email_address));
            userNameEditText.setFocusable(true);
            userNameEditText.requestFocus();
        } else if (InputValidations.isNullOrEmpty(mUserpassword)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.shake);
            passwordEditText.startAnimation(shake);
            passwordEditText.setError(getString(R.string.valid_password));
            passwordEditText.setFocusable(true);
            passwordEditText.requestFocus();
        }

        return error;
    }

    @Override
    public void onSuccessForgotpasswordPi(ForGotPasswordResponse forGotPasswordResponse) {

    }

    @Override
    public void onSuccessLoginAPi(LoginResponse loginResponse) {
        try {
            if (loginResponse.getStatus()) {
                SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.TOKEN, "" + loginResponse.getToken());
                 SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.UserName, "" + loginResponse.getData().getName());
                SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.UserID, "" + loginResponse.getData().getId());
                SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.name, "" + loginResponse.getData().getName());
                SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.surname, "" + loginResponse.getData().getLastName());
                SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.phone, "" + loginResponse.getData().getPhone());
                SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.email, "" + loginResponse.getData().getEmail());

                SharedPreferencesUtils.getInstance(this).setValue(Constants.KEY_LOGGED_IN, true);
                Intent intent =  new Intent(LoginActivity.this , LocationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                finish();
            } else {
                if (lan.equals("ar")) {
                    Toast.makeText(getActivityContext(), loginResponse.getArabic_message(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivityContext(), loginResponse.getmessage(), Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(LoginActivity.this, loginResponse.getmessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
        }
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