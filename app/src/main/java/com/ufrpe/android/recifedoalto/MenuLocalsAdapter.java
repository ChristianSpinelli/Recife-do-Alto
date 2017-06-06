package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 01/06/2017.
 */

public class MenuLocalsAdapter extends BaseAdapter {

    private final Activity mActivity;
    private final ArrayList<Local> mLocals;

    public MenuLocalsAdapter( ArrayList<Local> locals, Activity activity) {
        mActivity = activity;
        mLocals = locals;
    }

    @Override
    public int getCount() {
        return mLocals.size();
    }

    @Override
    public Object getItem(int position) {
        return mLocals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int image = mLocals.get(position).getImageMap();

        ImageView img = new ImageView(mActivity);
        img.setImageResource(image);
        img.setAdjustViewBounds(true);
        img.setMaxHeight(300);
        img.setScaleType(ImageView.ScaleType.FIT_XY);


        return img ;
    }
}
