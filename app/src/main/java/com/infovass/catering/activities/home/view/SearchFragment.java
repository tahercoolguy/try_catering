package com.infovass.catering.activities.home.view;

import android.app.Activity;
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

import com.infovass.catering.R;
import com.infovass.catering.activities.CalenderActivity;
import com.infovass.catering.activities.Location.view.LocationActivity;
import com.infovass.catering.activities.Location.view.TimeActivity;
import com.infovass.catering.activities.adapers.RestourentcategoriesAdapter;
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

public class SearchFragment extends Fragment implements RestourentView {

    List<RestourentListResponse.Datum> restourentLIst = new ArrayList<>();
    private ProgressHUD progressHUD;
    RestourentPresenter restourentPresenter;
    View view;
    RestourentcategoriesAdapter restourentcategoriesAdapter;
    ResturantSearchAdapter resturantLargeAdapter;
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

        searchLL.setVisibility(View.VISIBLE);
        framelayout.setVisibility(View.INVISIBLE);
        activity = getActivity();
        progressHUD = ProgressHUD.create(getContext(), getString(R.string.loading), false, null, null);
        restourentPresenter = new RestourentImpl(this);
        //       restourentPresenter.getRestourentlistApi("", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

        restourentPresenter.getRestourentlist_Api(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));


        tv_city.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_NAME, ""));
        tv_time.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_TIME, ""));
        tv_date.setText(SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));

        List<String> list = new ArrayList<>();
        list.add(getResources().getString(R.string.all));
        list.add(getResources().getString(R.string.catering));
        list.add(getResources().getString(R.string.delivery));

        restourentcategoriesAdapter = new RestourentcategoriesAdapter(list, getContext());
        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);
        detail_recyclerView.setLayoutManager(HorizontalLayout);
//        detail_recyclerView.setAdapter(restourentcategoriesAdapter);
        restourentcategoriesAdapter.setOnItemClickListener(new RestourentcategoriesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView custom_tab_textView, LinearLayout detail_item_linearLayout) {
                restourentcategoriesAdapter.notifyDataSetChanged();
                if (position == 0) {
                    restourentPresenter.getRestourentlistApi("", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);

                }
                if (position == 1) {
                    restourentPresenter.getRestourentlistApi("1", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
                }
                if (position == 2) {
                    restourentPresenter.getRestourentlistApi("2", SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""), SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_DATE, ""));
                    SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.mode_id, position);
                }
//                if (position==3)
//                {
//                    restourentPresenter.getRestourentlistApi("3",SharedPreferencesUtils.getInstance(getContext()).getValue(Constants.KEY_AREA_ID, ""));
//                }
            }
        });

        resturantLargeAdapter = new ResturantSearchAdapter(getContext(), restourentLIst);
        resturantListView.setLayoutManager(new LinearLayoutManager(getContext()));
        resturantListView.setAdapter(resturantLargeAdapter);
        resturantLargeAdapter.setOnItemClickListener(new ResturantSearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int Restaurant_Status) {
                SharedPreferencesUtils.getInstance(getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + restourentLIst.get(position).getId());
                int restaurententID = restourentLIst.get(position).getId();
                String restaurant_Status = String.valueOf(Restaurant_Status);
                Intent intent = new Intent(getContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
                        .putExtra("restaurant_Status", restaurant_Status);
                startActivity(intent);
                activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
            }

        });
        showKeyboard();
        setSearchData();


        // attach setOnQueryTextListener
        // to search view defined above
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Override onQueryTextSubmit method which is call when submit query is searched
            @Override
            public boolean onQueryTextSubmit(String query) {
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
            restourentLIst.clear();
            if (restourentListResponse.getData().size() == 0) {
//                lnr_noProduct.setVisibility(View.VISIBLE);
                resturantListView.setVisibility(View.GONE);

//                restourentLIst = new ArrayList<>();
//                resturantLargeAdapter.notifyDataSetChanged();
            } else {
//                lnr_noProduct.setVisibility(View.GONE);
//                resturantListView.setVisibility(View.VISIBLE);
                restourentLIst.addAll(restourentListResponse.getData());
                resturantLargeAdapter.notifyDataSetChanged();


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
            resturantLargeAdapter.notifyDataSetChanged();

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


    @Override
    public void showLoading() {
        try {
            progressHUD.show();
        } catch (Exception f) {
        }
    }

    @Override
    public void hideLoading() {
        try {
            progressHUD.dismiss();
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
}