package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.siyamed.shapeimageview.RoundedImageView;
import com.infovass.catering.DM.AddonsDM;
import com.infovass.catering.DM.Order_DetailsDM.Data;
import com.infovass.catering.DM.Order_DetailsDM.OrderIteam;
import com.infovass.catering.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Order_DetailAdapter extends RecyclerView.Adapter<Order_DetailAdapter.Viewholder> {

    int row_index;
    Context context;
    Order_DetailAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    ArrayList<OrderIteam> list = new ArrayList<>();
    public Order_DetailAdapter(Context context , ArrayList<OrderIteam> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Order_DetailAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custum_item_order_detail, parent, false);
        Order_DetailAdapter.Viewholder viewholder = new Order_DetailAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Order_DetailAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        

        holder.titleTxt.setText(list.get(position).getIteam().getItem_name());
         Picasso.get().load(list.get(position).getIteam().getItem_logo_path()).into(holder.imgRIV);
         holder.priceTxt.setText(list.get(position).getTotal_price()+" KWD");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   onItemClickListener.onItemClick(position ,holder.custom_tab_textView,holder.detail_item_linearLayout );
            }
        });
    }

    public void setOnItemClickListener(Order_DetailAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.addOnsTxt)
        TextView addOnsTxt;
        @BindView(R.id.priceTxt)
        TextView priceTxt;
        @BindView(R.id.titleTxt)
        TextView titleTxt;
        @BindView(R.id.imgRIV)
        RoundedImageView imgRIV;


        public Viewholder(View itemView) {
            super(itemView);
             ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position , TextView custom_tab_textView , LinearLayout detail_item_linearLayout);
    }
}
