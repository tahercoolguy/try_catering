package com.infovass.catering.activities.network;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.infovass.catering.activities.login.view.LoginActivity;

public class SharedPreferencesUtils {
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public static SharedPreferencesUtils getInstance(Context activity) {
        if (preferences == null)
            preferences = activity.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferencesUtils utils = new SharedPreferencesUtils();
        return utils;
    }

    public void setValue(String key, String value) {
        editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void setValue(String key, boolean value) {
        editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void setValue(String key, int value) {
        editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public String getValue(String key, String value) {
        return preferences.getString(key, "");

    }

    public boolean getValue(String key, boolean value) {
        return preferences.getBoolean(key, value);
    }

    public int getValue(String key, int value) {
        return preferences.getInt(key, 0);
    }


    public void clearAllLogin(Activity activity) {
        String lang = SharedPreferencesUtils.getInstance(activity).getValue(Constants.KEY_LOGIN_LANGUAGE, Constants.ENGLISH);
        editor = preferences.edit();
        editor.clear();
        editor.apply();

        SharedPreferencesUtils.getInstance(activity).setValue(Constants.KEY_LANGUAGE, lang);
        SharedPreferencesUtils.getInstance(activity).setValue(Constants.KEY_LOGIN_LANGUAGE, lang);

//        LocaleHelper.setLocale(activity, lang);

        Intent i1 = new Intent(activity, LoginActivity.class);
        i1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i1);
        activity.finish();
    }

    public void clearAll(Activity activity) {
        editor = preferences.edit();
        editor.clear();
        editor.apply();

        Intent i1 = new Intent(activity, LoginActivity.class);
        i1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i1);
    }


}

