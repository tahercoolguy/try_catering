package com.infovass.catering.activities.adapers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.infovass.catering.R;
import com.infovass.catering.activities.DataModel.RD_caterers_TopRankeCaterers;
import com.infovass.catering.activities.home.model.RestourentListResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResturantTopRestaurentAdapter extends RecyclerView.Adapter<ResturantTopRestaurentAdapter.Viewholder> {

    Context context;
    ResturantTopRestaurentAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    ArrayList<RD_caterers_TopRankeCaterers> restourentLIst = new ArrayList<>();
    int selectedposition;

    public ResturantTopRestaurentAdapter(Context context, ArrayList<RD_caterers_TopRankeCaterers> restourentLIst) {
        this.context = context;
        this.restourentLIst = restourentLIst;
    }

    @NonNull
    @Override
    public ResturantTopRestaurentAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custum_item_top_restaurents, parent, false);
        ResturantTopRestaurentAdapter.Viewholder viewholder = new ResturantTopRestaurentAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResturantTopRestaurentAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {


        RD_caterers_TopRankeCaterers resRDAta = restourentLIst.get(position);

        try {
            if (resRDAta.getCover_image() != null && resRDAta.getCover_images().size() > 0)
                Picasso.get().load(resRDAta.getCover_images().get(0).getCover_image_path()).into(holder.menuRoImg);
            else
                Picasso.get().load(resRDAta.getCover_image_path()).into(holder.menuRoImg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        int Restaurant_Status = Integer.parseInt(resRDAta.getRestaurant_Status());
        String resModeid = String.valueOf(resRDAta.getModes().get(0).getId());
        String resStatus = String.valueOf(resRDAta.getRestaurant_Status());
        try {



//            if (resModeid.equalsIgnoreCase("2")) {
//                holder.img_delevery.setVisibility(View.VISIBLE);
//                holder.img_delevery.setImageResource(R.drawable.ic_deleivery);
//
//            } else {
//                holder.img_delevery.setVisibility(View.INVISIBLE);
//            }
//            if (resModeid.equalsIgnoreCase("1")) {
//                holder.img_catering.setImageResource(R.drawable.ic_catering);
//                holder.img_catering.setVisibility(View.VISIBLE);
//
//            } else {
//                holder.img_catering.setVisibility(View.INVISIBLE);
//            }
//            if (resStatus.equalsIgnoreCase("1")) {
//                holder.img_table.setImageResource(R.drawable.busyicon);
//                holder.img_table.setVisibility(View.VISIBLE);
//            } else {
//                holder.img_table.setVisibility(View.INVISIBLE);
//            }


//            if (resModeid.equalsIgnoreCase("2")
//                    && resModeid.equalsIgnoreCase("1")) {
//                holder.img_delevery.setImageResource(R.drawable.ic_deleivery);
//                holder.img_catering.setImageResource(R.drawable.ic_catering);
//            }

//            Picasso.get().load(restourentLIst.get(position).getModes().get(0).getImagePath()).into(holder.img_delevery);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        try {
//            Picasso.get().load(""+restourentLIst.get(position).getModes().get(1).getImagePath()).into(holder.img_table);
//        }
//        catch (Exception ex)
//        {}
//
//        try {
//            if (Objects.equals(restourentLIst.get(position).getRestaurantStatus(), "1")){
//               // Picasso.get().load(""+restourentLIst.get(position).getModes().get(2).getImagePath()).error(R.drawable.add).placeholder(R.drawable.ic_loader).into(holder.img_catering);
//                holder.img_catering.setBackgroundResource(R.drawable.busyicon);
//            }
//            else {
//                Picasso.get().load(""+restourentLIst.get(position).getModes().get(2).getImagePath()).into(holder.img_catering);
//            }
//           // Picasso.get().load(""+restourentLIst.get(position).getModes().get(2).getImagePath()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(holder.img_catering);
//        }
//        catch (Exception ex)
//        {}

//        try {
//            holder.simpleRatingBar.setRating(Float.parseFloat("" + restourentLIst.get(position).getRating()));
//        } catch (Exception ex) {
//        }

        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
            Log.i("UUUIUIU", "UIUIUIU");
            holder.mainResNameTxt.setText("" + restourentLIst.get(position).getArabic_name());
            holder.resNameTxt.setText("" + restourentLIst.get(position).getArabic_detail());
        }

        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
            Log.i("UUUIUIU", "" + restourentLIst.get(position).getName());
            holder.mainResNameTxt.setText("" + restourentLIst.get(position).getName());
            holder.resNameTxt.setText("" + restourentLIst.get(position).getDetail());
        }


//        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position, Restaurant_Status));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedposition = position;
                onItemClickListener.onItemClick(position, selectedposition, Restaurant_Status, restourentLIst);
            }
        });
    }

    public void setOnItemClickListener(ResturantTopRestaurentAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<RD_caterers_TopRankeCaterers> filterlist) {
        // below line is to add our filtered
        // list in our course array list.
        restourentLIst = filterlist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return restourentLIst.size();
    }

    // Expense list item view holder
    @SuppressLint("NonConstantResourceId")
    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.menuRoImg)
        RoundedImageView menuRoImg;


        @BindView(R.id.clickLL)
        LinearLayout clickLL;

        @BindView(R.id.mainResNameTxt)
        TextView mainResNameTxt;


        @BindView(R.id.resNameTxt)
        TextView resNameTxt;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, int selectedposition, int Restaurant_Status, List<RD_caterers_TopRankeCaterers> restourentLIst);
    }
}





