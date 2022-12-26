package com.infovass.catering.activities.network;

import android.app.Application;
import android.content.res.Configuration;

import androidx.appcompat.app.AppCompatDelegate;


/**
 * Main application class to handle whole app activity life methods.
 */

public class IDApplication extends Application {
    private static IDApplication currentApplication = null;


    // region Lifecycle Methods
    @Override
    public void onCreate() {
        super.onCreate();
        currentApplication = this;


    }

    public static IDApplication getInstance() {
        return currentApplication;
    }


    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        LocaleHelper.setLocale(this, SharedPreferencesUtils.getInstance(this).getValue(Constants.KEY_LANGUAGE, ""));
    }


}
