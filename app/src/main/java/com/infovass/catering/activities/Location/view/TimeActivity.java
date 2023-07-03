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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
        context = getApplicationContext();
        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
            tv_cityName.setText(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_ARABIC_AREA_NAME, ""));

        } else {
            tv_cityName.setText(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_AREA_NAME, ""));

        }
        tv_date.setText(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_DATE, ""));
        timePicker.is24HourView();
        UpdateTime();
    }


    public void UpdateTime() {
        Intent intent = getIntent();
        if (intent != null) {
            newtime = intent.getStringExtra("newtime");
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
                        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                            am_pm = "مساءً";
                        } else {
                            am_pm = "PM";

                        }
                        hour = hour - 12;
                    } else {
                        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                            am_pm = "صباحا";
                        } else {
                            am_pm = "AM";


                        }
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
                        String time = null;
                        if (Build.VERSION.SDK_INT >= 23) {
                            hour = timePicker.getHour();
                            minute = timePicker.getMinute();
                            // Create a Calendar instance to set the selected time
                            Calendar selectedTime = Calendar.getInstance();
                            selectedTime.set(Calendar.HOUR_OF_DAY, hour);
                            selectedTime.set(Calendar.MINUTE, minute);

                            // Create a SimpleDateFormat instance for Arabic locale

                            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                                SimpleDateFormat sdfArabic = new SimpleDateFormat("hh:mm a", new Locale("ar"));

                                // Format the selected time in Arabic
                                String formattedTimeArabic = sdfArabic.format(selectedTime.getTime());

                                // Add leading zeros if the hour is less than 10
                                if (hour < 10) {
                                    formattedTimeArabic = "0" + formattedTimeArabic;
                                }

                                // Add leading zeros if the minute is less than 10
                                if (minute < 10) {
                                    formattedTimeArabic = formattedTimeArabic.replace(":", ":0");
                                }

                                time = formattedTimeArabic;

                            } else {


                                // Create a SimpleDateFormat instance for English locale
                                SimpleDateFormat sdfEnglish = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);


                                // Format the selected time in English
                                String formattedTimeEnglish = sdfEnglish.format(selectedTime.getTime());

                                // Display the formatted time in Arabic and English
                                // You can update your UI or perform any other operations with the formatted times

                                // Add leading zeros if the hour is less than 10


                                if (hour < 10) {
                                    formattedTimeEnglish = "0" + formattedTimeEnglish;
                                }

                                // Add leading zeros if the minute is less than 10
                                if (minute < 10) {
                                    formattedTimeEnglish = formattedTimeEnglish.replace(":", ":0");
                                }

                                time = formattedTimeEnglish;

                            }

                        } else {

                            hour = timePicker.getHour();
                            minute = timePicker.getMinute();
                            // Create a Calendar instance to set the selected time
                            Calendar selectedTime = Calendar.getInstance();
                            selectedTime.set(Calendar.HOUR_OF_DAY, hour);
                            selectedTime.set(Calendar.MINUTE, minute);
                            // Create a SimpleDateFormat instance for Arabic locale

                            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                                SimpleDateFormat sdfArabic = new SimpleDateFormat("hh:mm a", new Locale("ar"));

                                // Format the selected time in Arabic
                                String formattedTimeArabic = sdfArabic.format(selectedTime.getTime());

                                // Add leading zeros if the hour is less than 10
                                if (hour < 10) {
                                    formattedTimeArabic = "0" + formattedTimeArabic;
                                }

                                // Add leading zeros if the minute is less than 10
                                if (minute < 10) {
                                    formattedTimeArabic = formattedTimeArabic.replace(":", ":0");
                                }

                                time = formattedTimeArabic;

                            } else {

                                // Create a SimpleDateFormat instance for English locale
                                SimpleDateFormat sdfEnglish = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);


                                // Format the selected time in English
                                String formattedTimeEnglish = sdfEnglish.format(selectedTime.getTime());

                                // Display the formatted time in Arabic and English
                                // You can update your UI or perform any other operations with the formatted times

                                // Add leading zeros if the hour is less than 10
                                if (hour < 10) {
                                    formattedTimeEnglish = "0" + formattedTimeEnglish;
                                }

                                // Add leading zeros if the minute is less than 10
                                if (minute < 10) {
                                    formattedTimeEnglish = formattedTimeEnglish.replace(":", ":0");
                                }

                                time = formattedTimeEnglish;

                            }
                        }
//                        if (hour > 12) {
//                            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
//                                am_pm = "مساءً";
//                            }else{
//                                am_pm = "PM";
//
//                            }
//                            hour = hour - 12;
//                        } else {
//                            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
//                                am_pm = "صباحا";
//                            }else{
//                                am_pm = "AM";
//
//
//                            }
//                        }
//
//
//
//
//
//                        if (hour > 9 && minute <= 9) {
//                            time = hour + ":" + "0" + minute + " " + am_pm;
//                        }
//                        if (hour <=12 && minute > 9) {
//                            time = hour + ":" + minute + " " + am_pm;
//
//                        }
//
//                        if (hour <= 9) {
//                            time = "0" + hour + ":" + minute + " " + am_pm;
//                            if (minute <= 9)
//                                time = "0" + hour + ":" + "0" + minute + " " + am_pm;
//
//                        }

                        if (newtime != null) {

                            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                                Intent intent = new Intent();
                                String originalTime = time;
                                String modifiedTime = "";

                                SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm a",  new Locale("ar"));
                                SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a",  new Locale("ar"));
                                Date timedata = null;
                                try {
                                    timedata = inputFormat.parse(originalTime);
                                    modifiedTime = outputFormat.format(timedata);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                System.out.println(modifiedTime);  // Output: 06:05 PM
                                intent.putExtra("newtime", modifiedTime);
                                setResult(RESULT_OK, intent);
                                SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_TIME, "" + modifiedTime);

                                finish();

                            }else{

                                Intent intent = new Intent();
                                String originalTime = time;
                                String modifiedTime = "";

                                SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm a", Locale.US);
                                SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a", Locale.US);
                                Date timedata = null;
                                try {
                                    timedata = inputFormat.parse(originalTime);
                                    modifiedTime = outputFormat.format(timedata);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                System.out.println(modifiedTime);  // Output: 06:05 PM
                                intent.putExtra("newtime", modifiedTime);
                                setResult(RESULT_OK, intent);
                                SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_TIME, "" + modifiedTime);

                                finish();
                            }

                        } else {
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