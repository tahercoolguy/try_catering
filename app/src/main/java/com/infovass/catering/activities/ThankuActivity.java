package com.infovass.catering.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.infovass.catering.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThankuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanku);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_cross})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_cross:
                try {
//                    Intent intent = new Intent(ThankuActivity.this  , MainActivity.class);
//                    startActivity(intent);
                    ThankuActivity.this.finish();
                }catch (Exception g) {}
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
//            Intent intent = new Intent(ThankuActivity.this  , MainActivity.class);
//            startActivity(intent);
            ThankuActivity.this.finish();
        }catch (Exception g) {}
    }
}