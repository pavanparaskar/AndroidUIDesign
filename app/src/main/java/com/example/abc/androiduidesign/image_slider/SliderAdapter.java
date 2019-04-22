package com.example.abc.androiduidesign.image_slider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.abc.androiduidesign.R;

/**
 * Created by ABC on 14-11-2018.
 */

public class SliderAdapter extends PagerAdapter {
    public Context mContext;
    public LayoutInflater layoutInflater;

    int[] imageSlider = {R.drawable.bitcoin,
            R.drawable.chat,
            R.drawable.date,
            R.drawable.contact,
            R.drawable.kubadge,
            R.drawable.sn};

    public SliderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageSlider.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view_item = layoutInflater.inflate(R.layout.slider_product, container, false);
        ImageView imageView = view_item.findViewById(R.id.slider_image);

        imageView.setImageResource(imageSlider[position]);
        container.addView(view_item);

        return view_item;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
         container.removeView((LinearLayout) object);
    }
}
