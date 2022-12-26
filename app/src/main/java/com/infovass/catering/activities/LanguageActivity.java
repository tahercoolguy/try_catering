package com.infovass.catering.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.infovass.catering.R;

public class LanguageActivity extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(LanguageActivity.this, MainADActivity.class);
        switch (v.getId()) {
            case R.id.btn_lang_arabic:
//                setLanguageResource("ar");
//                new AppSettings().setAppLanguage(this, "ar");
//                startActivity(intent);
//                finish();
                break;
            case R.id.btn_lang_english:
                //setLanguageResource("en");
                //new AppSettings().setAppLanguage(this, "en");
                startActivity(intent);
                finish();
                break;

            default:
        }
    }
}