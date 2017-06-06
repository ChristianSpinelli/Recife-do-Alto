package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * Created by Christian Spinelli on 31/05/2017.
 */

public class MenuAdapter extends BaseAdapter {

    private final ArrayList<Area> mMenuImages;
    private final Activity mActivity;

    public MenuAdapter(ArrayList<Area> menuImages, Activity activity) {
        mMenuImages = menuImages;
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return mMenuImages.size();
    }

    @Override
    public Object getItem(int position) {
        return mMenuImages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int image = mMenuImages.get(position).getImg();

        ImageView img = new ImageView(mActivity);

        img.setImageResource(image);
        img.setAdjustViewBounds(true);
        img.setMaxHeight(500);
        img.setScaleType(ImageView.ScaleType.FIT_XY);


        return img;
    }
}
