package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestourentcategoriesAdapter extends RecyclerView.Adapter<RestourentcategoriesAdapter.Viewholder> {

    int row_index;
    Context context;
    RestourentcategoriesAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<String> list = new ArrayList<>();
    public RestourentcategoriesAdapter(List<String> list , Context context) {
        this.context = context;
        this.list = list;
        row_index=0;
    }

    @NonNull
    @Override
    public RestourentcategoriesAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.restourent_detail_items, parent, false);
        RestourentcategoriesAdapter.Viewholder viewholder = new RestourentcategoriesAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestourentcategoriesAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        holder.custom_tab_textView.setText(list.get(position));

        if(row_index==position){
            holder.detail_item_linearLayout.setBackgroundResource(R.drawable.slide_background);
            holder.custom_tab_textView.setTextColor(Color.parseColor("#ffffff"));
        }
        else
        {
            holder.detail_item_linearLayout.setBackgroundResource(R.drawable.detail_unselected_bacground_item);
            holder.custom_tab_textView.setTextColor(Color.parseColor("#000000"));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                onItemClickListener.onItemClick(position ,holder.custom_tab_textView,holder.detail_item_linearLayout );
            }
        });
    }

    public void setOnItemClickListener(RestourentcategoriesAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.custom_tab_textView)
        TextView custom_tab_textView;
        @BindView(R.id.detail_item_linearLayout)
        LinearLayout detail_item_linearLayout;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position , TextView custom_tab_textView , LinearLayout detail_item_linearLayout);
    }
}