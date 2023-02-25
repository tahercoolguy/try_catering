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
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.login.model.ForGotPasswordResponse;
import com.infovass.catering.activities.login.model.LoginResponse;
import com.infovass.catering.activities.login.model.SignUPResponse;
import com.infovass.catering.activities.login.presenter.LoginImpl;
import com.infovass.catering.activities.login.presenter.LoginPresenter;
import com.infovass.catering.activities.profile.PrivacyPolicyActivity;
import com.infovass.catering.activities.profile.TermConditionActivity;
import com.infovass.catering.activities.utill.InputValidations;
import com.infovass.catering.activities.utill.ProgressHUD;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SigUpActivity extends BaseActivity implements LoginViews {

    private ProgressHUD progressHUD;
    LoginPresenter presenter;
    String mUserName , mUserPhone , mUserEmail , mUserPassword , mUserConPassword;
    @BindView(R.id.userNameEditText)
    AppCompatEditText userNameEditText;
    @BindView(R.id.edt_phone)
    AppCompatEditText edt_phone;
    @BindView(R.id.edt_email)
    AppCompatEditText edt_email;
    @BindView(R.id.edt_password)
    AppCompatEditText edt_password;
    @BindView(R.id.edt_conPassword)
    AppCompatEditText edt_conPassword;
    @BindView(R.id.tv_termAndCondition)
    AppCompatTextView tv_termAndCondition;
    @BindView(R.id.tv_privacyPolicy)
    AppCompatTextView tv_privacyPolicy;

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_up);
        ButterKnife.bind(this);
        progressHUD = ProgressHUD.create(this, getString(R.string.loading), false, null, null);
        presenter = new LoginImpl(this);
    }

    @OnClick({R.id.signUpButton ,R.id.tv_termAndCondition ,R.id.tv_privacyPolicy})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tv_privacyPolicy:
                Intent intentt = new Intent(SigUpActivity.this , PrivacyPolicyActivity.class);
                startActivity(intentt);        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);


                break;

            case R.id.tv_termAndCondition:
            Intent intent = new Intent(SigUpActivity.this , TermConditionActivity.class);
            startActivity(intent);
                overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                break;

            case R.id.signUpButton:
                try {
                    callSignUpAPI();
                } catch (Exception g) {
                }
//            Intent intent = new Intent(SigUpActivity.this , VarificationActivity.class);
//            startActivity(intent);
            break;
        }
    }

    private void callSignUpAPI() {
//        if (isNetAvail()) {
//            Log.i("Yhan", "HAN");
        if (isValid()) {
            try {
                @SuppressLint("HardwareIds") String android_id = Settings.Secure.getString(getActivityContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);
                Log.i("IMEINumber", android_id);
                presenter.callSignUpApi(mUserName, mUserEmail,mUserPhone,mUserPassword,mUserConPassword,android_id,"Android");
            } catch (Exception j) {
            }
        }
        // }
    }

    private boolean isValid() {
        boolean error = true;
        mUserName = Objects.requireNonNull(userNameEditText.getText()).toString().trim();
        mUserPhone = Objects.requireNonNull(edt_phone.getText()).toString().trim();
        mUserEmail = Objects.requireNonNull(edt_email.getText()).toString().trim();
        mUserPassword = Objects.requireNonNull(edt_password.getText()).toString().trim();
        mUserConPassword = Objects.requireNonNull(edt_conPassword.getText()).toString().trim();

        if (InputValidations.isNullOrEmpty(mUserName)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(SigUpActivity.this, R.anim.shake);
            userNameEditText.startAnimation(shake);
            userNameEditText.setError(getString(R.string.valid_name));
            userNameEditText.setFocusable(true);
            userNameEditText.requestFocus();
        }
        else if (InputValidations.isNullOrEmpty(mUserPhone)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(SigUpActivity.this, R.anim.shake);
            edt_phone.startAnimation(shake);
            edt_phone.setError(getString(R.string.valid_phone));
            edt_phone.setFocusable(true);
            edt_phone.requestFocus();
        }else if (InputValidations.isNullOrEmpty(mUserEmail)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(SigUpActivity.this, R.anim.shake);
            edt_email.startAnimation(shake);
            edt_email.setError(getString(R.string.valid_email_address));
            edt_email.setFocusable(true);
            edt_email.requestFocus();
        }
        else if (!InputValidations.isEmailValid(mUserEmail)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(SigUpActivity.this, R.anim.shake);
            edt_email.startAnimation(shake);
            edt_email.setError(getString(R.string.valid_email_address));
            edt_email.setFocusable(true);
            edt_email.requestFocus();
        }
        else if (InputValidations.isNullOrEmpty(mUserPassword)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(SigUpActivity.this, R.anim.shake);
            edt_password.startAnimation(shake);
            edt_password.setError(getString(R.string.valid_password));
            edt_password.setFocusable(true);
            edt_password.requestFocus();
        }
        else if (InputValidations.isNullOrEmpty(mUserConPassword)) {
            error = false;
            Animation shake = AnimationUtils.loadAnimation(SigUpActivity.this, R.anim.shake);
            edt_conPassword.startAnimation(shake);
            edt_conPassword.setError(getString(R.string.valid_password));
            edt_conPassword.setFocusable(true);
            edt_conPassword.requestFocus();
        }
        return error;
    }

    @Override
    public void onSuccessForgotpasswordPi(ForGotPasswordResponse forGotPasswordResponse) {

    }

    @Override
    public void onSuccessLoginAPi(LoginResponse loginResponse) {

    }

    @Override
    public void onSuccessSignUpAPi(SignUPResponse signUPResponse) {
        try
        {
            if(signUPResponse.getStatus().equalsIgnoreCase("true"))
            {
                Toast.makeText(SigUpActivity.this, signUPResponse.getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SigUpActivity.this , LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                finish();
            }
            else
            {
                Toast.makeText(SigUpActivity.this, signUPResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){}
    }

    @Override
    public void showLoading() {
        try {
            progressHUD.show();
        }catch (Exception f){}
    }

    @Override
    public void hideLoading() {
        try {
            progressHUD.dismiss();
        }catch (Exception f){}
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