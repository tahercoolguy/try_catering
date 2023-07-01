package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.MyFormat.MyDM.Item_;
import com.infovass.catering.R;
import com.infovass.catering.activities.home.model.RestourentModeResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


class ResturentMenuNewAdapter extends RecyclerView.Adapter<ResturentMenuNewAdapter.Viewholder> {

    int row_index;
    Context context;
    int verPos = 0;
    ResturentMenuNewAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    ArrayList<Item_> items = new ArrayList<>();

    public ResturentMenuNewAdapter(Context context, ArrayList<Item_> items, int verPos) {
        this.context = context;
        this.items = items;
        this.verPos = verPos;
    }

    @NonNull
    @Override
    public ResturentMenuNewAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.resturant_menu_item, parent, false);
        ResturentMenuNewAdapter.Viewholder viewholder = new ResturentMenuNewAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResturentMenuNewAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        

        try {
            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
                holder.mealNameTextView.setText("" + items.get(position).getArabic_item_name());
                holder.mealTagTextView.setText(Html.fromHtml("" + items.get(position).getArabic_item_short_description()));
                holder.tv_persions.setText("ل " + items.get(position).getItem_serving_capacity() + " الأشخاص");
                holder.priceTextView.setText("" + items.get(position).getItem_cost_per_serve() + " د.ك");
            }

            if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
                holder.mealNameTextView.setText("" + items.get(position).getItem_name());
                holder.mealTagTextView.setText(Html.fromHtml("" + items.get(position).getItem_short_description()));
                holder.tv_persions.setText("For " + items.get(position).getItem_serving_capacity() + " Persons");
                holder.priceTextView.setText("" + items.get(position).getItem_cost_per_serve() + " KWD");
            }

        } catch (Exception f) {
        }

        try {
            Item_ item = items.get(position);
            if (item != null && item.getImages() != null && item.getImages().size()!=0) {
                Picasso.get().load(item.getImages().get(0).getItem_logo_path()).error(R.drawable.gradient).placeholder(R.drawable.gradient).into(holder.menu_image);
            } else {
                if (item != null && item.getItem_logo_path() != null)
                    Picasso.get().load(item.getItem_logo_path()).error(R.drawable.gradient).placeholder(R.drawable.gradient).into(holder.menu_image);
 //                  Picasso.get().load(items.get(0).getItemLogoPath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(holder.menu_image);

            }
        } catch (Exception f) {
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position, verPos, Integer.valueOf(items.get(position).getId()));
            }
        });
    }

    public void setOnItemClickListener(ResturentMenuNewAdapter.OnItemClickListener onItemClickListener) {
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
