package com.infovass.catering.activities.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
 import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.infovass.catering.MyFormat.MyDM.Image;
import com.infovass.catering.MyFormat.MyDM.Image_;
import com.infovass.catering.R;
import com.infovass.catering.activities.home.model.RestourentDetailResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RestourentDetailsIBN extends PagerAdapter {
    // Context object
    Context context;

    // Array of images
    // int[] images;
    ArrayList<Image> bookList = new ArrayList<>();

    // Layout Inflater
    LayoutInflater mLayoutInflater;


    // Viewpager Constructor
    public RestourentDetailsIBN(Context context, ArrayList<Image> bookList) {
        this.context = context;
        this.bookList = bookList;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // return the number of images
        return bookList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((RelativeLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        // inflating the item.xml
        View itemView = mLayoutInflater.inflate(R.layout.imagei_viewpager_tem, container, false);

        // referencing the image view from the item.xml file
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);

        // setting the image in the imageView
//        imageView.setImageResource((bookList.get(position).getImage()));
       // Glide.with(context).load(bookList.get(position).getCover_image_path()).into(imageView);
//        Picasso.get().load("" + bookList.get(position).getCover_image_path()).error(R.drawable.logo_rec).placeholder(R.drawable.ic_loader).into(imageView);
        Picasso.get().load("" + bookList.get(position).getCover_image_path()).into(imageView);
//        Picasso.get().load("" + productDetailResponse.getData().getItemLogoPath()).into(img_productImage);

        // Adding the View
        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout) object);
    }
}
