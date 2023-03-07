package com.infovass.catering.activities.Location.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

import com.infovass.catering.R;
import com.infovass.catering.activities.MainActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TimeActivity extends AppCompatActivity {

    @BindView(R.id.tv_cityName)
    AppCompatTextView tv_cityName;
    @BindView(R.id.tv_date)
    AppCompatTextView tv_date;
    @BindView(R.id.timePicker)
    TimePicker timePicker;
    String newtime;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        ButterKnife.bind(this);
        context=getApplicationContext();
        tv_cityName.setText(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_AREA_NAME, ""));
        tv_date.setText(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_DATE, ""));
        timePicker.is24HourView();
        UpdateTime();
    }


    public  void UpdateTime(){
        Intent intent= getIntent();
        if(intent!=null){
            newtime=intent.getStringExtra("newtime");
        }
    }
     @RequiresApi(api = Build.VERSION_CODES.N)
     @OnClick({R.id.rel_findFood, R.id.tv_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tv_skip:
                try {

                    int hour, minute;
                    String am_pm;
                    if (Build.VERSION.SDK_INT >= 23) {
                        hour = timePicker.getHour();
                        minute = timePicker.getMinute();
                    } else {
                        hour = timePicker.getCurrentHour();
                        minute = timePicker.getCurrentMinute();
                    }
                    if (hour > 12) {
                        am_pm = "PM";
                        hour = hour - 12;
                    } else {
                        am_pm = "AM";
                    }

                    String time;


                    if (hour <= 9) {
                        time = "0" + hour + ":" + minute + " " + am_pm;
                        if (minute <= 9)
                            time = "0" + hour + ":" + "0" + minute + " " + am_pm;


                    } else {
                        time = hour + ":" + minute + " " + am_pm;

                    }
                    SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_TIME, "" + time);
                    Intent intent = new Intent(TimeActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                    finish();
                } catch (Exception g) {
                }
                break;
            case R.id.rel_findFood:
                try {
                    {
                        int hour, minute;
                        String am_pm;
                        if (Build.VERSION.SDK_INT >= 23) {
                            hour = timePicker.getHour();
                            minute = timePicker.getMinute();
                        } else {
                            hour = timePicker.getCurrentHour();
                            minute = timePicker.getCurrentMinute();
                        }
                        if (hour > 12) {
                            am_pm = "PM";
                            hour = hour - 12;
                        } else {
                            am_pm = "AM";
                        }

                        String time = null;


                        if (hour > 9 && minute <= 9) {
                            time = hour + ":" + "0" + minute + " " + am_pm;
                        }
                        if (hour <=12 && minute > 9) {
                            time = hour + ":" + minute + " " + am_pm;

                        }

                        if (hour <= 9) {
                            time = "0" + hour + ":" + minute + " " + am_pm;
                            if (minute <= 9)
                                time = "0" + hour + ":" + "0" + minute + " " + am_pm;

                        }

                        if(newtime!=null){
                            SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_TIME, "" + time);

                            Intent intent = new Intent();
                            intent.putExtra("newtime", time);
                            setResult(RESULT_OK, intent);

                             finish();
                        }else{
                            SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_TIME, "" + time);
                            Intent intent = new Intent(TimeActivity.this, MainActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                            finish();
                        }


                    }
                } catch (Exception g) {
                }
                break;

        }
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
    }

}