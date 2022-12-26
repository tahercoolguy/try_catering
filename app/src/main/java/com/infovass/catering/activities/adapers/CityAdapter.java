package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.Location.model.CityList;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.Viewholder> {

    List<CityList.Result> list = new ArrayList<>();
    Context context;
    CityAdapter.OnItemClickListener onItemClickListener;
    public CityAdapter(Context context , List<CityList.Result> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CityAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.city_items, parent, false);
        CityAdapter.Viewholder viewholder = new CityAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
        {
            holder.tv_city.setText(list.get(position).getArabicName());
        }

        if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en"))
        {
            holder.tv_city.setText(list.get(position).getName());
        }

        if(list.get(position).isSelected())
        {
            holder.lnr_card.setBackgroundResource(R.drawable.selected_city);
            holder.tv_city.setTextColor(Color.GREEN);
            holder.img_circle.setBackgroundResource(R.drawable.ic_done);
        }
        else
        {
            holder.lnr_card.setBackgroundResource(R.drawable.border_layout);
            holder.tv_city.setTextColor(Color.BLACK);
            holder.img_circle.setBackgroundResource(R.drawable.ic_dot);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    public void setOnItemClickListener(CityAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_city)
        AppCompatTextView tv_city;
        @BindView(R.id.lnr_card)
        RelativeLayout lnr_card;
        @BindView(R.id.img_circle)
        AppCompatImageView img_circle;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
