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
                break;
        }
    }

}