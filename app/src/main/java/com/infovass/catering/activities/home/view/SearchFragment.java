package com.infovass.catering.activities.home.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.MyFormat.Controller.AppController;
import com.infovass.catering.MyFormat.Utils.ConnectionDetector;
import com.infovass.catering.R;
import com.infovass.catering.Utils.Helper;
import com.infovass.catering.activities.CalenderActivity;
import com.infovass.catering.activities.DataModel.RD_catererData;
import com.infovass.catering.activities.DataModel.RD_caterers_Root;
import com.infovass.catering.activities.Location.view.LocationActivity;
import com.infovass.catering.activities.Location.view.TimeActivity;
import com.infovass.catering.activities.adapers.RestourentcategoriesAdapter;
import com.infovass.catering.activities.adapers.ResturantLargeAdapter;
import com.infovass.catering.activities.adapers.ResturantMainLargeAdapter;
import com.infovass.catering.activities.adapers.ResturantSearchAdapter;
import com.infovass.catering.activities.home.model.RestourentListResponse;
import com.infovass.catering.activities.home.presenter.RestourentImpl;
import com.infovass.catering.activities.home.presenter.RestourentPresenter;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.ProgressHUD;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedString;

public class SearchFragment extends Fragment implements RestourentView {

        List<RestourentListResponse.Datum> restourentLIst = new ArrayList<>();
//    ArrayList<RD_catererData> restourentLIst = new ArrayList<>();
    private ProgressHUD progressHUD;
    RestourentPresenter restourentPresenter;
    View view;
    RestourentcategoriesAdapter restourentcategoriesAdapter;
        ResturantLargeAdapter resturantLargeAdapter;
    @BindView(R.id.resturantListView)
    RecyclerView resturantListView;
    @BindView(R.id.detail_recyclerView)
    RecyclerView detail_recyclerView;
    @BindView(R.id.tv_city)
    AppCompatTextView tv_city;
    @BindView(R.id.tv_time)
    AppCompatTextView tv_time;
    @BindView(R.id.tv_date)
    AppCompatTextView tv_date;

    @BindView(R.id.locationLL)
    LinearLayout locationLL;

    @BindView(R.id.dateLL)
    LinearLayout dateLL;

    @BindView(R.id.timeLL)
    LinearLayout timeLL;
    @BindView(R.id.searchLL)
    LinearLayout searchLL;
    @BindView(R.id.searchview)
    android.widget.SearchView searchview;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;

    Activity activity;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    private AppController appController;
    private Dialog progress;
    private ConnectionDetector connectionDetector;
    Context context;
    ResturantMainLargeAdapter resturantMainLargeAdapter;
    ArrayList<RD_catererData> catererData;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.search_fragment, container, false);
        ButterKnife.bind(this, view);
        activity = getActivity();
        context = getActivity().getApplicationContext();
        appController = (AppController) getActivity().getApplicationContext();
        connectionDetector = new ConnectionDetector(getActivity());
        searchLL.setVisibility(View.VISIBLE);
        framelayout.setVisibility(View.INVISIBLE);
        activity = getActivity();
        progressHUD = ProgressHUD.create(getContext(), getString(R.string.loading), false, null, null);
        restourentPresenter = new RestourentImpl(this);
        restourentPresenter.getRestourentlistApi("", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

//        restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

//        newRandomCaterers();
        tv_city.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_NAME, ""));
        tv_time.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_TIME, ""));
        tv_date.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

//        List<String> list = new ArrayList<>();
//        list.add(getResources().getString(R.string.all));
//        list.add(getResources().getString(R.string.catering));
//        list.add(getResources().getString(R.string.delivery));
//
//        restourentcategoriesAdapter = new RestourentcategoriesAdapter(list, getContext());
//        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(
//                getContext(),
//                LinearLayoutManager.HORIZONTAL,
//                false);
//        detail_recyclerView.setLayoutManager(HorizontalLayout);
////        detail_recyclerView.setAdapter(restourentcategoriesAdapter);
//        restourentcategoriesAdapter.setOnItemClickListener(new RestourentcategoriesAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position, TextView custom_tab_textView, LinearLayout detail_item_linearLayout) {
//                restourentcategoriesAdapter.notifyDataSetChanged();
//                if (position == 0) {
//                    restourentPresenter.getRestourentlistApi("", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
//                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
//
//                }
//                if (position == 1) {
//                    restourentPresenter.getRestourentlistApi("1", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
//                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
//                }
//                if (position == 2) {
//                    restourentPresenter.getRestourentlistApi("2", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
//                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
//                }
////                if (position==3)
////                {
////                    restourentPresenter.getRestourentlistApi("3",SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""));
////                }
//            }
//        });

//        resturantLargeAdapter = new ResturantSearchAdapter(getContext(), restourentLIst);
//        resturantListView.setLayoutManager(new LinearLayoutManager(getContext()));
//        resturantListView.setAdapter(resturantLargeAdapter);
//        resturantLargeAdapter.setOnItemClickListener(new ResturantSearchAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position, int Restaurant_Status) {
//                SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(position).getId());
//                int restaurententID = restourentLIst.get(position).getId();
//                String restaurant_Status = String.valueOf(Restaurant_Status);
//                Intent intent = new Intent(getContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
//                        .putExtra("restaurant_Status", restaurant_Status);
//                startActivity(intent);
//                activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
//            }
//
//        });
        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
            resturantListView.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        } else {
            resturantListView.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        }
        resturantLargeAdapter = new ResturantLargeAdapter(getContext(), restourentLIst);
        resturantListView.setLayoutManager(new LinearLayoutManager(getContext()));
        resturantListView.setAdapter(resturantLargeAdapter);
        resturantLargeAdapter.setOnItemClickListener(new ResturantLargeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int selectedposition, int Restaurant_Status, List<RestourentListResponse.Datum> restourentLIst) {
                SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(selectedposition).getId());
                int restaurententID = restourentLIst.get(selectedposition).getId();
                String restaurant_Status = String.valueOf(Restaurant_Status);
                Intent intent = new Intent(getContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
                        .putExtra("restaurant_Status", restaurant_Status);
                startActivity(intent);
                activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                hideKeyboard(activity);

            }
        });
        showKeyboard();
        setSearchData();


        // attach setOnQueryTextListener
        // to search view defined above
//        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//                try {
//                    resturantMainLargeAdapter.filterList(query);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                try {
//                    resturantMainLargeAdapter.filterList(newText);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                return false;
//            }
//        });
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Override onQueryTextSubmit method which is call when submit query is searched
            @Override
            public boolean onQueryTextSubmit(String query) {
//                resturantMainLargeAdapter.filterList(query);
                // If the list contains the search query than filter the adapter
                // using the filter method with the query as its argument
//                if (list.contains(query)) {
//                    adapter.getFilter().filter(query);
//                } else {
//                    // Search query not found in List View
//                    Toast.makeText(activity, getString(R.string.not_found), Toast.LENGTH_LONG).show();
//                }

                // inside on query text change method we are
                // calling a method to filter our recycler view.
                return false;
            }

            // This method is overridden to filter the adapter according
            // to a search query when the user is typing search
            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);

//                resturantMainLargeAdapter.filterList(newText);
                return false;
            }
        });


        return view;
    }

    public void showKeyboard() {

        searchview.setFocusable(true);
        searchview.requestFocus();
        searchview.onActionViewExpanded(); // expand the search action item automatically
        searchview.requestFocusFromTouch();
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }


    public void setSearchData() {
        listView = (ListView) view.findViewById(R.id.lv1);

        list = new ArrayList<>();


        adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

//        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//                if(list.contains(query)){
//                    adapter.getFilter().filter(query);
//                }else{
//                    Toast.makeText(getActivity(),getString(R.string.not_found),Toast.LENGTH_LONG).show();
//                }
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                //    adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
    }


    @OnClick(R.id.locationLL)
    public void ClickLocationLL() {
        startActivity(new Intent(getActivity(), LocationActivity.class));
        activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

    }

    @OnClick(R.id.dateLL)
    public void ClickDateLL() {
        startActivity(new Intent(getActivity(), CalenderActivity.class));
        activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

    }

    @OnClick(R.id.timeLL)
    public void ClickTimeLL() {
        startActivity(new Intent(getActivity(), TimeActivity.class));
        activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
    }

    @Override
    public void onSuccessGetRestourentListAPi(RestourentListResponse restourentListResponse) {
        try {
            resturantListView.setVisibility(View.VISIBLE);
            restourentLIst.clear();
            if (restourentListResponse.getData().size() == 0) {
//                lnr_noProduct.setVisibility(View.VISIBLE);
//                resturantListView.setVisibility(View.GONE);

//                restourentLIst = new ArrayList<>();
//                resturantLargeAdapter.notifyDataSetChanged();
            } else {
//                lnr_noProduct.setVisibility(View.GONE);
//                resturantListView.setVisibility(View.VISIBLE);
                restourentLIst.addAll(restourentListResponse.getData());
                resturantLargeAdapter.notifyDataSetChanged();
//                resturantMainLargeAdapter.notifyDataSetChanged();


//                for (RestourentListResponse.Datum da : restourentListResponse.getData()
//                ) {
//                    if (SharedPreferencesUtils.getInstance(getActivity()).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
//                        list.add(da.getArabicName());
//                    } else {
//                        list.add(da.getName());
//                    }
//                }
            }

        } catch (Exception ignore) {
            restourentLIst = new ArrayList<>();
            ignore.printStackTrace();
//            resturantMainLargeAdapter.notifyDataSetChanged();

        }
    }


    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<RestourentListResponse.Datum> filteredlist = new ArrayList<>();

        // running a for loop to compare elements.
        for (RestourentListResponse.Datum item : restourentLIst) {

            // checking if the entered string matched with any item of our recycler view.


            if (SharedPreferencesUtils.getInstance(getActivity()).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                if (item.getArabicName().contains(text.toLowerCase())) {
                    // if the item is matched we are
                    // adding it to our filtered list.
                    filteredlist.add(item);
                }
            }

            if (SharedPreferencesUtils.getInstance(getActivity()).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                    // if the item is matched we are
                    // adding it to our filtered list.
                    filteredlist.add(item);
                }
            }


        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
//            Toast.makeText(getContext(), getString(R.string.not_found), Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            resturantLargeAdapter.filterList(filteredlist);
        }
    }

    //
    @Override
    public void showLoading() {
        try {
//            progressHUD.show();
        } catch (Exception f) {
        }
    }

    @Override
    public void hideLoading() {
        try {
//            progressHUD.dismiss();
        } catch (Exception f) {
        }
    }

    @Override
    public void onFail(String msg) {
        resturantListView.setVisibility(View.GONE);
    }

    @Override
    public void onNoInternet() {

    }
    public void newRandomCaterers() {
        if (connectionDetector.isConnectingToInternet()) {

            String area_id = SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, "");
            String date = SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, "");
            MultipartTypedOutput multipartTypedOutput = new MultipartTypedOutput();
//            String token = SharedPreferencesUtils.getInstance(LocationActivity.this).getValue(Constants.TOKEN, "" );

            multipartTypedOutput.addPart("mode_type", new TypedString(""));
            multipartTypedOutput.addPart("area_id", new TypedString(area_id));
            multipartTypedOutput.addPart("date", new TypedString(date));

            appController.paServices.newRandomCaterers(multipartTypedOutput, new Callback<RD_caterers_Root>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void success(RD_caterers_Root rd_caterers_root, Response response) {

                    if (rd_caterers_root.getStatus().equalsIgnoreCase("true")) {

                        resturantListView.setVisibility(View.VISIBLE);
                        try {
                            catererData = new ArrayList<>();
                            catererData = rd_caterers_root.getData().getCaterersData();
//                            setRestaurentsLargeRcv(rd_caterers_root.getData().getCaterersData());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        Helper.showToast(getActivity(), getString(R.string.something_wrong));
                    }

                }

                @Override
                public void failure(RetrofitError error) {

                    error.printStackTrace();
                }
            });

        } else {
            Toast.makeText(getActivity(), getString(R.string.no_internet), Toast.LENGTH_SHORT).show();

        }
    }

//    private void setRestaurentsLargeRcv(ArrayList<RD_catererData> catererData) {
//
//        try {
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
//            resturantListView.setLayoutManager(linearLayoutManager);
//
//            resturantMainLargeAdapter = new ResturantMainLargeAdapter(activity, catererData);
//
//            resturantListView.setAdapter(resturantMainLargeAdapter);
//
//
//            resturantMainLargeAdapter.setOnItemClickListener(new ResturantMainLargeAdapter.OnItemClickListener() {
//                @Override
//                public void onItemClick(int position, int selectedposition, int Restaurant_Status, List<RD_catererData> restourentLIst) {
//                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(position).getId());
//                    int restaurententID = Integer.parseInt(restourentLIst.get(position).getId());
//                    String restaurant_Status = String.valueOf(Restaurant_Status);
//                    Intent intent = new Intent(getContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
//                            .putExtra("restaurant_Status", restaurant_Status);
//                    startActivity(intent);
//                    activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
//                }
//            });
//            resturantMainLargeAdapter.setCallback(this);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

//    @Override
//    public void onItemClick(String data) {
//        if (data.equalsIgnoreCase("data")) {
//            newRandomCaterers();
//        }
//    }
}