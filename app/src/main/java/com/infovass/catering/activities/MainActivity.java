package com.infovass.catering.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.infovass.catering.BuildConfig;
import com.infovass.catering.DM.AppVersionRootDM;
import com.infovass.catering.DM.GuestNotificationRoot;
import com.infovass.catering.DM.ProfileDM.ProfileRoot;
import com.infovass.catering.MyFormat.Controller.AppController;
import com.infovass.catering.MyFormat.Utils.ConnectionDetector;
import com.infovass.catering.R;
import com.infovass.catering.activities.cart.view.CartActivity;
import com.infovass.catering.activities.fav.FavFragment;
import com.infovass.catering.activities.home.view.RestourentFragment;
import com.infovass.catering.activities.home.view.SearchFragment;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.order.OrderListActivity;
import com.infovass.catering.activities.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.android.material.navigation.NavigationView;
import com.infovass.catering.activities.profile.presenter.ProfileImpl;
import com.infovass.catering.activities.profile.view.MyAccountDetailActivity;
import com.infovass.catering.activities.utill.ProgressHUD;


import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedString;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    androidx.appcompat.widget.Toolbar toolbar;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    private AppController appController;
    private Dialog progress;
    private ConnectionDetector connectionDetector;

    @BindView(R.id.searchImg)
    ImageView searchImg;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //      toolbar = (Toolbar) findViewById(R.id.toolbar);
        //       DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//       // toggle.setDrawerIndicatorEnabled(false);
//       /// toolbar.setNavigationIcon(R.drawable.icon_drawer);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_AUTO);
        bottomNavigationView.setOnNavigationItemSelectedListener(MainActivity.this);

        callRestourentFragment("RestourentFragment");


        appController = (AppController) this.getApplicationContext();
        connectionDetector = new ConnectionDetector(getApplicationContext());

        fireBaseNotification();


    }

    public void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
//    @OnClick({R.id.myOrderLayout, R.id.lnr_changLanguage})
//    public void onViewClicked(View view) {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        switch (view.getId()) {
//            case R.id.myOrderLayout:
//                Intent intent = new Intent(MainActivity.this, OrderListActivity.class);
//                startActivity(intent);
//
//                break;
//
//            case R.id.lnr_changLanguage:
//                Intent intentt = new Intent(MainActivity.this, ChangeLanguageActivity.class);
//                startActivity(intentt);
//                break;
//        }
//    }

    boolean searchClicked = false;

    @OnClick(R.id.searchImg)
    public void clicksearchImg() {
//        startActivity(new Intent(MainActivity.this, CartActivity.class));
//        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
        searchClicked = true;
        SearchFragment fragment = SearchFragment.newInstance();
        startFragment(fragment);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void callRestourentFragment(String value) {
        searchClicked=false;
        RestourentFragment restourentFragment = RestourentFragment.newInstance();
        startFragment(restourentFragment);
//        Common.CONTAINER_FRAGMENT = "RestourentFragment";
//        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void callFavFragment(String value) {
        FavFragment fragment = FavFragment.newInstance();
        startFragment(fragment);
//        Common.CONTAINER_FRAGMENT = "RestourentFragment";
//        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void callProfileFragment(String value) {
        ProfileFragment fragment = ProfileFragment.newInstance();
        startFragment(fragment);
//        Common.CONTAINER_FRAGMENT = "RestourentFragment";
//        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void callSearchFragment(String value) {
        SearchFragment fragment = SearchFragment.newInstance();
        startFragment(fragment);
//        Common.CONTAINER_FRAGMENT = "RestourentFragment";
//        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
    }

    public void startFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getName());
//        if (addToStack) {
//            fragmentTransaction.addToBackStack(fragment.getClass().getName());
//        }
        fragmentTransaction.commitAllowingStateLoss();
    }

//    private void startFragment(Fragment fragment) {
//        String backStateName = fragment.getClass().getName();
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        Fragment oldFragment = fragmentManager.findFragmentByTag(backStateName);
//        if (oldFragment != null) {
//            fragmentManager.beginTransaction().remove(oldFragment).commit();
//        }
//
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        if (fragment.isAdded()) {
//            Fragment currentFragment = fragmentManager.findFragmentByTag(backStateName);
//            if (currentFragment != null) {
//                fragmentTransaction.detach(currentFragment);
//                fragmentTransaction.attach(currentFragment);
////                fragmentTransaction.addToBackStack(backStateName).commit();
//            } else {
//                fragmentTransaction.replace(R.id.container, fragment);
////                fragmentTransaction.addToBackStack(backStateName).commit();
//            }
//        } else {
//            //  fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.fade_out, android.R.anim.slide_in_left, android.R.anim.fade_out);
//            fragmentTransaction.add(R.id.container, fragment);
//            fragmentTransaction.addToBackStack(backStateName).commit();
//        }
//    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.homeMenu) {
            callRestourentFragment("RestourentFragment");
        }
//        else if (id == R.id.favMenu) {
//            callFavFragment("FavFragment");
//        }
        else if (id == R.id.cartMenu) {
//            callSearchFragment("SearchFragment");
            startActivity(new Intent(MainActivity.this, CartActivity.class));
            overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

        }

//        else if (id == R.id.searchMenu) {
//            callSearchFragment("SearchFragment");
//        }

        else if (id == R.id.profileMenu) {
            callProfileFragment("ProfileFragment");
        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBackPressed() {
        if (bottomNavigationView.getSelectedItemId() == R.id.homeMenu) {
            if(searchClicked){
                callRestourentFragment("RestourentFragment");
            }else{
                finish();
            }

        } else {
            bottomNavigationView.setSelectedItemId(R.id.homeMenu);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) {

            String newlocationArea = data.getStringExtra("newlocationArea");
            String newtime = data.getStringExtra("newtime");

            if (newlocationArea != null) {
                callRestourentFragment("callRestourentFragment");
            }
            if (newtime != null) {
                callRestourentFragment("callRestourentFragment");
            }

        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void fireBaseNotification() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
//                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();
                        notificationGuestAPI(token);
                        // Log and toast
                        String msg = token;
//                        Log.d(TAG, msg);
//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void notificationGuestAPI(String token) {
        if (connectionDetector.isConnectingToInternet()) {
            MultipartTypedOutput multipartTypedOutput = new MultipartTypedOutput();
//            String token = SharedPreferencesUtils.getInstance(MainActivity.this).getValue(Constants.TOKEN, "" );

            multipartTypedOutput.addPart("device_token", new TypedString(token));
            multipartTypedOutput.addPart("device_type", new TypedString("android"));

            appController.paServices.GuestNotification(multipartTypedOutput, new Callback<GuestNotificationRoot>() {
                @Override
                public void success(GuestNotificationRoot guestNotificationRoot, Response response) {

                    if (guestNotificationRoot.isStatus()) {
                        try {


                        } catch (Exception j) {
                            j.printStackTrace();
                        }
                    }


                }

                @Override
                public void failure(RetrofitError error) {

                    error.printStackTrace();
                }
            });

        } else {
            Toast.makeText(MainActivity.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_in);
    }


    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}