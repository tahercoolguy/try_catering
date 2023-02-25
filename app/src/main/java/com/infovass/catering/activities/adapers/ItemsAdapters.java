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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.home.model.ProductDetailResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemsAdapters extends RecyclerView.Adapter<ItemsAdapters.Viewholder> {

    int postin ;
    int[] array;
    SubItemsAdapters subItemsAdapters;
    Context context;
    ItemsAdapters.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<ProductDetailResponse.Meal> meals = new ArrayList<>();
    public ItemsAdapters(Context context , List<ProductDetailResponse.Meal> meals) {
        this.context = context;
        this.meals = meals;
    }

    @NonNull
    @Override
    public ItemsAdapters.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        ItemsAdapters.Viewholder viewholder = new ItemsAdapters.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapters.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
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
            array = new int[meals.size()];
            if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                holder.tv_categorieName.setText(meals.get(position).getMealTypeTitle());
                holder.tv_choose.setText("Choose Only "+meals.get(position).getNumOfTaken());
            }
            if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
            {
                holder.tv_categorieName.setText(meals.get(position).getMealTypeArabicTitle());
                holder.tv_choose.setText("Choose Only "+meals.get(position).getNumOfTaken());
            }

        }catch (Exception g){}

        subItemsAdapters = new SubItemsAdapters(context , meals.get(position).getMealItems() ,position);
        holder.rv_Items.setHasFixedSize(true);
        holder.rv_Items.setLayoutManager(new LinearLayoutManager(context));
        holder.rv_Items.setAdapter(subItemsAdapters);
        subItemsAdapters.setOnItemClickListener(new SubItemsAdapters.OnItemClickListener() {
            @Override
            public void onClickaddOnMin(int popopo , int verposition, AppCompatTextView tv_femailServiceCount) {
                try {
                    if (tv_femailServiceCount.getText().toString().equalsIgnoreCase("0")) {
                    }
                    else
                    {
                        array[popopo] =array[popopo]-1;
                    }
                    int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
                    itemCount = itemCount - 1;
                    if (itemCount<0) {
                        Toast.makeText(context, "Cannot set item count -ve.", Toast.LENGTH_SHORT).show();
                    } else {
                        tv_femailServiceCount.setText("" + itemCount);
                    }
                    onItemClickListener.onClickaddOnMin(verposition,position,tv_femailServiceCount);
                } catch (Exception g) { }
            }

            @Override
            public void onClickaddOnMax(int popopo , int verposition, AppCompatTextView tv_femailServiceCount) {
                try {
                    int chooseValue = Integer.parseInt(meals.get(popopo).getNumOfTaken());
                   // max_value = Integer.parseInt(tv_femailServiceCount.getText().toString());
                    Log.i("Arrrr", ""+array[popopo]);
                    if(array[popopo]>=chooseValue)
                    {
                        Log.i("yuyu" , "yuy");
                        Toast.makeText(context , "You can choose only "+chooseValue+" items.",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        array[popopo] =array[popopo]+1;
                        Log.i("yuyu" , "NJNJ");
                        int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
                        itemCount = itemCount + 1;
                        tv_femailServiceCount.setText("" + itemCount);
                    }
//                    onItemClickListener.onClickaddOnMax(position,tv_femailServiceCount);
                    onItemClickListener.onClickaddOnMax(verposition,position,tv_femailServiceCount);
                } catch (Exception g) {
                    Log.i("error", ""+g.getMessage());
                }
            }

        });

    }

    public void setOnItemClickListener(ItemsAdapters.OnItemClickListener onItemClickListener) {
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
        @BindView(R.id.tv_choose)
        AppCompatTextView tv_choose;
        @BindView(R.id.rv_Items)
        RecyclerView rv_Items;


        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onClickaddOnMin(int verposition,int position , AppCompatTextView tv_femailServiceCount);
        void onClickaddOnMax(int verposition,int position , AppCompatTextView tv_femailServiceCount);
    }
}


