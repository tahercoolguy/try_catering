package com.infovass.catering.activities.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.infovass.catering.BuildConfig;
import com.infovass.catering.DM.AddonsDM;
import com.infovass.catering.DM.AppVersionRootDM;
import com.infovass.catering.DM.Order_DetailsDM.OrderDetailsRoot;
import com.infovass.catering.MyFormat.Controller.AppController;
import com.infovass.catering.MyFormat.Utils.ConnectionDetector;
import com.infovass.catering.R;
import com.infovass.catering.Utils.Helper;
import com.infovass.catering.activities.Location.view.LocationActivity;
import com.infovass.catering.activities.adapers.MyOrderAdapter;
import com.infovass.catering.activities.adapers.Order_DetailAdapter;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.utill.ProgressHUD;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class OrderDetailActivity extends AppCompatActivity {

    private Context context;
    @BindView(R.id.itemsIncludedRcv)
    RecyclerView itemsIncludedRcv;
    @BindView(R.id.backImg)
    ImageView backImg;
    @BindView(R.id.orderidTxt)
    TextView orderidTxt;
    @BindView(R.id.transectiontypeTxt)
    TextView transectiontypeTxt;
    @BindView(R.id.transectionidTxt)
    TextView transectionidTxt;
    @BindView(R.id.paymentStatusTXt)
    TextView paymentStatusTXt;
    @BindView(R.id.totalPricaTxt)
    TextView totalPricaTxt;
    @BindView(R.id.addressTxt)
    TextView addressTxt;
    @BindView(R.id.wrappedImg)
    ImageView wrappedImg;
    @BindView(R.id.ontheWayImg)
    ImageView ontheWayImg;
    @BindView(R.id.deliveredImg)
    ImageView deliveredImg;  @BindView(R.id.scrollvuew)
    NestedScrollView scrollvuew;
    String id;

    private AppController appController;
    private Dialog progress;
    private ConnectionDetector connectionDetector;
    private ProgressHUD progressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        context = getApplicationContext();
        appController = (AppController) this.getApplicationContext();
        connectionDetector = new ConnectionDetector(getApplicationContext());
        scrollvuew.setVisibility(View.GONE);
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("id");
            orderDetailPageAPI(id);
        }
     }


    @OnClick(R.id.backImg)
    public void BackImg() {
        finish();
    }

    public void setItemsIncludedRcv() {

        ArrayList<AddonsDM> addonsDMArrayList = new ArrayList<>();
        addonsDMArrayList.add(new AddonsDM(R.drawable.img, "Subs Biryani", "250.500"));
        addonsDMArrayList.add(new AddonsDM(R.drawable.img, "Subz Biryani", "250.500"));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(context, addonsDMArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        itemsIncludedRcv.setLayoutManager(linearLayoutManager);
        itemsIncludedRcv.setAdapter(myOrderAdapter);


    }

    String order_sorting, delivery_status, order_status;

    public void orderDetailPageAPI(String id) {
        if (connectionDetector.isConnectingToInternet()) {
            String token = "Bearer " + SharedPreferencesUtils.getInstance(OrderDetailActivity.this).getValue(Constants.TOKEN, "");

            appController.paServices.OrderDetails(id, token, new Callback<OrderDetailsRoot>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void success(OrderDetailsRoot orderDetailsRoot, Response response) {

                    if (orderDetailsRoot.getStatus().equalsIgnoreCase("true")) {
                        transectionidTxt.setText("" + orderDetailsRoot.getData().getTransaction_number());

                        transectiontypeTxt.setText("" + orderDetailsRoot.getData().getPayment_type());

                        orderidTxt.setText("" + orderDetailsRoot.getData().getInvoice_id());

                        paymentStatusTXt.setText("" + orderDetailsRoot.getData().getPayment_type());

                        totalPricaTxt.setText("" + orderDetailsRoot.getData().getTotal_amount() + " KWD");
                        addressTxt.setText("" + orderDetailsRoot.getData().getAddress_id());

                        order_sorting = orderDetailsRoot.getData().getOrder_sorting();
                        delivery_status = orderDetailsRoot.getData().getDelivery_status();
                        order_status = orderDetailsRoot.getData().getOrder_status();

                        if (order_sorting.equalsIgnoreCase("1")) {
                            wrappedImg.setImageResource(R.drawable.ic_circle_light_dark_red);
                        }

                        if (order_sorting.equalsIgnoreCase("1")) {
                            ontheWayImg.setImageResource(R.drawable.ic_circle_light_dark_red);
                        }

                        if (delivery_status.equalsIgnoreCase("1")) {
                            deliveredImg.setImageResource(R.drawable.ic_circle_light_dark_red);
                        }

                        Order_DetailAdapter myOrderAdapter = new Order_DetailAdapter(context, orderDetailsRoot.getData().getOrder_iteam());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                        itemsIncludedRcv.setLayoutManager(linearLayoutManager);
                        itemsIncludedRcv.setAdapter(myOrderAdapter);
                        scrollvuew.setVisibility(View.VISIBLE);

                    } else {
                        Helper.showToast(OrderDetailActivity.this, getString(R.string.something_wrong));
                    }

                }

                @Override
                public void failure(RetrofitError error) {

                    error.printStackTrace();
                }
            });

        } else {
            Toast.makeText(OrderDetailActivity.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    public void finish() {
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
        super.finish();
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
        super.onBackPressed();
    }
}