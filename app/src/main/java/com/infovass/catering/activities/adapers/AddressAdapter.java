package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.profile.model.AddressResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.Viewholder> {

    int row_index;
    Context context;
    AddressAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<AddressResponse.Datum> list = new ArrayList<>();

    public AddressAdapter(Context context, List<AddressResponse.Datum> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AddressAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.address_new_item, parent, false);
        AddressAdapter.Viewholder viewholder = new AddressAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {

        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
            holder.tv_addressType.setText(list.get(position).getAddressType());
            holder.tv_city.setText(list.get(position).getLandmark());
            holder.addressTextView.setText(list.get(position).getAddress());
        }

        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
            holder.tv_addressType.setText(list.get(position).getAddressType());
            holder.tv_city.setText(list.get(position).getLandmark());
            holder.addressTextView.setText(list.get(position).getAddress());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //    row_index = position;
                onItemClickListener.onItemClick(position);
            }
        });

        holder.img_pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setOnItemClickListener(AddressAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_addressType)
        AppCompatTextView tv_addressType;
        @BindView(R.id.tv_city)
        AppCompatTextView tv_city;
        @BindView(R.id.addressTextView)
        AppCompatTextView addressTextView;
        @BindView(R.id.img_pen)
        AppCompatImageView img_pen;


        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
