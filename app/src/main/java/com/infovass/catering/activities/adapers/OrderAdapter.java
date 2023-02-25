package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.order.model.OrderListResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.Viewholder> {

    int row_index;
    Context context;
    OrderAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<OrderListResponse.Datum> list = new ArrayList<>();
    public OrderAdapter(Context context ,List<OrderListResponse.Datum> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OrderAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.order_item, parent, false);
        OrderAdapter.Viewholder viewholder = new OrderAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // on the below line we are finishing
                // our current activity.
                holder.itemView.startAnimation(animation);

            }
        }, 100);

        holder.orderNameTextView.setText("Order NO : "+list.get(position).getInvoiceId());
        holder.dateTextView.setText(""+list.get(position).getCreatedAt());
        holder.tv_price.setText(list.get(position).getTotalAmount()+" KWD");
        holder.paymentTextView.setText(list.get(position).getOrderStatus());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   onItemClickListener.onItemClick(position ,holder.custom_tab_textView,holder.detail_item_linearLayout );
            }
        });
    }

    public void setOnItemClickListener(OrderAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.orderNameTextView)
        AppCompatTextView orderNameTextView;
        @BindView(R.id.paymentTextView)
        AppCompatTextView paymentTextView;
        @BindView(R.id.dateTextView)
        AppCompatTextView dateTextView;
        @BindView(R.id.tv_price)
        AppCompatTextView tv_price;


        public Viewholder(View itemView) {
            super(itemView);
             ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position , TextView custom_tab_textView , LinearLayout detail_item_linearLayout);
    }
}
