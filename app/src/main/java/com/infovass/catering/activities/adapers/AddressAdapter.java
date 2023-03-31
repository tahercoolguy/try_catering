package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
            String newAddress;
            newAddress = context.getString(R.string.governate) + " " + list.get(position).getCity() + ", " +
                    context.getString(R.string.area) + " " + list.get(position).getArea() + ", " +
                    context.getString(R.string.block) + " " + list.get(position).getBlock() + ", " +
                    context.getString(R.string.street) + " " + list.get(position).getStreet() + ", " +
                    context.getString(R.string.avenue_a) + " " + list.get(position).getAvenue() + ", " +
                    context.getString(R.string.building) + " " + list.get(position).getAppartment() + ", " +
                    context.getString(R.string.floor) + " " + list.get(position).getHouseNo() + ". ";
            holder.addressTextView.setText(newAddress);
        }

        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
            holder.tv_addressType.setText(list.get(position).getAddressType());
            holder.tv_city.setText(list.get(position).getLandmark());

            String newAddress;
            newAddress = context.getString(R.string.governate) + " " + list.get(position).getCity() + ", " +
                    context.getString(R.string.area) + " " + list.get(position).getArea() + ", " +
                    context.getString(R.string.block) + " " + list.get(position).getBlock() + ", " +
                    context.getString(R.string.street) + " " + list.get(position).getStreet() + ", " +
                    context.getString(R.string.avenue_a) + " " + list.get(position).getAvenue() + ", " +
                    context.getString(R.string.building) + " " + list.get(position).getAppartment() + ", " +
                    context.getString(R.string.floor) + " " + list.get(position).getHouseNo() + ". ";
            holder.addressTextView.setText(newAddress);
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

                onItemClickListener.onEditAddressItemClick(position,
                        list.get(position).getId().toString(),
                        list.get(position).getCity(),
                        list.get(position).getArea(),
                        list.get(position).getBlock(),
                        list.get(position).getStreet(),
                        list.get(position).getAvenue(),
                        list.get(position).getAppartment(),
                        list.get(position).getHouseNo(),
                        list.get(position).getAddressType(),
                        list.get(position).getLat(),
                        list.get(position).getLng()
                );
            }
        });

        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onDeleteAddressItemClick(position, list.get(position).getId().toString());
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
        @BindView(R.id.img_delete)
        AppCompatImageView img_delete;


        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onEditAddressItemClick(int position, String id, String city, String Area, String Block, String Street, String Avenue, String Apartment, String HouseNumber,String AddressType,String lattitude,String longitude);

        void onDeleteAddressItemClick(int position, String id);
    }
}
