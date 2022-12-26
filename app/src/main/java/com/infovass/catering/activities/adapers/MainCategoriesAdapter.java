package com.infovass.catering.activities.adapers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.home.model.RestourentModeResponse;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import java.util.List;

public class MainCategoriesAdapter extends RecyclerView.Adapter<MainCategoriesAdapter.CustomViewHolder> {

    public Context context;
    public static List<RestourentModeResponse.Item> datalist;
    List<RestourentModeResponse.Item> datalist_filter;
    Boolean f=false;

    public interface OnItemClickListener {
        void onItemClick(int postion, int vertPos, Integer id);
        void OnViewList();
    }

    public void setOnItemClickListener(MainCategoriesAdapter.OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public OnItemClickListener listener;

    public MainCategoriesAdapter(Context context, List<RestourentModeResponse.Item> arrayList) {
        this.context = context;
        datalist = arrayList;
        datalist_filter = arrayList;

    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewtype) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_item_list, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return datalist_filter.size();
    }


    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int i) {
        holder.setIsRecyclable(false);

        RestourentModeResponse.Item item = datalist_filter.get(i);
        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("ar")) {
            holder.txt_title.setText(item.getCategoryNameAr());
        }
        if (SharedPreferencesUtils.getInstance(context).getValue(Constants.Language, "").equalsIgnoreCase("en")) {
            holder.txt_title.setText(item.getCategoryName());
        }

//        holder.bind(i, new ActivityModal(), listener);
        ResturentMenuAdapter adapter = new ResturentMenuAdapter(context, item.getItems(), i);

        adapter.setOnItemClickListener(new ResturentMenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int verPos, Integer id) {
                listener.onItemClick(position, verPos, id);
            }
        });
        holder.ll_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnViewList();
                if (f)
                {
                    holder.mrecylerView.setVisibility(View.GONE);
                    f=false;
                    holder.iv_list.setBackgroundResource(R.drawable.ic_arrow_drop_down_black_24dp);
                }
                else {
                    f=true;
                    holder.mrecylerView.setVisibility(View.VISIBLE);
                    holder.iv_list.setBackgroundResource(R.drawable.ic_arrow_drop_up_black_24dp);
                }
            }
        });

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);


        holder.mrecylerView.setLayoutManager(linearLayoutManager);
        holder.mrecylerView.setAdapter(adapter);

//        SnapHelper snapHelper = new LinearSnapHelper();
//        snapHelper.findSnapView(linearLayoutManager);
//        snapHelper.attachToRecyclerView(holder.mrecylerView);


    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView txt_title;
        RecyclerView mrecylerView;
        ImageView iv_list;
        LinearLayout ll_list;

        public CustomViewHolder(View view) {
            super(view);
            txt_title = view.findViewById(R.id.tv_title);
            mrecylerView = view.findViewById(R.id.rv_list);
            iv_list=view.findViewById(R.id.iv_list);
            ll_list=view.findViewById(R.id.ll_list);


        }

//        public void bind(final int pos, final ActivityModal item, final MainCategoriesAdapter.OnItemClickListener listener) {


    }

}
