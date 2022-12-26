package com.infovass.catering.activities.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.infovass.catering.R;
import com.infovass.catering.activities.utill.Common;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    protected void hideStatusBar() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected <T extends AppCompatActivity> void startActivity(final Class<T> destination) {
        startActivity(new Intent(getActivityContext(), destination));
    }

    protected void fillLayoutStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

    }


    protected void showStatusBar() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected boolean isVersionMarsh() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

//    protected void hideKeyboard() {
//        Common.hideSoftKeyboard((Activity) getActivityContext());
//
//    }

    protected boolean isNetAvail() {
        return Common.isNetworkAvail(getApplicationContext());
    }

    protected void makeToast(String msg) {
        if (msg != null && getApplicationContext() != null) {

            Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
            View view = toast.getView();

            TextView view1 = (TextView) view.findViewById(android.R.id.message);
            view1.setPadding(5, 5, 5, 5);
            view1.setTextColor(Color.WHITE);
            view1.setTextSize(16);
            view.setBackgroundResource(R.drawable.toast_bg);
            toast.show();
        }
    }

    protected boolean isPermissionGranted(@NonNull String whichPermission) {
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), whichPermission)
                == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    protected abstract Context getActivityContext();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
}
