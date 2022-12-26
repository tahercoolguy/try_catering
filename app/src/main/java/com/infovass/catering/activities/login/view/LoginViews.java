package com.infovass.catering.activities.login.view;

import com.infovass.catering.activities.login.model.ForGotPasswordResponse;
import com.infovass.catering.activities.login.model.LoginResponse;
import com.infovass.catering.activities.login.model.SignUPResponse;
import com.infovass.catering.activities.network.Loading;

public interface LoginViews extends Loading {
    void onSuccessForgotpasswordPi(ForGotPasswordResponse forGotPasswordResponse);
    void onSuccessLoginAPi(LoginResponse loginResponse);
    void onSuccessSignUpAPi(SignUPResponse signUPResponse);
}
