package com.infovass.catering.activities.adapers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.infovass.catering.R;
import com.infovass.catering.activities.DataModel.RD_caterers_Bannerdata;
import com.makeramen.roundedimageview.RoundedImageView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

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
    }

    @Override
    public int getCount() {
        return caterers_bannerdata.size();
    }

    static class SliderViewHolder extends SliderViewAdapter.ViewHolder {
        RoundedImageView imageRViewSlide;

        public SliderViewHolder(View itemView) {
            super(itemView);
            imageRViewSlide = itemView.findViewById(R.id.imageRViewSlide);
        }
    }
}