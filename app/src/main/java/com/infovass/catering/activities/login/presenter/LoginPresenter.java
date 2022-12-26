package com.infovass.catering.activities.login.presenter;

public interface LoginPresenter {
    void callForgotPasswordApi(String email);
    void callLoginApi(String email , String password);
    void callSignUpApi(String name , String email , String phone, String password , String confirm_password , String device_token , String device_type);
}
