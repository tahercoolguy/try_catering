package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.fav.model.FavListResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.github.siyamed.shapeimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.Viewholder> {

    int row_index;
    Context context;
    FavAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<FavListResponse.Datum> list = new ArrayList<>();
    public FavAdapter(Context context , List<FavListResponse.Datum> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FavAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fev_menu_item, parent, false);
        FavAdapter.Viewholder viewholder = new FavAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {

        try {
            Picasso.get().load(""+list.get(position).getCaterer().getCoverImagePath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(holder.image_product);
        }
        catch (Exception ex)
        { }

        if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
        {
            holder.mealNameTextView.setText(""+list.get(position).getCaterer().getArabicName());
            holder.tv_for_persons.setText(""+list.get(position).getCaterer().getArabicDetail());
            holder.userTextTimeView.setText(""+list.get(position).getCaterer().getCreatedAt());
        }

        if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en"))
        {
            holder.mealNameTextView.setText(""+list.get(position).getCaterer().getName());
            holder.tv_for_persons.setText(""+list.get(position).getCaterer().getDetail());
            holder.userTextTimeView.setText(""+list.get(position).getCaterer().getCreatedAt());
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   onItemClickListener.onItemClick(position ,holder.custom_tab_textView,holder.detail_item_linearLayout );
            }
        });
    }

    public void setOnItemClickListener(FavAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_product)
        RoundedImageView image_product;
        @BindView(R.id.mealNameTextView)
        AppCompatTextView mealNameTextView;
        @BindView(R.id.tv_for_persons)
        AppCompatTextView tv_for_persons;
        @BindView(R.id.userTextTimeView)
        AppCompatTextView userTextTimeView;

        public Viewholder(View itemView) {
            super(itemView);
             ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position , TextView custom_tab_textView , LinearLayout detail_item_linearLayout);
    }
}
