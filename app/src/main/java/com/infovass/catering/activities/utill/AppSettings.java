package com.infovass.catering.activities.utill;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dell on 25/02/2017.
 */

public class AppSettings {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public void setIsRegistered(Context context, boolean isRegistered) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean("isRegistered", isRegistered);
        editor.commit();
    }

    public boolean getIsRegistered(Context context) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isRegistered", false);
    }


    public void setIsFirstLogin(Context context, boolean isFirstTime) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean("isFirstTime", isFirstTime);
        editor.commit();
    }

    public boolean getIsFirstLogin(Context context) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isFirstTime", true);
    }

    public void setAppLanguage(Context context, String language) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("language", language);
        editor.commit();
    }

    public String getAppLanguage(Context context) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        return sharedPreferences.getString("language", "");
    }

    public void setUserName(Context context, String name) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("userName", name);
        editor.commit();
    }

    public String getUserEmail(Context context) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        return sharedPreferences.getString("userEmail", "");
    }

    public void setUserEmail(Context context, String userEmail) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("userEmail", userEmail);
        editor.commit();
    }

    public String getUserName(Context context) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        return sharedPreferences.getString("userName", "");
    }



    public void setUserMobile(Context context, String mobile) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("mobile", mobile);
        editor.commit();
    }

    public String getUserMobile(Context context) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        return sharedPreferences.getString("mobile", "");
    }


    public void setUserId(Context context, String id) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("ID", id);
        editor.commit();
    }

    public String getUserId(Context context) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        return sharedPreferences.getString("ID", null);
    }



    public void setUserAddress(Context context, String address) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("userAddress", address);
        editor.commit();
    }

    public String getUserAddress(Context context) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        return sharedPreferences.getString("userAddress", "");
    }

    public void setOrderActivation(Context context, String code) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("orderActivation", code);
        editor.commit();
    }

    public String getOrderActivation(Context context) {
        sharedPreferences = context.getSharedPreferences("com.infovass.catering", MODE_PRIVATE);
        return sharedPreferences.getString("orderActivation", "");
    }



}
