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
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
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
    int selectedposition;

    public ResturantLargeAdapter(Context context, List<RestourentListResponse.Datum> restourentLIst) {
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


        RestourentListResponse.Datum resRDAta = restourentLIst.get(position);

        try {
            if (resRDAta.getCoverImages() != null && resRDAta.getCoverImages().size() > 0)
                Picasso.get().load(resRDAta.getCoverImages().get(0).getCoverImagePath()).into(holder.resturantImageView);
            else
                Picasso.get().load(resRDAta.getCoverImagePath()).into(holder.resturantImageView);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        int Restaurant_Status = resRDAta.getRestaurantStatus();
        String resModeid = String.valueOf(resRDAta.getModes().get(0).getId());
        String resStatus = String.valueOf(resRDAta.getRestaurantStatus());
        try {


//
//                 try{
//                     for (RestourentListResponse.Datum daliveryModeCheck : restourentLIst)
//                     {
//
//                         for (int i = 0; i < daliveryModeCheck.getModes().size(); i++) {
//                             if (daliveryModeCheck.getModes().get(i).getId()==2){
//                                 holder.img_delevery.setImageResource(R.drawable.ic_deleivery);
//                             }
//
//                         }
//
//
//                     }
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                 }
//
//
//                try{
//                    for (RestourentListResponse.Datum cateringModeCheck : restourentLIst)
//                    {
//
//                        for (int i = 0; i < cateringModeCheck.getModes().size(); i++) {
//                            if (cateringModeCheck.getModes().get(i).getId()==1){
//                                holder.img_catering.setImageResource(R.drawable.ic_catering);
//                            }
//
//                        }
//
//
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                try{
//                    for (RestourentListResponse.Datum bothModeCheck : restourentLIst)
//                    {
//
//                        for (int i = 0; i < bothModeCheck.getModes().size(); i++) {
//                            if (bothModeCheck.getModes().get(i).getId()==1 && bothModeCheck.getModes().get(i).getId()==2){
//                                holder.img_catering.setImageResource(R.drawable.ic_catering);
//                                holder.img_delevery.setImageResource(R.drawable.ic_deleivery);
//                            }
//
//                        }
//
//
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

//            for (int i = 0; i < restourentLIst.size(); i++) {
//                restourentLIst.get(i).getModes().get(0).getId().equals(1);
//                if (restourentLIst.get(i).getModes().get(0).getId().equals(1)) {
//                    holder.img_catering.setImageResource(R.drawable.ic_catering);
//                }
//                if (restourentLIst.get(i).getModes().get(0).getId().equals(2)) {
//                    holder.img_delevery.setImageResource(R.drawable.ic_deleivery);
//                }
//                if (restourentLIst.get(i).getRestaurantStatus().equals(1)) {
//                    holder.img_table.setImageResource(R.drawable.busyicon);
//                }
//            }


//            if (resModeid.equalsIgnoreCase("2")) {
//                holder.img_delevery.setVisibility(View.VISIBLE);
//                holder.img_delevery.setImageResource(R.drawable.ic_deleivery);
//
//            } else {
//                holder.img_delevery.setVisibility(View.INVISIBLE);
//            }
//            if (resModeid.equalsIgnoreCase("1")) {
//                holder.img_catering.setImageResource(R.drawable.ic_catering);
//                holder.img_catering.setVisibility(View.VISIBLE);
//
//            } else {
//                holder.img_catering.setVisibility(View.INVISIBLE);
//            }
            if (resStatus.equalsIgnoreCase("1")) {
//                holder.img_table.setImageResource(R.drawable.busyicon);
                holder.busyCV.setVisibility(View.VISIBLE);
            } else {
                holder.busyCV.setVisibility(View.INVISIBLE);
            }


//            if (resModeid.equalsIgnoreCase("2")
//                    && resModeid.equalsIgnoreCase("1")) {
//                holder.img_delevery.setImageResource(R.drawable.ic_deleivery);
//                holder.img_catering.setImageResource(R.drawable.ic_catering);
//            }

//            Picasso.get().load(restourentLIst.get(position).getModes().get(0).getImagePath()).into(holder.img_delevery);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        try {
//            Picasso.get().load(""+restourentLIst.get(position).getModes().get(1).getImagePath()).into(holder.img_table);
//        }
//        catch (Exception ex)
//        {}
//
//        try {
//            if (Objects.equals(restourentLIst.get(position).getRestaurantStatus(), "1")){
//               // Picasso.get().load(""+restourentLIst.get(position).getModes().get(2).getImagePath()).error(R.drawable.add).placeholder(R.drawable.ic_loader).into(holder.img_catering);
//                holder.img_catering.setBackgroundResource(R.drawable.busyicon);
//            }
//            else {
//                Picasso.get().load(""+restourentLIst.get(position).getModes().get(2).getImagePath()).into(holder.img_catering);
//            }
//           // Picasso.get().load(""+restourentLIst.get(position).getModes().get(2).getImagePath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(holder.img_catering);
//        }
//        catch (Exception ex)
//        {}

        try {
            holder.simpleRatingBar.setRating(Float.parseFloat("" + restourentLIst.get(position).getRating()));
        } catch (Exception ex) {
        }

        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
            Log.i("UUUIUIU", "UIUIUIU");
            holder.resNameTextView.setText("" + restourentLIst.get(position).getArabicName());
            holder.resNotesTextView.setText("" + restourentLIst.get(position).getArabicDetail());
            holder.busyTxt.setText("مشغول");
        }

        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
            Log.i("UUUIUIU", "" + restourentLIst.get(position).getName());
            holder.resNameTextView.setText("" + restourentLIst.get(position).getName());
            holder.resNotesTextView.setText("" + restourentLIst.get(position).getDetail());
            holder.busyTxt.setText(context.getString(R.string.busy));

        }


//        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position, Restaurant_Status));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedposition = position;
                onItemClickListener.onItemClick(position, selectedposition, Restaurant_Status, restourentLIst);
            }
        });
    }

    public void setOnItemClickListener(ResturantLargeAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<RestourentListResponse.Datum> filterlist) {
        // below line is to add our filtered
        // list in our course array list.
        restourentLIst = filterlist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
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
        ImageView img_table;

        @BindView(R.id.img_catering)
        CircularImageView img_catering;

        @BindView(R.id.simpleRatingBar)
        RatingBar simpleRatingBar;

        @BindView(R.id.busyCV)
        CardView busyCV; @BindView(R.id.busyTxt)
        TextView busyTxt;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, int selectedposition, int Restaurant_Status, List<RestourentListResponse.Datum> restourentLIst);
    }
}





