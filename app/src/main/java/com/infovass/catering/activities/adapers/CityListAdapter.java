package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.Location.model.CityList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.Viewholder> {

    Context context;
    CityListAdapter.OnItemClickListener onItemClickListener;
    List<CityList.Result> list = new ArrayList<>();
    String lastValue = "";

    public CityListAdapter(Context context, List<CityList.Result> list, String lastValue) {
        this.context = context;
        this.list = list;
        this.lastValue = lastValue;

    }

    @NonNull
    @Override
    public CityListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_city, parent, false);
        CityListAdapter.Viewholder viewholder = new CityListAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull CityListAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        if (lastValue.length() > 0) {
            if (lastValue.equalsIgnoreCase(String.valueOf(list.get(position).getName()))) {
                holder.tv_countryName.setTextColor(Color.BLACK);
            } else {
                holder.tv_countryName.setTextColor(Color.WHITE);
            }
        } else {
            holder.tv_countryName.setTextColor(Color.WHITE);
        }

        holder.tv_countryName.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position));
    }

    public void setOnItemClickListener(CityListAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_countryName)
        AppCompatTextView tv_countryName;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
