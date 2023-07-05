package com.infovass.catering.activities.adapers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.infovass.catering.Controller.AppController;
import com.infovass.catering.R;
import com.infovass.catering.activities.DataModel.RD_Image;
import com.makeramen.roundedimageview.RoundedImageView;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CateringSDSliderAdapter extends SliderViewAdapter<CateringSDSliderAdapter.SliderViewHolder> {

    private Activity activity;
    //    private int[] images;
    public ArrayList<RD_Image> caterers_bannerdata;
    AppController appController;


    public CateringSDSliderAdapter(Activity activity, ArrayList<RD_Image> caterers_bannerdata) {
        this.activity = activity;
        this.caterers_bannerdata = caterers_bannerdata;

    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.csd_image, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {

        if (caterers_bannerdata.get(position).getCover_image_path() != null) {
            Glide.with(viewHolder.itemView)
                    .load(caterers_bannerdata.get(position).getCover_image_path())
                    .into(viewHolder.imageRViewSlide);
        } else {
            Glide.with(viewHolder.itemView)
                    .load(caterers_bannerdata.get(position).getItem_logo_path())
                    .into(viewHolder.imageRViewSlide);
        }

//
//        Picasso.get().load(AppController.CATERERCOVER+caterers_bannerdata.get(position).getImage()).placeholder(R.drawable.gradient).into(viewHolder.imageRViewSlide);
    }

    @Override
    public int getCount() {
        return caterers_bannerdata.size();
    }

    static class SliderViewHolder extends ViewHolder {
        RoundedImageView imageRViewSlide;
        LinearLayout clickLL;

        public SliderViewHolder(View itemView) {
            super(itemView);
            imageRViewSlide = itemView.findViewById(R.id.imageRViewSlide);
            clickLL = itemView.findViewById(R.id.clickLL);
        }
    }
}