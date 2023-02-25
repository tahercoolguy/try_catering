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