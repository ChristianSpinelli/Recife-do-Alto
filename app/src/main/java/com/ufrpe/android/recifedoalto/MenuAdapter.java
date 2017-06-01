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

    private final ArrayList<Integer> mMenuImages;
    private final Activity mActivity;

    public MenuAdapter(ArrayList<Integer> menuImages, Activity activity) {
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
        View view = mActivity.getLayoutInflater().inflate(R.layout.fragment_menu,parent,false);
        int image = mMenuImages.get(position);

        final ImageView img = (ImageView) view.findViewById(R.id.menu_img);

        img.setImageResource(image);


        return view;
    }
}
