package com.infovass.catering.activities.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.infovass.catering.DM.AddonsDM;
import com.infovass.catering.R;
import com.infovass.catering.activities.adapers.MyOrderAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailActivity extends AppCompatActivity {

    private Context context;
    @BindView(R.id.itemsIncludedRcv)
    RecyclerView itemsIncludedRcv;
    @BindView(R.id.backImg)
    ImageView backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        context = getApplicationContext();
        setItemsIncludedRcv();
    }

    @OnClick(R.id.backImg)
    public void BackImg(){
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