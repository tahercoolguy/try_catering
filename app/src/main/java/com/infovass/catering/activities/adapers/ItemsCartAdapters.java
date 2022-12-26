package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.cart.model.CartResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemsCartAdapters extends RecyclerView.Adapter<ItemsCartAdapters.Viewholder> {

    Context context;
    ItemsCartAdapters.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<CartResponse.Data.MainItem.Meal> meals = new ArrayList<>();
    public ItemsCartAdapters(Context context , List<CartResponse.Data.MainItem.Meal> meals) {
        this.context = context;
        this.meals = meals;
    }

    @NonNull
    @Override
    public ItemsCartAdapters.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_cart_list, parent, false);
        ItemsCartAdapters.Viewholder viewholder = new ItemsCartAdapters.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsCartAdapters.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        try
        {
            if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                holder.tv_categorieName.setText(""+meals.get(position).getMealCategoryTitle());
                holder.tv_quantity.setText("Quantity "+meals.get(position).getQuantity());
                holder.tv_productName.setText("Product : "+meals.get(position).getItemTitle());
            }
            if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
            {
                holder.tv_categorieName.setText(meals.get(position).getMealCategoryArabicTitle());
                holder.tv_quantity.setText("Quantity "+meals.get(position).getQuantity());
                holder.tv_productName.setText("Product : "+meals.get(position).getItemArabicTitle());
            }

        }catch (Exception g){}
    }

    public void setOnItemClickListener(ItemsCartAdapters.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_categorieName)
        AppCompatTextView tv_categorieName;
        @BindView(R.id.tv_quantity)
        AppCompatTextView tv_quantity;
        @BindView(R.id.tv_productName)
        AppCompatTextView tv_productName;


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
