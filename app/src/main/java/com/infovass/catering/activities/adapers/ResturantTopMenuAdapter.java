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
import com.infovass.catering.activities.DataModel.RD_TopRankedCaterersItem;
import com.infovass.catering.activities.home.model.RestourentListResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResturantTopMenuAdapter extends RecyclerView.Adapter<ResturantTopMenuAdapter.Viewholder> {

    Context context;
    ResturantTopMenuAdapter.OnItemClickListener onItemClickListener;
    String lastValue = "";
    ArrayList<RD_TopRankedCaterersItem> restourentLIst = new ArrayList<>();
    int selectedposition;

    public ResturantTopMenuAdapter(Context context, ArrayList<RD_TopRankedCaterersItem> restourentLIst) {
        this.context = context;
        this.restourentLIst = restourentLIst;
    }

    @NonNull
    @Override
    public ResturantTopMenuAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custum_item_top_menu, parent, false);
        ResturantTopMenuAdapter.Viewholder viewholder = new ResturantTopMenuAdapter.Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResturantTopMenuAdapter.Viewholder holder, @SuppressLint("RecyclerView") final int position) {


        RD_TopRankedCaterersItem resRDAta = restourentLIst.get(position);

        try {
            Picasso.get().load(resRDAta.getItem_logo()).into(holder.menuRoImg);

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
            Log.i("UUUIUIU", "UIUIUIU");
            holder.mainResNameTxt.setText("" + restourentLIst.get(position).getItem_name_arabic());
            holder.priceTxt.setText("" + restourentLIst.get(position).getItem_cost_per_serve()+" د.ك "+" ");
            holder.resNameTxt.setText("" + restourentLIst.get(position).getCaterer().getArabic_name());
        }

        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {

            holder.mainResNameTxt.setText("" + restourentLIst.get(position).getItem_name());
            holder.priceTxt.setText("" + restourentLIst.get(position).getItem_cost_per_serve()+" KD");
            holder.resNameTxt.setText("" + restourentLIst.get(position).getCaterer().getName());
        }



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedposition = position;
//                onItemClickListener.onItemClick(position, selectedposition, Restaurant_Status, restourentLIst);
                onItemClickListener.onItemClick(position, selectedposition, restourentLIst);
            }
        });
    }

    public void setOnItemClickListener(ResturantTopMenuAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<RD_TopRankedCaterersItem> filterlist) {
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
        @BindView(R.id.priceTxt)
        TextView priceTxt;
        @BindView(R.id.resNameTxt)
        TextView resNameTxt;



        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, int selectedposition , ArrayList<RD_TopRankedCaterersItem> restourentLIst);
    }
}





