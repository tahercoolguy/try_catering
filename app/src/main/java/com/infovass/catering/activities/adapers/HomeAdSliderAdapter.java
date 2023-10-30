package com.infovass.catering.activities.adapers;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.infovass.catering.R;
import com.infovass.catering.activities.DataModel.RD_caterers_Bannerdata;
import com.infovass.catering.activities.home.view.CateringServiceDetailActivity;
import com.infovass.catering.activities.home.view.ProductDetailActivity;
import com.infovass.catering.activities.home.view.RestaurentDetailNew;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.makeramen.roundedimageview.RoundedImageView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeAdSliderAdapter extends SliderViewAdapter<HomeAdSliderAdapter.SliderViewHolder> {

    private Activity activity;
    //    private int[] images;
    public ArrayList<RD_caterers_Bannerdata> caterers_bannerdata;


    public HomeAdSliderAdapter(Activity activity, ArrayList<RD_caterers_Bannerdata> caterers_bannerdata) {
        this.activity = activity;
        this.caterers_bannerdata = caterers_bannerdata;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custum_item_home_ad, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        Glide.with(viewHolder.itemView)
                .load(caterers_bannerdata.get(position).getImage())
                .into(viewHolder.imageRViewSlide);


        viewHolder.clickLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferencesUtils.getInstance(activity.getApplicationContext()).setValue(Constants.MODE_ID, "" + modeArrayList.get(position).getId());


                String banner_type = caterers_bannerdata.get(position).getBanner_type();

                if (banner_type.equalsIgnoreCase("caterer_item")) {
                    SharedPreferencesUtils.getInstance(activity.getApplicationContext()).setValue(Constants.ITEM_ID, "" + caterers_bannerdata.get(position).getCaterer_item().getId());
                    String inputString = caterers_bannerdata.get(position).getCaterer_item().getMax_time();

                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(inputString);
                    String number = "0";
                    if (matcher.find()) {
                        String extractedNumber = matcher.group();
                        number = extractedNumber;
                    }
                    Intent intent = new Intent(activity.getApplicationContext(), ProductDetailActivity.class)
                            .putExtra("status", caterers_bannerdata.get(position).getCaterer_item().getStatus())
                            .putExtra("min_time", number);
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                } else {
//                    Intent intent = new Intent(activity.getApplicationContext(), ProductDetailActivity.class)
//                            .putExtra("status", caterers_bannerdata.get(position).getCaterer().getStatus())
//                            .putExtra("min_time", caterers_bannerdata.get(position).getCaterer().getMinimum_time());
//                    activity.startActivity(intent);
//
//                    activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                    try {
                        SharedPreferencesUtils.getInstance(activity.getApplicationContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + caterers_bannerdata.get(position).getCaterer().getId());
                         SharedPreferencesUtils.getInstance(v.getContext()).setValue(Constants.KEY_RESTOURENT_ID, "" + caterers_bannerdata.get(position).getId());
                        String restaurententID = String.valueOf(Integer.parseInt(caterers_bannerdata.get(position).getId()));
                        String restaurant_Status = caterers_bannerdata.get(position).getCaterer().getStatus();
                        Intent intent = new Intent(activity.getApplicationContext(), RestaurentDetailNew.class).putExtra("restaurententID", restaurententID)
                                .putExtra("restaurant_Status", restaurant_Status);
                        activity.startActivity(intent);
                        activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }


            }
        });
    }

    @Override
    public int getCount() {
        return caterers_bannerdata.size();
    }

    static class SliderViewHolder extends SliderViewAdapter.ViewHolder {
        RoundedImageView imageRViewSlide;
        LinearLayout clickLL;

        public SliderViewHolder(View itemView) {
            super(itemView);
            imageRViewSlide = itemView.findViewById(R.id.imageRViewSlide);
            clickLL = itemView.findViewById(R.id.clickLL);
        }
    }
}