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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.cart.model.CartResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterCartItemList extends RecyclerView.Adapter<AdapterCartItemList.Viewholder> {

    AddOnCartAdapters addOnCartAdapters;
    ItemsCartAdapters itemsAdapters;
    int row_index;
    Context context;
    AdapterCartItemList.OnItemClickListener onItemClickListener;
    String lastValue = "";
    List<CartResponse.Data.MainItem> items = new ArrayList<>();
    List<CartResponse.Data.MainItem.AddonIteam> addonItems = new ArrayList<>();
    public AdapterCartItemList(Context context , List<CartResponse.Data.MainItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public AdapterCartItemList.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cart_menu_item, parent, false);
        AdapterCartItemList.Viewholder viewholder = new AdapterCartItemList.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCartItemList.Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        

        try {
            if(items.get(position).getAddonIteam().size()==0)
            {
                holder.lnr_addOns.setVisibility(View.GONE);
            }else {
                holder.lnr_addOns.setVisibility(View.VISIBLE);

                itemsAdapters = new ItemsCartAdapters(context , items.get(position).getMeals());
                holder.cartMealItems.setHasFixedSize(true);
                holder.cartMealItems.setLayoutManager(new LinearLayoutManager(context));
                holder.cartMealItems.setAdapter(itemsAdapters);
//                itemsAdapters.setOnItemClickListener(new ItemsAdapters.OnItemClickListener() {
//                    @Override
//                    public void onClickaddOnMin(int position, AppCompatTextView tv_femailServiceCount) {
//                        try {
//                            int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
//                            itemCount = itemCount - 1;
//                            if (itemCount<0) {
//                                Toast.makeText(context, "Cannot set item count -ve.", Toast.LENGTH_SHORT).show();
//                            } else {
//                                tv_femailServiceCount.setText("" + itemCount);
//                                Double total = totalAmount-addons.get(position).getPrice();
//                                totalAmount = total;
//                                tv_total.setText(total+" KWD");
//                            }
//                        } catch (Exception g) { }
//                    }
//
//                    @Override
//                    public void onClickaddOnMax(int position, AppCompatTextView tv_femailServiceCount) {
//                        try {
//                            int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
//                            itemCount = itemCount + 1;
//                            tv_femailServiceCount.setText("" + itemCount);
//                            Double total = totalAmount+addons.get(position).getPrice();
//                            totalAmount = total;
//                            tv_total.setText(total+" KWD");
//                        } catch (Exception g) {
//                        }
//                    }
//
//                });

                addOnCartAdapters = new AddOnCartAdapters(context , items.get(position).getAddonIteam());
                holder.cartAddOnItemList.setLayoutManager(new LinearLayoutManager(context));
                holder.cartAddOnItemList.setAdapter(addOnCartAdapters);
//                addOnCartAdapters.setOnItemClickListener(new AddOnCartAdapters.OnItemClickListener() {
//                    @Override
//                    public void onClickaddOnMin(int position, AppCompatTextView tv_femailServiceCount) {
//                        try {
//                            int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
//                            itemCount = itemCount - 1;
//                            if (itemCount == 0) {
//                                Toast.makeText(context, "Cannot set item count 0.", Toast.LENGTH_SHORT).show();
//                            } else {
//                                tv_femailServiceCount.setText("" + itemCount);
////                                int total = totalAmount-items.get(position).getCost();
////                                totalAmount = total;
////                                tv_total.setText(total+" KWD");
//                            }
//                        } catch (Exception g) { }
//                    }
//
//                    @Override
//                    public void onClickaddOnMax(int position, AppCompatTextView tv_femailServiceCount) {
//                        try {
//                            int itemCount = Integer.parseInt(tv_femailServiceCount.getText().toString());
//                            itemCount = itemCount + 1;
//                            tv_femailServiceCount.setText("" + itemCount);
////                            int total = totalAmount+items.get(position).getCost();
////                            totalAmount = total;
////                            tv_total.setText(total+" KWD");
//                        } catch (Exception g) {
//                        }
//                    }
//                });
            }
        }catch (Exception g){}
        try {
            if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar"))
            {
                holder.mealNameTextView.setText(items.get(position).getIteam().getArabicItemName());
                holder.tv_for_persons.setText(" ل "+items.get(position).getIteam().getItemServingCapacity()+" الأشخاص ");
                holder.tv_productPrice.setText(""+items.get(position).getCost()+" KWD");
                holder.tv_productCount.setText(""+items.get(position).getQuantity());
            }

            if(SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en"))
            {
                holder.mealNameTextView.setText(items.get(position).getIteam().getItemName());
                holder.tv_for_persons.setText("For "+items.get(position).getIteam().getItemServingCapacity()+" Persons");
                holder.tv_productPrice.setText(""+items.get(position).getCost()+" KWD");
                holder.tv_productCount.setText(""+items.get(position).getQuantity());
            }
        }catch (Exception j){}

        try {
            Picasso.get().load(""+items.get(position).getIteam().getItemLogoPath()).error(R.drawable.gradient).placeholder(R.drawable.gradient).into(holder.image_product);
        }
        catch (Exception ex)
        { }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   onItemClickListener.onItemClick(position ,holder.custom_tab_textView,holder.detail_item_linearLayout );
            }
        });

        holder.img_minButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onminClick(position ,holder.tv_productCount);
            }
        });

        holder.lnr_addOns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onAddOnClick(position ,holder.cartAddOnItemList , holder.tv_addOns , holder.img_arrow);
            }
        });

        holder.img_maxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onmaxClick(position ,holder.tv_productCount);
            }
        });

        holder.deleteOrderItemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.deleteItem(position);
            }
        });

    }

    public void setOnItemClickListener(AdapterCartItemList.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.mealNameTextView)
        AppCompatTextView mealNameTextView;
        @BindView(R.id.tv_for_persons)
        AppCompatTextView tv_for_persons;
        @BindView(R.id.tv_productPrice)
        AppCompatTextView tv_productPrice;
        @BindView(R.id.tv_productCount)
        AppCompatTextView tv_productCount;
        @BindView(R.id.img_minButton)
        AppCompatImageView img_minButton;
        @BindView(R.id.img_maxButton)
        AppCompatImageView img_maxButton;
        @BindView(R.id.image_product)
        RoundedImageView image_product;
        @BindView(R.id.deleteOrderItemImage)
        AppCompatImageView deleteOrderItemImage;
        @BindView(R.id.cartAddOnItemList)
        RecyclerView cartAddOnItemList;
        @BindView(R.id.lnr_addOns)
        LinearLayout lnr_addOns;
        @BindView(R.id.tv_addOns)
        AppCompatTextView tv_addOns;
        @BindView(R.id.img_arrow)
        AppCompatImageView img_arrow;
        @BindView(R.id.cartMealItems)
        RecyclerView cartMealItems;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position , TextView custom_tab_textView , LinearLayout detail_item_linearLayout);
        void onminClick(int position ,AppCompatTextView tv_productCount);
        void onmaxClick(int position ,AppCompatTextView tv_productCount);
        void deleteItem(int position);
        void onAddOnClick(int position ,RecyclerView cartAddOnItemList ,AppCompatTextView tv_addOns , AppCompatImageView img_arrow);
    }
}