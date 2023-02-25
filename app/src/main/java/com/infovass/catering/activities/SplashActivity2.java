package com.infovass.catering.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.infovass.catering.R;
import com.infovass.catering.activities.login.view.LoginActivity;

public class SplashActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        final int SPLASH_SLEEP_TIME = 3000;

        new Thread() {
            public void run() {
                try {
                    sleep(SPLASH_SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.getMessage();
                } finally {
                    Intent intent = new Intent(SplashActivity2.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        }.start();
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