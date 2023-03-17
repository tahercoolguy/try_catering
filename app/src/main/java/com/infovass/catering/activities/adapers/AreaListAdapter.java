package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.Location.model.AreaList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AreaListAdapter extends RecyclerView.Adapter<AreaListAdapter.Viewholder> {

    Context context;
    AreaListAdapter.OnItemClickListener onItemClickListener;
    List<AreaList.Result> list = new ArrayList<>();
    String lastValue = "";

    public AreaListAdapter(Context context, List<AreaList.Result> list, String lastValue) {
        this.context = context;
        this.list = list;
        this.lastValue = lastValue;

    }

    @NonNull
    @Override
    public AreaListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_city, parent, false);
        AreaListAdapter.Viewholder viewholder = new AreaListAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull AreaListAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        

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

    public void setOnItemClickListener(AreaListAdapter.OnItemClickListener onItemClickListener) {
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

