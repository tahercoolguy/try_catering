package com.infovass.catering.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.infovass.catering.R;
import com.infovass.catering.activities.Location.view.LocationActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class VarificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varification);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.verifyButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.verifyButton:
                Intent intent = new Intent(VarificationActivity.this , LocationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

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