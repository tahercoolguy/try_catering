package com.infovass.catering.activities.profile.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.infovass.catering.R;
import com.infovass.catering.Utils.Helper;
import com.infovass.catering.activities.Location.model.AreaList;
import com.infovass.catering.activities.Location.model.CityList;
import com.infovass.catering.activities.adapers.AreaListAdapter;
import com.infovass.catering.activities.adapers.CityListAdapter;
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.profile.AddressActivity;
import com.infovass.catering.activities.profile.model.AddAddressResponse;
import com.infovass.catering.activities.profile.model.AddressResponse;
import com.infovass.catering.activities.profile.model.DefaultAddressResponse;
import com.infovass.catering.activities.profile.presenter.AddressImpl;
import com.infovass.catering.activities.profile.presenter.AddressPresenter;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAddressActivity extends BaseActivity implements AddressViews, OnMapReadyCallback {

    String piece, avenue, road, building, floor, apartment, other_notes, cityID = "", areaID = "";
    List<CityList.Result> list = new ArrayList<>();
    List<AreaList.Result> areaList = new ArrayList<>();
    AddressPresenter addressPresenter;
    @BindView(R.id.city_layout)
    RelativeLayout city_layout;
    @BindView(R.id.region_layout)
    RelativeLayout region_layout;
    @BindView(R.id.tv_city)
    AppCompatTextView tv_city;
    @BindView(R.id.tv_area)
    AppCompatTextView tv_area;
    @BindView(R.id.blockET)
    AppCompatEditText blockET;
    @BindView(R.id.avenueEditText)
    AppCompatEditText avenueEditText;
    @BindView(R.id.streetET)
    AppCompatEditText streetET;
    @BindView(R.id.buildingEditText)
    AppCompatEditText buildingEditText;
    @BindView(R.id.floor_numEditText)
    AppCompatEditText floor_numEditText;
    @BindView(R.id.apartmentEditText)
    AppCompatEditText apartmentEditText;
    @BindView(R.id.other_notesEditText)
    AppCompatEditText other_notesEditText;
    @BindView(R.id.rel_findFood)
    RelativeLayout rel_findFood;
    @BindView(R.id.lnr)
    LinearLayout lnr;
    @BindView(R.id.backButton)
    ImageButton backButton;

    Double Latitude, Longitude;
//    private GoogleMap mMap;


    //    for maps
    private FusedLocationProviderClient client;
    private SupportMapFragment mapFragment;
    private int REQUEST_CODE = 111;
    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;
    private GoogleMap mMap;
    private Geocoder geocoder;
    private double selectedlat, selecteclng;
    private List<Address> addresses;
    private String selectedAddress;
    ///////////////////////////

    @BindView(R.id.currentAddressTxt)
    TextView currentAddressTxt;
    @BindView(R.id.apartmentTxt)
    TextView apartmentTxt;
    @BindView(R.id.houseTxt)
    TextView houseTxt;
    @BindView(R.id.officeTxt)
    TextView officeTxt;
    @BindView(R.id.houseET)
    AppCompatEditText houseET;
    @BindView(R.id.officeET)
    AppCompatEditText officeET;
    @BindView(R.id.officeLL)
    LinearLayout officeLL;
    @BindView(R.id.houseLL)
    LinearLayout houseLL;
    @BindView(R.id.buildingLL)
    LinearLayout buildingLL;


    @OnClick({R.id.rel_findFood, R.id.city_layout, R.id.region_layout, R.id.backButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_findFood:
                try {
                    if (isNetAvail()) {
                        if (isValid()) {
                            try {
                                addressPresenter.AddAddressApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), "H", "H", floor
                                        , "", apartment, building, ""
                                        , "OFFICE", "" + apartment + " " + building + " " + piece + " "
                                                + avenue + " " + road, "", "", cityID
                                        , areaID, piece, avenue, road);
                            } catch (Exception j) {
                            }
                        }
                    }
                } catch (Exception g) {
                }
                break;
            case R.id.city_layout:
                try {
                    showCityListPopUp(lnr, list, list, "");
                } catch (Exception g) {
                }
                break;

            case R.id.region_layout:
                try {
                    showAreaListPopUp(lnr, areaList, areaList, "");
                } catch (Exception g) {
                }
                break;

            case R.id.backButton:
                try {
                    finish();
                } catch (Exception g) {
                }
                break;

        }
    }

    private void showAreaListPopUp(LinearLayout lnr, List<AreaList.Result> areaList, List<AreaList.Result> areaList1, String s) {
        lnr.setEnabled(false);
        LayoutInflater layoutInflater = (LayoutInflater) AddAddressActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.dialog_city_list, null);
        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                lnr.getWidth(),
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        RecyclerView recycler_list = popupView.findViewById(R.id.rv_countriesList);
        AreaListAdapter adapter = new AreaListAdapter(getApplicationContext(), areaList, s);
        recycler_list.setHasFixedSize(false);
        recycler_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recycler_list.setAdapter(adapter);
        adapter.setOnItemClickListener(position -> {
            lnr.setEnabled(true);
            tv_area.setText(areaList.get(position).getName());
            areaID = "" + areaList.get(position).getId();
//            Latitude = Double.valueOf("" + areaList.get(position).getLat());
//            Longitude = Double.valueOf("" + areaList.get(position).getLng());
            // addressPresenter.getArealistApi(cityID);
//            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                    .findFragmentById(R.id.map_fragment);
//            if (mapFragment != null)
//                mapFragment.getMapAsync(this);
            try {
            } catch (Exception ignore) {
            }
            popupWindow.dismiss();
        });
        popupWindow.setOnDismissListener(() -> lnr.setEnabled(true));
        popupWindow.showAtLocation(lnr, Gravity.CENTER, (int) lnr.getX(), (int) lnr.getY());
    }

    private void showCityListPopUp(LinearLayout lnr, List<CityList.Result> list, List<CityList.Result> list1, String s) {
        lnr.setEnabled(false);
        LayoutInflater layoutInflater = (LayoutInflater) AddAddressActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.dialog_city_list, null);
        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                lnr.getWidth(),
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        RecyclerView recycler_list = popupView.findViewById(R.id.rv_countriesList);
        CityListAdapter adapter = new CityListAdapter(getApplicationContext(), list, s);
        recycler_list.setHasFixedSize(false);
        recycler_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recycler_list.setAdapter(adapter);
        adapter.setOnItemClickListener(position -> {
            lnr.setEnabled(true);
            tv_city.setText(list.get(position).getName());
            cityID = "" + list.get(position).getId();
            addressPresenter.getArealistApi(cityID);
            try {
            } catch (Exception ignore) {
            }
            popupWindow.dismiss();
        });

        popupWindow.setOnDismissListener(() -> lnr.setEnabled(true));
        popupWindow.showAtLocation(lnr, Gravity.CENTER, (int) lnr.getX(), (int) lnr.getY());
        //  popupWindow.showAsDropDown(view, (int) view.getX(), (int) view.getY());//-30
    }

    private boolean isValid() {
        boolean error = true;
        piece = Objects.requireNonNull(blockET.getText()).toString().trim();
        avenue = Objects.requireNonNull(avenueEditText.getText()).toString().trim();
        road = Objects.requireNonNull(streetET.getText()).toString().trim();
        building = Objects.requireNonNull(buildingEditText.getText()).toString().trim();
        floor = Objects.requireNonNull(floor_numEditText.getText()).toString().trim();
        apartment = Objects.requireNonNull(apartmentEditText.getText()).toString().trim();
        other_notes = Objects.requireNonNull(other_notesEditText.getText()).toString().trim();

//        if (InputValidations.isNullOrEmpty(mUserEmail)) {
//            error = false;
//            Animation shake = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.shake);
//            userNameEditText.startAnimation(shake);
//            userNameEditText.setError(getString(R.string.valid_email_address));
//            userNameEditText.setFocusable(true);
//            userNameEditText.requestFocus();
//        }
//        else if (!InputValidations.isEmailValid(mUserEmail)) {
//            error = false;
//            Animation shake = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.shake);
//            userNameEditText.startAnimation(shake);
//            userNameEditText.setError(getString(R.string.valid_email_address));
//            userNameEditText.setFocusable(true);
//            userNameEditText.requestFocus();
//        }
//        else if (InputValidations.isNullOrEmpty(mUserpassword)) {
//            error = false;
//            Animation shake = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.shake);
//            passwordEditText.startAnimation(shake);
//            passwordEditText.setError(getString(R.string.valid_password));
//            passwordEditText.setFocusable(true);
//            passwordEditText.requestFocus();
//        }

        return error;
    }


    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this);
        addressPresenter = new AddressImpl(this);
        addressPresenter.getCityListApi();
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment);

        client = LocationServices.getFusedLocationProviderClient(AddAddressActivity.this);
        if (ActivityCompat.checkSelfPermission(AddAddressActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation();
        } else {
            ActivityCompat.requestPermissions(AddAddressActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
        }
    }

    //for map
    private void getCurrentLocation() {

        if (ActivityCompat.checkSelfPermission(AddAddressActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(AddAddressActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Task<Location> task = client.getLastLocation();

        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            mMap = googleMap;
                            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());


                            MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("You are here");

                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));
                            googleMap.addMarker(markerOptions).showInfoWindow();



                            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                                @Override
                                public void onMapClick(LatLng latLng) {
                                    CheckConnection();

                                    if (networkInfo.isConnected() && networkInfo.isAvailable()) {
                                        selectedlat = latLng.latitude;
                                        selecteclng = latLng.longitude;

                                        GetAddress(selectedlat, selecteclng);

                                    } else {
                                        Toast.makeText(AddAddressActivity.this, "please check connection", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                        }
                    });
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            }
        } else {
            Toast.makeText(AddAddressActivity.this, "permission denied", Toast.LENGTH_SHORT).show();
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    private void CheckConnection() {
        connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
    }


    private void GetAddress(double mlat, double mlong) {
        geocoder = new Geocoder(AddAddressActivity.this, Locale.getDefault());

        if (mlat != 0) {

            try {
                addresses = geocoder.getFromLocation(mlat, mlong, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (addresses != null) {
                String mAddress = addresses.get(0).getAddressLine(0);

                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String postalCode = addresses.get(0).getPostalCode();
                String areaName = addresses.get(0).getFeatureName();
                String dis = addresses.get(0).getSubAdminArea();

                selectedAddress = mAddress;

                if (mAddress != null) {
                    MarkerOptions markerOptions = new MarkerOptions();

                    LatLng latLng = new LatLng(mlat, mlong);
                    markerOptions.position(latLng).title(selectedAddress);
//                    mMap.addMarker(markerOptions).showInfoWindow();
                } else {
                    Helper.showToast(AddAddressActivity.this, "Something went  wrong");
                }
            } else {
                Helper.showToast(AddAddressActivity.this, "Something went  wrong");
            }
        } else {
            Helper.showToast(AddAddressActivity.this, "latlng null");
        }

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onNoInternet() {

    }

    @Override
    public void onSuccessGetAddressAPi(AddressResponse addressResponse) {

    }

    @Override
    public void onSuccessSetDefaultAddressAPi(DefaultAddressResponse defaultAddressResponse) {

    }

    @Override
    public void onSuccessGetCityListAPi(CityList cityList) {
        try {
            if (cityList.getStatus()) {
                list.clear();
                if (cityList.getResult().size() == 0) {
                } else {
                    list.addAll(cityList.getResult());
                }
            }
        } catch (Exception ignore) {
        }
    }

    @Override
    public void onSuccessGetAreaListAPi(AreaList areaLList) {
        try {
            areaList.clear();
            if (areaLList.getResult().size() == 0) {

            } else {

                areaList.addAll(areaLList.getResult());
            }

        } catch (Exception ignore) {
        }
    }

    @Override
    public void onSuccessAddAddressAPi(AddAddressResponse addressResponse) {
        try {
            if (addressResponse.getStatus()) {
                Intent intent = new Intent(AddAddressActivity.this, AddressActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                finish();

            } else {
                Toast.makeText(AddAddressActivity.this, "" + addressResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception f) {
        }

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(Latitude, Longitude);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick(R.id.apartmentTxt)
    public void clickApartment() {

        apartmentTxt.setBackground(getDrawable(R.drawable.location_page_bg));
        apartmentTxt.setTextColor(getColor(R.color.white));


        houseTxt.setBackground(getDrawable(R.drawable.location_page_unselect));
        houseTxt.setTextColor(getColor(R.color.black));


        officeTxt.setBackground(getDrawable(R.drawable.location_page_unselect));
        officeTxt.setTextColor(getColor(R.color.black));

        houseLL.setVisibility(View.GONE);
        officeLL.setVisibility(View.GONE);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick(R.id.houseTxt)
    public void clickHouse() {

        apartmentTxt.setBackground(getDrawable(R.drawable.location_page_unselect));
        apartmentTxt.setTextColor(getColor(R.color.black));

        houseTxt.setBackground(getDrawable(R.drawable.location_page_bg));
        houseTxt.setTextColor(getColor(R.color.white));

        officeTxt.setBackground(getDrawable(R.drawable.location_page_unselect));
        officeTxt.setTextColor(getColor(R.color.black));

        houseLL.setVisibility(View.VISIBLE);
        officeLL.setVisibility(View.GONE);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick(R.id.officeTxt)
    public void clickOffice() {

        apartmentTxt.setBackground(getDrawable(R.drawable.location_page_unselect));
        apartmentTxt.setTextColor(getColor(R.color.black));

        houseTxt.setBackground(getDrawable(R.drawable.location_page_unselect));
        houseTxt.setTextColor(getColor(R.color.black));

        officeTxt.setBackground(getDrawable(R.drawable.location_page_bg));
        officeTxt.setTextColor(getColor(R.color.white));

        houseLL.setVisibility(View.GONE);
        officeLL.setVisibility(View.VISIBLE);

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