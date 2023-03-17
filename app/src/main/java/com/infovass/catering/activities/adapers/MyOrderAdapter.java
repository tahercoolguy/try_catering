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

import com.github.siyamed.shapeimageview.RoundedImageView;
import com.infovass.catering.DM.AddonsDM;
import com.infovass.catering.R;
import com.infovass.catering.activities.order.model.OrderListResponse;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.Viewholder> {

    int row_index;
    Context context;
    MyOrderAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<AddonsDM> list = new ArrayList<>();
    public MyOrderAdapter(Context context , List<AddonsDM> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyOrderAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custum_item_order_detail, parent, false);
        MyOrderAdapter.Viewholder viewholder = new MyOrderAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        

        holder.titleTxt.setText(list.get(position).getTittle());
        holder.imgRIV.setImageResource(list.get(position).getImg());
         holder.priceTxt.setText(list.get(position).getPrice()+" KWD");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   onItemClickListener.onItemClick(position ,holder.custom_tab_textView,holder.detail_item_linearLayout );
            }
        });
    }

    public void setOnItemClickListener(MyOrderAdapter.OnItemClickListener onItemClickListener) {
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
