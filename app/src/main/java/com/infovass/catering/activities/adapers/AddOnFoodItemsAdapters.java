package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class AddOnFoodItemsAdapters extends RecyclerView.Adapter<AddOnFoodItemsAdapters.Viewholder> {

    int row_index;
    Context context;
    AddOnFoodItemsAdapters.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<String> list = new ArrayList<>();
    List<ProductDetailResponse.Item__1> addons = new ArrayList<>();
    public AddOnFoodItemsAdapters(Context context , List<ProductDetailResponse.Item__1> addons, int verPos) {
        this.context = context;
        this.addons = addons;
    }

    @NonNull
    @Override
    public AddOnFoodItemsAdapters.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.addon_item_list, parent, false);
        AddOnFoodItemsAdapters.Viewholder viewholder = new AddOnFoodItemsAdapters.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddOnFoodItemsAdapters.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        try
        {
            if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                holder.mealNameTextView.setText(addons.get(position).getTitle());
                holder.priceTextView.setText(""+addons.get(position).getPrice()+" KWD");
            }
            if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
            {
                holder.mealNameTextView.setText(addons.get(position).getArabicTitle());
                holder.priceTextView.setText(""+addons.get(position).getPrice()+" KWD");
            }

        }catch (Exception g){}


    }

    public void setOnItemClickListener(AddOnFoodItemsAdapters.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return addons.size();
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
            img_addOnMin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onClickaddOnMin(getAdapterPosition() ,tv_femailServiceCount);
                }
            });

            img_addOnMax.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Log.d("ss", String.valueOf(addons.get(position)));
                    onItemClickListener.onClickaddOnMax(getAdapterPosition() ,tv_femailServiceCount);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClickaddOnMin(int position , AppCompatTextView tv_femailServiceCount);
        void onClickaddOnMax(int position , AppCompatTextView tv_femailServiceCount);
    }
}

