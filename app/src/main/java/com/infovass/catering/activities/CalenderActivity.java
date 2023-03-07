package com.infovass.catering.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import com.infovass.catering.R;
import com.infovass.catering.activities.Location.view.TimeActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalenderActivity extends AppCompatActivity {

    @BindView(R.id.cal_one)
    CalendarView cal_one;
    String curDate = "",curDate1="";
    String newdate;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        ButterKnife.bind(this);
        context=this.getApplicationContext();
        cal_one.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {

                if(dayOfMonth<=9){
                    curDate="0"+dayOfMonth+"-"+(month+1)+"-"+year;
                }
                if((month+1)<=9){
                    curDate=dayOfMonth+"-"+"0"+(month+1)+"-"+year;
                }
                if(dayOfMonth<=9&&(month+1)<=9){
                    curDate="0"+dayOfMonth+"-"+"0"+(month+1)+"-"+year;
                }


              //  curDate1 = year+"-"+month+"-"+dayOfMonth;
            }
        });
        UpdateDate();
    }


    public  void UpdateDate(){
        Intent intent= getIntent();
        if(intent!=null){
            newdate=intent.getStringExtra("newdate");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick({R.id.rel_findFood , R.id.tv_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_skip:
                try {
                    if(curDate.equalsIgnoreCase(""))
                    {
                        Date c = Calendar.getInstance().getTime();
                        System.out.println("Current time => " + c);
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                      //  SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        String formattedDate = df.format(c);
                     //   String formattedDate1 = df1.format(c);
                        SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_DATE , ""+formattedDate);
                     //   SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_DATE1 , ""+formattedDate1);
                    }else
                    {
                        SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_DATE , ""+curDate);
                     //   SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_DATE1 , ""+curDate1);
                    }
                    Intent intent = new Intent(CalenderActivity.this  , MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                    finish();
                }catch (Exception g) {}
                break;
            case R.id.rel_findFood:
                try {
                    if(curDate.equalsIgnoreCase(""))
                    {
                        Date c = Calendar.getInstance().getTime();
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                       // SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        String formattedDate = df.format(c);
                       // String formattedDate1 = df1.format(c);
                        SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_DATE , ""+formattedDate);
                       // SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_DATE1 , ""+formattedDate1);
                    }else
                    {
                        SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_DATE , ""+curDate);
                       // SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_DATE1 , ""+curDate1);
                    }

                    if(newdate!=null){
                        Intent intent = new Intent();
                        if(curDate.equalsIgnoreCase(""))
                        {
                            Date c = Calendar.getInstance().getTime();
                            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                            // SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                            String formattedDate = df.format(c);
                            // String formattedDate1 = df1.format(c);
                            SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_DATE , ""+formattedDate);
                            intent.putExtra("newtime", formattedDate);

                            // SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_DATE1 , ""+formattedDate1);
                        }else
                        {
                            SharedPreferencesUtils.getInstance(getApplicationContext()).setValue(Constants.KEY_DATE , ""+curDate);
                            intent.putExtra("newtime", curDate);



                            // SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.KEY_DATE1 , ""+curDate1);
                        }
                        setResult(RESULT_OK, intent);
                         finish();
                    }else{
                        Intent intent = new Intent(CalenderActivity.this  , TimeActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                        finish();
                    }




                }catch (Exception g) {
                    g.printStackTrace();
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