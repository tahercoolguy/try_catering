package com.infovass.catering.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;

import com.infovass.catering.R;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.AppSettings;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeLanguageActivity extends AppCompatActivity {

    @BindView(R.id.backButton)
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);
        ButterKnife.bind(this);
    }

    public static void setLanguageLocale(Context context, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config,
                context.getResources().getDisplayMetrics());
    }

    private void setLanguageResource(String language_code) {
        Resources res = getResources();
        // Change locale main_settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = new Locale(language_code.toLowerCase());
        res.updateConfiguration(conf, dm);
    }


    @OnClick({R.id.btn_lang_arabic, R.id.btn_lang_english, R.id.backButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.backButton:
                try {
                    finish();
                } catch (Exception g) {
                }
                break;

            case R.id.btn_lang_arabic:
                try {
                    SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.Language, "ar");
                    Intent intent = new Intent(ChangeLanguageActivity.this, SplashActivity.class);
                    setLanguageResource("ar");
                    new AppSettings().setAppLanguage(this, "ar");
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                    finish();
                } catch (Exception g) {
                }
                break;

            case R.id.btn_lang_english:
                try {
                    SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.Language, "en");
                    Intent intent = new Intent(ChangeLanguageActivity.this, SplashActivity.class);
                    setLanguageResource("en");
                    new AppSettings().setAppLanguage(this, "en");
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                    finish();
                } catch (Exception g) {
                }
                break;

        }
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