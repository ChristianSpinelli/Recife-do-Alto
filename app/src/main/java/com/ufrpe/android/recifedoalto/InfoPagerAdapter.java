package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 27/06/2017.
 */

public class InfoPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<InfoImage> mInfoImages;
    private Activity mActivity;

    public InfoPagerAdapter(FragmentManager fm, ArrayList<InfoImage> infoImages, Activity activity) {
        super(fm);
        mInfoImages = infoImages;
        mActivity = activity;
    }


    @Override
    public Fragment getItem(int position) {
        return new InfoFragment(position);
    }

    @Override
    public int getCount() {
        return mInfoImages.size();
    }
}
