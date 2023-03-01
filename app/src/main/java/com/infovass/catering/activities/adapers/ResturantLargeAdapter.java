package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.home.model.RestourentListResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.github.siyamed.shapeimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResturantLargeAdapter extends RecyclerView.Adapter<ResturantLargeAdapter.Viewholder> {

    Context context;
    ResturantLargeAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<RestourentListResponse.Datum> restourentLIst = new ArrayList<>();

    public ResturantLargeAdapter(Context context , List<RestourentListResponse.Datum> restourentLIst) {
        this.context = context;
        this.restourentLIst = restourentLIst;
    }

    @NonNull
    @Override
    public ResturantLargeAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.restourent_items, parent, false);
        ResturantLargeAdapter.Viewholder viewholder = new ResturantLargeAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResturantLargeAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // on the below line we are finishing
                // our current activity.
                holder.itemView.startAnimation(animation);

            }
        }, 100);

        try {
            if(restourentLIst.get(position).getCoverImages()!=null && restourentLIst.get(position).getCoverImages().size()>0)
                Picasso.get().load(restourentLIst.get(position).getCoverImages().get(0).getCoverImagePath())
                        .placeholder(R.drawable.logo_rec).into(holder.resturantImageView);
            else
                Picasso.get().load(restourentLIst.get(position).getCoverImagePath()).into(holder.resturantImageView);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        try {

            Picasso.get().load(restourentLIst.get(position).getModes().get(0).getImagePath()).into(holder.img_delevery);
        }
        catch (Exception ex)
        {}

        try {
            Picasso.get().load(""+restourentLIst.get(position).getModes().get(1).getImagePath()).into(holder.img_table);
        }
        catch (Exception ex)
        {}

        try {
            if (Objects.equals(restourentLIst.get(position).getRestaurantStatus(), "1")){
               // Picasso.get().load(""+restourentLIst.get(position).getModes().get(2).getImagePath()).error(R.drawable.add).placeholder(R.drawable.ic_loader).into(holder.img_catering);
                holder.img_catering.setBackgroundResource(R.drawable.busyicon);
            }
            else {
                Picasso.get().load(""+restourentLIst.get(position).getModes().get(2).getImagePath()).into(holder.img_catering);
            }
           // Picasso.get().load(""+restourentLIst.get(position).getModes().get(2).getImagePath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(holder.img_catering);
        }
        catch (Exception ex)
        {}

        try {
            holder.simpleRatingBar.setRating(Float.parseFloat(""+restourentLIst.get(position).getRating()));
        }
        catch (Exception ex)
        {}

        if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
        {
            Log.i("UUUIUIU" , "UIUIUIU");
            holder.resNameTextView.setText(""+restourentLIst.get(position).getArabicName());
            holder.resNotesTextView.setText(""+restourentLIst.get(position).getArabicDetail());
        }

        if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en"))
        {
            Log.i("UUUIUIU" , ""+restourentLIst.get(position).getName());
            holder.resNameTextView.setText(""+restourentLIst.get(position).getName());
            holder.resNotesTextView.setText(""+restourentLIst.get(position).getDetail());
        }

        int Restaurant_Status=restourentLIst.get(position).getRestaurantStatus();
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position,Restaurant_Status));
    }

    public void setOnItemClickListener(ResturantLargeAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return restourentLIst.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.resturantImageView)
        RoundedImageView resturantImageView;
        @BindView(R.id.resNameTextView)
        AppCompatTextView resNameTextView;
        @BindView(R.id.resNotesTextView)
        AppCompatTextView resNotesTextView;

        @BindView(R.id.img_delevery)
        CircularImageView img_delevery;
        @BindView(R.id.img_table)
        CircularImageView img_table;
        @BindView(R.id.img_catering)
        CircularImageView img_catering;

        @BindView(R.id.simpleRatingBar)
        RatingBar simpleRatingBar;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position,int Restaurant_Status);
    }
}





