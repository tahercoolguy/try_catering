package com.infovass.catering.activities.adapers;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.home.model.ProductDetailResponse;
import com.infovass.catering.activities.home.model.RestourentModeResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import java.util.List;

public class AddMainOnFoodItemAdapters extends RecyclerView.Adapter<AddMainOnFoodItemAdapters.CustomViewHolder>{
    public Context context;
    public static List<ProductDetailResponse.Item> datalist;
    List<ProductDetailResponse.Item> datalist_filter;

    public interface OnItemClickListener {
        void onItemClick(int postion, int vertPos,Integer id);
        void onItemClickMax(int verposition,int postion,AppCompatTextView tv_femailServiceCount);
        void onItemClickMin(int verposition,int postion,AppCompatTextView tv_femailServiceCount);
    }
    public void setOnItemClickListener(AddMainOnFoodItemAdapters.OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public AddMainOnFoodItemAdapters.OnItemClickListener listener;

    public AddMainOnFoodItemAdapters(Context context, List<ProductDetailResponse.Item> arrayList) {
        this.context = context;
        datalist = arrayList;
        datalist_filter = arrayList;

    }

    @NonNull
    @Override
    public AddMainOnFoodItemAdapters.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_main_catergory, parent, false);
        AddMainOnFoodItemAdapters.CustomViewHolder viewHolder = new AddMainOnFoodItemAdapters.CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddMainOnFoodItemAdapters.CustomViewHolder holder, int position) {
        

        ProductDetailResponse.Item item = datalist_filter.get(position);
        if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
        {
            holder.txt_title.setText(item.getCategoryNameAr());
        }
        if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
            holder.txt_title.setText(item.getCategoryName());
        }

        AddOnFoodItemsAdapters adapter = new AddOnFoodItemsAdapters(context,item.getItem(),position);
        adapter.setOnItemClickListener(new AddOnFoodItemsAdapters.OnItemClickListener() {
            @Override
            public void onClickaddOnMin(int verposition, AppCompatTextView tv_femailServiceCount) {
                listener.onItemClickMin(verposition,position, tv_femailServiceCount);
            }

            @Override
            public void onClickaddOnMax(int verposition, AppCompatTextView tv_femailServiceCount) {
                listener.onItemClickMax(verposition,position, tv_femailServiceCount);
            }
        });
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);


        holder.mrecylerView.setLayoutManager(linearLayoutManager);
        holder.mrecylerView.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return datalist_filter.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView txt_title;
        RecyclerView mrecylerView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.tv_title);
            mrecylerView = itemView.findViewById(R.id.rv_list);

        }
    }
}
