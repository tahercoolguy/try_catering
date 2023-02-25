package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.home.model.ProductDetailResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubItemsAdapters extends RecyclerView.Adapter<SubItemsAdapters.Viewholder> {

    int row_index , popopo;
    Context context;
    SubItemsAdapters.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<String> list = new ArrayList<>();
    List<ProductDetailResponse.MealItem> meals = new ArrayList<>();
    public SubItemsAdapters(Context context , List<ProductDetailResponse.MealItem> meals , int popopo) {
        this.context = context;
        this.meals = meals;
        this.popopo = popopo;
    }

    @NonNull
    @Override
    public SubItemsAdapters.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sub_item_list, parent, false);
        SubItemsAdapters.Viewholder viewholder = new SubItemsAdapters.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubItemsAdapters.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // on the below line we are finishing
                // our current activity.
                holder.itemView.startAnimation(animation);

            }
        }, 100);

        try
        {
            if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                holder.mealNameTextView.setText(""+meals.get(position).getTitle());
            }
            if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
            {
                holder.mealNameTextView.setText(""+meals.get(position).getArabicTitle());
            }

        }catch (Exception g){}

        holder.img_addOnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClickaddOnMin(popopo, position ,holder.tv_femailServiceCount);
            }
        });

        holder.img_addOnMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClickaddOnMax( popopo, position ,holder.tv_femailServiceCount);
            }
        });


    }

    public void setOnItemClickListener(SubItemsAdapters.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.mealNameTextView)
        AppCompatTextView mealNameTextView;
        @BindView(R.id.img_addOnMax)
        AppCompatImageView img_addOnMax;
        @BindView(R.id.img_addOnMin)
        AppCompatImageView img_addOnMin;
        @BindView(R.id.tv_femailServiceCount)
        AppCompatTextView tv_femailServiceCount;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onClickaddOnMin(int popopo , int position , AppCompatTextView tv_femailServiceCount);
        void onClickaddOnMax(int popopo , int position , AppCompatTextView tv_femailServiceCount);
    }
}
