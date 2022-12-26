package com.infovass.catering.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.infovass.catering.R;
import com.infovass.catering.activities.Location.view.LocationActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.AppSettings;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final int SPLASH_SLEEP_TIME = 2000;
        String lan = SharedPreferencesUtils.getInstance(this).getValue(Constants.Language,"");

        if(lan.equalsIgnoreCase("ar"))
        {
            SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.Language, "ar");
            Log.i("yuy" ,"One"+lan);
            setLanguageResource("ar");
            new AppSettings().setAppLanguage(this, "ar");
        }
        else if(lan.equalsIgnoreCase("en"))
        {
            SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.Language, "en");
            Log.i("yuy" ,"TWO"+lan);
            setLanguageResource("en");
            new AppSettings().setAppLanguage(this, "en");
        }else
        {
            Log.i("yuy" ,"Three"+lan);
            SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.Language, "en");
            setLanguageResource("en");
            new AppSettings().setAppLanguage(this, "en");
        }

        new Thread() {
            public void run() {
                try {
                    sleep(SPLASH_SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.getMessage();
                } finally {
                    Intent intent = new Intent(SplashActivity.this, LocationActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        }.start();
    }

    private void setLanguageResource(String language_code) {
        Resources res = getResources();
        // Change locale main_settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = new Locale(language_code.toLowerCase());
        res.updateConfiguration(conf, dm);
    }

}