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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.github.siyamed.shapeimageview.RoundedImageView;
import com.infovass.catering.R;
import com.infovass.catering.activities.home.model.RestourentListResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResturantSearchAdapter extends RecyclerView.Adapter<ResturantSearchAdapter.Viewholder> {

    Context context;
    ResturantSearchAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<RestourentListResponse.Datum> restourentLIst = new ArrayList<>();

    public ResturantSearchAdapter(Context context, List<RestourentListResponse.Datum> restourentLIst) {
        this.context = context;
        this.restourentLIst = restourentLIst;
    }

    @NonNull
    @Override
    public ResturantSearchAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custum_item_search_restaurent, parent, false);
        ResturantSearchAdapter.Viewholder viewholder = new ResturantSearchAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResturantSearchAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // on the below line we are finishing
                // our current activity.
                holder.itemView.startAnimation(animation);

            }
        }, 100);


        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
            Log.i("UUUIUIU", "UIUIUIU");
            holder.tittleTxt.setText("" + restourentLIst.get(position).getArabicName());
        } else {
            holder.tittleTxt.setText("" + restourentLIst.get(position).getName());
        }


        int Restaurant_Status = restourentLIst.get(position).getRestaurantStatus();
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position, Restaurant_Status));
    }

    public void setOnItemClickListener(ResturantSearchAdapter.OnItemClickListener onItemClickListener) {
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
        @BindView(R.id.tittleTxt)
        TextView tittleTxt;

        @BindView(R.id.resid)
        TextView resid;

        @BindView(R.id.resStatus)
        TextView resStatus;


        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, int Restaurant_Status);
    }
}





