package com.infovass.catering.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.infovass.catering.DeepLinking.DynamicLinkHelper;
import com.infovass.catering.R;
import com.infovass.catering.activities.Location.view.LocationActivity;
import com.infovass.catering.activities.home.view.CateringServiceDetailActivity;
import com.infovass.catering.activities.home.view.ProductDetailActivity;
import com.infovass.catering.activities.home.view.RestaurentDetailNew;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.AppSettings;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {
    private DynamicLinkHelper dynamicLinkHelper;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final int SPLASH_SLEEP_TIME = 2000;
        String lan = SharedPreferencesUtils.getInstance(this).getValue(Constants.Language, "");
        activity = SplashActivity.this;
        dynamicLinkHelper = new DynamicLinkHelper(this, activity);
        if (lan.equalsIgnoreCase("ar")) {
            SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.Language, "ar");
            Log.i("yuy", "One" + lan);
            setLanguageResource("ar");
            new AppSettings().setAppLanguage(this, "ar");
        } else if (lan.equalsIgnoreCase("en")) {
            SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.Language, "en");
            Log.i("yuy", "TWO" + lan);
            setLanguageResource("en");
            new AppSettings().setAppLanguage(this, "en");
        } else {
            Log.i("yuy", "Three" + lan);
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

                    if (getIntent() == null) {
                        Intent intent = new Intent(SplashActivity.this, LocationActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                        finish();
                    } else {
                        dynamicLinkHelper.getDynamicLinkFromFirebase();
                    }

                }
            }

        }.start();
    }

    //    private void setLanguageResource(String language_code) {
//        Resources res = getResources();
//        // Change locale main_settings in the app.
//        DisplayMetrics dm = res.getDisplayMetrics();
//        Configuration conf = res.getConfiguration();
//        conf.locale = new Locale(language_code.toLowerCase());
//        res.updateConfiguration(conf, dm);
//    }
    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
        super.onBackPressed();
    }

    public void setLanguageResource(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration configuration = getResources().getConfiguration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    public void handleDynamicLinkData(String id, String type, String restaurant_Status, String min_time) {
        if (type.equalsIgnoreCase("menu")) {
            Intent intent = new Intent(SplashActivity.this, RestaurentDetailNew.class);
            intent.putExtra("restaurententID", id);
            intent.putExtra("restaurant_Status", restaurant_Status);
            intent.putExtra("deep_linking_back", "true");
            startActivity(intent);
            overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

            finish();
        } else if (type.equalsIgnoreCase("catering_detail")) {
            Intent intent = new Intent(SplashActivity.this, CateringServiceDetailActivity.class);
            intent.putExtra("status", restaurant_Status);
            intent.putExtra("min_time", min_time);
            intent.putExtra("deep_linking_back", "true");
            startActivity(intent);
            overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

            finish();

        } else if (type.equalsIgnoreCase("product_detail")) {
            Intent intent = new Intent(SplashActivity.this, ProductDetailActivity.class);
            intent.putExtra("status", restaurant_Status);
            intent.putExtra("min_time", min_time);
            intent.putExtra("deep_linking_back", "true");
            startActivity(intent);
            overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

            finish();

        }
    }
}