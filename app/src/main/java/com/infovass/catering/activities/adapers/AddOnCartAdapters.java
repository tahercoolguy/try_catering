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
import com.infovass.catering.activities.cart.model.CartResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddOnCartAdapters extends RecyclerView.Adapter<AddOnCartAdapters.Viewholder> {

    int row_index;
    Context context;
    AddOnCartAdapters.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<CartResponse.Data.MainItem.AddonIteam> addonItems = new ArrayList<>();
    public AddOnCartAdapters(Context context , List<CartResponse.Data.MainItem.AddonIteam> addonItems) {
        this.context = context;
        this.addonItems = addonItems;
    }

    @NonNull
    @Override
    public AddOnCartAdapters.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.addon_cart_item_list, parent, false);
        AddOnCartAdapters.Viewholder viewholder = new AddOnCartAdapters.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddOnCartAdapters.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
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
            holder.mealNameTextView.setText(addonItems.get(position).getItem().getTitle());
            holder.priceTextView.setText(""+addonItems.get(position).getPrice()+" KWD");
        }catch (Exception g){}

        holder.img_addOnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClickaddOnMin(position ,holder.tv_femailServiceCount);
            }
        });

        holder.img_addOnMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClickaddOnMax(position ,holder.tv_femailServiceCount);
            }
        });
    }

    public void setOnItemClickListener(AddOnCartAdapters.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return addonItems.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.mealNameTextView)
        AppCompatTextView mealNameTextView;
        @BindView(R.id.priceTextView)
        AppCompatTextView priceTextView;
        @BindView(R.id.tv_femailServiceCount)
        AppCompatTextView tv_femailServiceCount;
        @BindView(R.id.img_addOnMin)
        AppCompatImageView img_addOnMin;
        @BindView(R.id.img_addOnMax)
        AppCompatImageView img_addOnMax;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onClickaddOnMin(int position , AppCompatTextView tv_femailServiceCount);
        void onClickaddOnMax(int position , AppCompatTextView tv_femailServiceCount);
    }
}
