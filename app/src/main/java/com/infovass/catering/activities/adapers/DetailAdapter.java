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
import com.infovass.catering.activities.home.model.RestourentDetailResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.Viewholder> {

    int row_index;
    Context context;
    DetailAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<String> list = new ArrayList<>();
    List<RestourentDetailResponse.Mode> modes = new ArrayList<>();
    public DetailAdapter(List<RestourentDetailResponse.Mode> modes , Context context) {
        this.context = context;
        this.modes = modes;
    }

    @NonNull
    @Override
    public DetailAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_horizontal_tab_item, parent, false);
        DetailAdapter.Viewholder viewholder = new DetailAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {


        if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
        {
            holder.custom_tab_textView.setText(modes.get(position).getArabicTitle());
        }

        if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en"))
        {
            holder.custom_tab_textView.setText(modes.get(position).getName());
        }

        if(row_index==position){
            holder.detail_item_linearLayout.setBackgroundResource(R.drawable.slide_background);
            holder.custom_tab_textView.setTextColor(Color.parseColor("#ffffff"));
        }
        else
        {
            holder.detail_item_linearLayout.setBackgroundResource(R.drawable.detail_unselected_bacground_item);
            holder.custom_tab_textView.setTextColor(Color.parseColor("#000000"));
        }

        try {
//            Picasso.get().load(""+modes.get(position).getImagePath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(holder.img_logo);
            Picasso.get().load(""+modes.get(position).getImagePath()).into(holder.img_logo);
        }
        catch (Exception ex)
        { }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                onItemClickListener.onItemClick(position ,holder.custom_tab_textView,holder.detail_item_linearLayout );
            }
        });
    }

    public void setOnItemClickListener(DetailAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return modes.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.custom_tab_textView)
        TextView custom_tab_textView;
        @BindView(R.id.detail_item_linearLayout)
        LinearLayout detail_item_linearLayout;

        @BindView(R.id.img_logo)
        CircularImageView img_logo;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position , TextView custom_tab_textView , LinearLayout detail_item_linearLayout);
    }
}