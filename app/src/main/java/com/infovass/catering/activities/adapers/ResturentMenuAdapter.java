package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.home.model.RestourentModeResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.github.siyamed.shapeimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


class ResturentMenuAdapter extends RecyclerView.Adapter<ResturentMenuAdapter.Viewholder> {

    int row_index;
    Context context;
    int verPos = 0;
    ResturentMenuAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<RestourentModeResponse.Item__1> items = new ArrayList<>();

    public ResturentMenuAdapter(Context context, List<RestourentModeResponse.Item__1> items, int verPos) {
        this.context = context;
        this.items = items;
        this.verPos = verPos;
    }

    @NonNull
    @Override
    public ResturentMenuAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.resturant_menu_item, parent, false);
        ResturentMenuAdapter.Viewholder viewholder = new ResturentMenuAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResturentMenuAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        try {
            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                holder.mealNameTextView.setText("" + items.get(position).getArabicItemName());
                holder.mealTagTextView.setText(Html.fromHtml("" + items.get(position).getArabicItemShortDescription()));
                holder.tv_persions.setText("For " + items.get(position).getItemServingCapacity() + " Persons");
                holder.priceTextView.setText("" + items.get(position).getItemCostPerServe() + " KWD");
            }

            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                holder.mealNameTextView.setText("" + items.get(position).getItemName());
                holder.mealTagTextView.setText(Html.fromHtml("" + items.get(position).getItemShortDescription()));
                holder.tv_persions.setText("For " + items.get(position).getItemServingCapacity() + " Persons");
                holder.priceTextView.setText("" + items.get(position).getItemCostPerServe() + " KWD");
            }

        } catch (Exception f) {
        }

        try {
            RestourentModeResponse.Item__1 item = items.get(position);
            if (item != null && item.getImages() != null && item.getImages().size()!=0) {
                Picasso.get().load(item.getImages().get(0).getItem_logo_path()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(holder.menu_image);
            } else {
                if (item != null && item.getItemLogoPath() != null)
                    Picasso.get().load(item.getItemLogoPath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(holder.menu_image);
 //                  Picasso.get().load(items.get(0).getItemLogoPath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(holder.menu_image);

            }
        } catch (Exception f) {
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position, verPos, items.get(position).getId());
            }
        });
    }

    public void setOnItemClickListener(ResturentMenuAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.menu_image)
        RoundedImageView menu_image;
        @BindView(R.id.mealNameTextView)
        AppCompatTextView mealNameTextView;
        @BindView(R.id.mealTagTextView)
        AppCompatTextView mealTagTextView;
        @BindView(R.id.tv_persions)
        AppCompatTextView tv_persions;
        @BindView(R.id.priceTextView)
        AppCompatTextView priceTextView;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, int verPos, Integer id);
    }
}
